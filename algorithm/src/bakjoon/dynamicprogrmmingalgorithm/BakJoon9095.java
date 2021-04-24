package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 1 2 3 더하기
public class BakJoon9095 {
    static int[] dp = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        dp[1] = 1; // 1
        dp[2] = 2; // 1 + 1 , 2
        dp[3] = 4; // 1 + 1 + 1, 1 + 2, 2 + 1, 3
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int test = 0; test < testCase; test++) {
            int input = Integer.parseInt(br.readLine());
            System.out.println(dp[input]);
        }
    }
}