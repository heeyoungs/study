package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

// 1,2,3 더하기 5
public class BakJoon15990 {
    public static void main(String[] args) {
        long[][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int i=4;i<100001;i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1000000009;
        }

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            long ans = (dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009;
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
