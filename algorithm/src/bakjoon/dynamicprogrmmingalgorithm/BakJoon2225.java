package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

// 합 분해 -> 0 + 3 과 3 + 0 은 다른 것
public class BakJoon2225 {
    static int N, K;
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        dp = new long[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][1] = 1;
        }

        System.out.println(dfs(N, K));
    }

    static long dfs(int n, int k) {
        if (dp[n][k] != 0) {
            return dp[n][k];
        }

        long sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += dfs(i, k - 1);
        }
        return dp[n][k] = sum % 1000000000;
    }
}

// 내가 생각한 점화식 : dp[N][K] = dp[N][K-1] + dp[N-1][K-1] + ... dp[0][K-1];