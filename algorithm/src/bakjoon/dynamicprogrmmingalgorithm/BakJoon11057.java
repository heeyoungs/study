package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Arrays;
import java.util.Scanner;

// 오르막 수
public class BakJoon11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[N + 1][10];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= N; i++) {
            for(int j=0;j<=9;j++){
                for(int k=0;k<=j;k++) {
                    dp[i][j] += dp[i-1][k];
                }
                dp[i][j] %= 10007;
            }
        }
        int ans = 0;
        for(int i=0;i<=9;i++){
            ans += dp[N][i];
        }
        System.out.println(ans%10007);
    }
}
