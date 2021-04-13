package bakjoon.bintreealgorithm;

import java.io.*;
import java.util.LinkedList;

public class BakJoon11725 {
    static int[] arr;
    static boolean[] visit;
    static int nodeCount;
    static LinkedList<Integer>[] linkedList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        nodeCount = Integer.parseInt(br.readLine());
        arr = new int[nodeCount + 1];
        visit = new boolean[nodeCount + 1];
        linkedList = new LinkedList[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            linkedList[i] = new LinkedList<>();
        }

        for (int i = 0; i < nodeCount - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            linkedList[a].add(b);
            linkedList[b].add(a);
        }

        dfs(1); // 1부터 깊이 탐색을 하면서 부모를 찍어주기

        for (int i = 2; i <= nodeCount; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int index) { // 재귀 -> index 가 node 의 부모이다.
        visit[index] = true;
        for (int node : linkedList[index]) {
            if (visit[node] == false) {
                arr[node] = index; // 부모값을 저장
                dfs(node);
            }
        }
    }
}


