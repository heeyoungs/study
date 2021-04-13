package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class BakJoon2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());
        Graph g = new Graph(computerCount);

        int lineCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < lineCount; i++) {
            String[] input = br.readLine().split(" ");
            int primary = Integer.parseInt(input[0]);
            int secondary = Integer.parseInt(input[1]);
            g.addEdge(primary, secondary);
        }
        g.dfs(1);
        System.out.println(computerCount - g.foundAns());
    }

    public static class Graph {
        class Node {
            int data;
            boolean marked;
            LinkedList<Node> adjacent;

            Node(int data) {
                this.data = data;
                this.marked = false;
                this.adjacent = new LinkedList<>();
            }
        }

        Node[] nodes;

        Graph(int index) {
            nodes = new Node[index+1];
            for (int i = 0; i < index+1; i++) {
                nodes[i] = new Node(i);
            }
        }

        void addEdge(int i1, int i2) {
            Node a = nodes[i1];
            Node b = nodes[i2];
            if (!a.adjacent.contains(b)) {
                a.adjacent.add(b);
            }
            if (!b.adjacent.contains(a)) {
                b.adjacent.add(a);
            }
        }

        void dfs(int index) {
            Node root = nodes[index];
            root.marked = true;
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node r = stack.pop();
                if (r != null) {
                    for (Node n : r.adjacent) {
                        if (n.marked == false) {
                            stack.push(n);
                            n.marked = true;
                        }
                    }
                }
            }
        }

        int foundAns() {
            int count = 0;
            for (Node n : nodes) {
                if (n.marked == false) {
                    count++;
                }
            }
            return count;
        }
    }
}
