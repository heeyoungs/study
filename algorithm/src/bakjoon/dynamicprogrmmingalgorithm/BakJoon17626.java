package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

// Four Squares
public class BakJoon17626 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int dp[] = new int[50001];
        dp[1] = 1;
        for (int i = 2; i <= 50000; i++) {
            dp[i] = 4;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
