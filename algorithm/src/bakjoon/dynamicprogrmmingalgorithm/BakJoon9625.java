package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

// BABBA
public class BakJoon9625 {
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new long[46];
        dp[1] = 1;
        dp[2] = 2;
        fibo(45);
        if (N == 1) System.out.println(0 + " " + 1);
        else if (N == 2) System.out.println(1 + " " + 1);
        else System.out.println(dp[N - 2] + " " + dp[N - 1]);
    }

    static long fibo(int k) {
        if (dp[k] != 0) return dp[k];

        return dp[k] = fibo(k - 1) + fibo(k - 2);
    }
}