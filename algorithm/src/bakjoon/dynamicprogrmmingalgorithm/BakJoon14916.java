package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Arrays;
import java.util.Scanner;

// 거스름돈
public class BakJoon14916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 2; i <= 100000; i++) {
            if (i % 2 == 0) {
                dp[i] = i / 2;
            }
        }
        for (int i = 5; i <= 100000; i++) {
            if (dp[i - 5] != Integer.MAX_VALUE/2) {
                dp[i] = Math.min(dp[i - 5] + 1, dp[i]);
            }
        }
        if (dp[N] == Integer.MAX_VALUE / 2) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}