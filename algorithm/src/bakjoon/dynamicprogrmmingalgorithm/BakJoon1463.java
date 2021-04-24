package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Arrays;
import java.util.Scanner;
// 1로 만들기
public class BakJoon1463 {
    static int[] dp = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Arrays.fill(dp, 0);

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.print(dp[N] - 1);
    }
}
