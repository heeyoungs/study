package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.*;

public class BakJoon1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] inputLine = br.readLine().split(" ");
        int nodeCount = Integer.parseInt(inputLine[0]);
        int lineCount = Integer.parseInt(inputLine[1]);
        int startIndex = Integer.parseInt(inputLine[2]);
        Graph graph = new Graph(nodeCount);

        for (int i=0;i<lineCount;i++){
            String[] input = br.readLine().split(" ");
            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);

            graph.addEdge(first,second);
        }
        graph.dfsR(startIndex);
        bw.write("\n");
        graph.bfs(startIndex);

        bw.flush();
        bw.close();
        br.close();
    }

    static class Graph{
        class Node{
            int data;
            boolean marked;
            LinkedList<Node> adjacent;
            Node(int data){
                this.data = data;
                this.marked = false;
                this.adjacent = new LinkedList<>();
            }
        }

        Node[] nodes;

        Graph(int size){
            nodes = new Node[size+1];
            for(int i=0;i<size+1;i++){
                nodes[i] = new Node(i);
            }
        }

        void addEdge(int i1, int i2){
            Node a = nodes[i1];
            Node b = nodes[i2];
            if (!a.adjacent.contains(b)){
                a.adjacent.add(b);
            }
            if (!b.adjacent.contains(a)){
                b.adjacent.add(a);
            }
        }

        void bfs(int index) throws IOException {
            reset();
            Sort();
            Queue<Node> queue = new LinkedList<>();
            Node root = nodes[index];
            root.marked = true;
            queue.add(root);
            while(!queue.isEmpty()){
                Node r = queue.poll();
                if (r!=null){
                    for (Node n :r.adjacent){
                        if (n.marked == false){
                            queue.add(n);
                            n.marked = true;
                        }
                    }
                }
                bw.write(r.data + " ");
            }
        }

        void reset(){
            for (Node n : nodes){
                n.marked = false;
            }
        }

        void dfsR(Node r) throws IOException {
            if ( r == null) {
                return;
            }
            Sort();
            r.marked = true;
            bw.write(r.data + " ");
            for (Node n : r.adjacent){
                if (n.marked == false){
                    dfsR(n);
                }
            }
        }

        void dfsR(int index) throws IOException {
            Node r = nodes[index];
            dfsR(r);
        }

        void Sort(){
            for (Node n: nodes) {
                Collections.sort(n.adjacent, new Comparator<>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        if (o1.data > o2.data) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                });
            }
        }
    }
}
