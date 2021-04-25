package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;
// 쉬운 계단 수
public class BakJoon10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long ans = 0;
        int[][] dp = new int[N + 1][10];
        dp[1][0] = 0;
        dp[1][1] = dp[1][2] = dp[1][3] = dp[1][4] = dp[1][5] = dp[1][6] = dp[1][7] = dp[1][8] = dp[1][9] = 1;
        for (int i = 2; i <= N; i++) {
            for (int num = 0; num <= 9; num++) {
                if (num == 0){
                    dp[i][0] = dp[i - 1][1]%1000000000;
                }else if (num == 9){
                    dp[i][9] = dp[i - 1][8]%1000000000;
                }else {
                    dp[i][num] = dp[i - 1][num - 1]%1000000000 + dp[i - 1][num + 1]%1000000000;
                }
            }
        }
        for(int k=0;k<=9;k++){
            ans += dp[N][k];
        }
        System.out.println(ans%1000000000);
    }
}
