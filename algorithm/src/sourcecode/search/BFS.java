package sourcecode.search;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(6,8);
        g.bfs(3);
    }

    static class Graph {
        class Node {
            int data;
            LinkedList<Graph.Node> adjacent;
            boolean marked;

            Node(int data) {
                this.data = data;
                this.marked = false; // 방문 여부
                this.adjacent = new LinkedList<>(); // 링크드리스트
            }
        }

        Node[] nodes;

        Graph(int size) {
            nodes = new Node[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new Node(i);
            }
        }

        void addEdge(int i1, int i2) {
            Node n1 = nodes[i1];
            Node n2 = nodes[i2];
            if (!n1.adjacent.contains(n2)) {
                n1.adjacent.add(n2);
            }
            if (!n2.adjacent.contains(n1)) {
                n2.adjacent.add(n1);
            }
        }

        void bfs(){
            bfs(0);
        }

        void bfs(int index){
            reset();
            Node root = nodes[index];
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            root.marked = true;
            while(!queue.isEmpty()){
                Node r = queue.poll();
                for (Node n : r.adjacent){
                    if (n.marked == false){
                        queue.add(n);
                        n.marked = true;
                    }
                }
                System.out.print(r.data + " ");
            }
        }

        // 방문 초기화
        void reset(){
            for (int i = 0; i < nodes.length; i++) {
                nodes[i].marked = false;
            }
        }
    }
}

