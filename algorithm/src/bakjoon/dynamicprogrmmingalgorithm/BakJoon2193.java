package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

// 이친수
public class BakJoon2193 {
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 5; // 피보나치네!!

        fibonacci(N);
        System.out.println(dp[N]);
    }

    static long fibonacci(int N) {
        if (dp[N] != 0) {
            return dp[N];
        }

        return dp[N] = fibonacci(N - 1) + fibonacci(N - 2);
    }
}

