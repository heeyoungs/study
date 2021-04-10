package bakjoon.bintreealgorithm;

import java.io.*;

public class BakJoon11725_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nodeCount = Integer.parseInt(br.readLine());

        int[] array = new int[nodeCount + 1]; // 노드가 트리에 있는지 체크해주는 배열
        array[1] = 1;
        for (int i = 2; i <= nodeCount; i++) {
            array[i] = 0;
        }

        Tree tree = new Tree();

        // 이진 트리 구성 단계
        for (int i = 2; i <= nodeCount; i++) {
            String[] input = br.readLine().split(" ");
            int inputA = Integer.parseInt(input[0]);
            int inputB = Integer.parseInt(input[1]);
            int parentNode = 0;
            int childNode = 0;

            if (array[inputA] == 1) { // 이게 부모 노드
                parentNode = inputA;
                childNode = inputB;
            } else if (array[inputB] == 1) { // 이게 부모노드
                parentNode = inputB;
                childNode = inputA;
            }

            // 1. 부모노드가 트리의 어느 자리에 잇는지 찾아
            TreeNode parent = tree.findWhereNode(parentNode);

            // 2. 그 자리 왼쪽 or 오른쪽에 자식 노드를 채워 -> 자식 노드의 어레이 값을 1로 바꿔
            if (parent.linkL == null) {
                tree.childL(parent, childNode);
            } else {
                tree.childR(parent, childNode);
            }
            array[childNode] = 1;
        }

        bw.flush();
        bw.close();
        br.close();
    }
    public static class ParToChild{
        int parentNode;
        int childNode;
        ParToChild(int parentNode, int childNode){
            this.parentNode = parentNode;
            this.childNode = childNode;
        }
    }


    public static class TreeNode {
        int data;
        TreeNode linkR;
        TreeNode linkL;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static TreeNode hello = null;
    public static int stop = 0;

    public static class Tree {
        TreeNode root;

        Tree() {
            TreeNode newNode = new TreeNode(1);
            root = newNode;
        }

        public void childR(TreeNode node, int data) { // 오른쪽 자식 설정
            TreeNode newNode = new TreeNode(data);
            node.linkR = newNode;
        }

        public void childL(TreeNode node, int data) { // 왼쪽 자식 설정
            TreeNode newNode = new TreeNode(data);
            node.linkL = newNode;
        }

        public TreeNode findWhereNode(int data) { // data값을 가진 노드의 위치를 찾아서 반환
            search(root, data);
            TreeNode ret = hello;
            stop = 0;
            hello = null;
            return ret;
        }

        public void search(TreeNode node, int data) {
            if (node.data == data) {
                hello = node;
                stop = 1;
                return;
            }
            if (node.linkL != null && stop == 0) {
                search(node.linkL, data);
            }
            if (node.linkR != null && stop == 0) {
                search(node.linkR, data);
            }
        }


    }
}
