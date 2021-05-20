package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

// 줄어들지 않아
public class BakJoon2688 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        long[][] dp = new long[65][10]; // 앞 -> 자리수 / 뒤 -> 숫자
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

        int testCase = sc.nextInt();
        while (testCase-- > 0) {
            int input = sc.nextInt();
            long ans = 0;
            for(int i=0;i<10;i++){
                ans += dp[input][i];
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
