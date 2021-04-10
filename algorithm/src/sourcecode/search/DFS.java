package sourcecode.search;

import java.util.LinkedList;
import java.util.Stack;

public class DFS {
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
        g.dfs();
        g.reset();
        System.out.println();
        g.dfsR();
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

        Graph.Node[] nodes;

        Graph(int size) {
            nodes = new Graph.Node[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new Graph.Node(i);
            }
        }

        void addEdge(int i1, int i2) {
            Graph.Node n1 = nodes[i1];
            Graph.Node n2 = nodes[i2];
            if (!n1.adjacent.contains(n2)) {
                n1.adjacent.add(n2);
            }
            if (!n2.adjacent.contains(n1)) {
                n2.adjacent.add(n1);
            }
        }

        // 그냥
        void dfs() {
            dfs(0);
        }

        void dfs(int index) {
            Graph.Node root = nodes[index];
            Stack<Graph.Node> stack = new Stack<>();
            stack.push(root);
            root.marked = true;
            while (!stack.isEmpty()) {
                Graph.Node r = stack.pop();
                for (Graph.Node n : r.adjacent) {
                    if (n.marked == false) {
                        n.marked = true;
                        stack.push(n);
                    }
                }
                System.out.print(r.data + " ");
            }

        }

        // 재귀
        void dfsR(Node r){
            if ( r == null) {
                return;
            }
            r.marked = true;
            System.out.print(r.data + " ");
            for (Node n : r.adjacent){
                if (n.marked == false){
                    dfsR(n);
                }
            }
        }

        void dfsR(int index){
            Node r = nodes[index];
            dfsR(r);
        }

        void dfsR(){
            dfsR(0);
        }

        //방문 초기화
        void reset(){
            for(Node n : nodes){
                n.marked = false;
            }
        }
    }
}


