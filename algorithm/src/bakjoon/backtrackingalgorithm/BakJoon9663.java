package bakjoon.backtrackingalgorithm;

import java.util.Arrays;
import java.util.Scanner;

// N-Queen col(세로,열) row(가로,행) -> col 의 인덱스 -> 현재 열 , col 의 값 -> 그 열의 몇 번째에 놓인지
public class BakJoon9663 {
    static int[] col;
    static int result = 0;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N];
        Arrays.fill(col, -1);
        dfs(0);
        System.out.println(result);
    }

    static void dfs(int depth) {
        if (depth == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            col[depth] = i;
            if (check(depth)) {
                dfs(depth + 1);
            }
        }
    }

    static boolean check(int depth) {
        for (int i = 0; i < depth; i++) { // 0열부터 현재 열까지 내려오면서 비교
            // 같은 열인지 또는 대각선인지
            if (col[i] == col[depth] || Math.abs(col[i] - col[depth]) == Math.abs(i - depth)) {
                return false;
            }
        }
        return true;
    }
}
