package bakjoon.backtrackingalgorithm;

import java.util.Scanner;

public class BakJoon15650 {
    static int[] arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        arr = new int[M];
        dfs(1, 0);
        System.out.println(sb);
    }

    public static void dfs(int at, int depth) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs(i+1 , depth + 1);
        }
    }
}