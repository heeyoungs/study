package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Arrays;
import java.util.Scanner;

// 제곱수의 합
public class BakJoon1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        int start = 1;
        while (start * start <= N) {
            start++;
        }
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int j = 1; j <= start; j++) {
            for (int i = j * j; i <= N; i++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        System.out.println(dp[N]);
    }
}
