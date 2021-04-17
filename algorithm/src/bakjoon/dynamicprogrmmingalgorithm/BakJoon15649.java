package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

public class BakJoon15649 {
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[M]; // 정수의 개수
        visit = new boolean[N]; // 몇 개 붙여서 낼지
        dfs(N, M, 0);
        System.out.println(sb);
    }

    static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int check : arr) {
                sb.append(check).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }

    }
}
