package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스티커
public class BakJoon9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 0; t < test; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] array = new int[N][2];
            int[][] dp = new int[N][2];
            for (int h = 0; h < 2; h++) {
                st = new StringTokenizer(br.readLine());
                for (int w = 0; w < N; w++) {
                    array[w][h] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = array[0][0];
            dp[0][1] = array[0][1];
            dp[1][1] = dp[0][0] + array[1][1];
            dp[1][0] = dp[0][1] + array[1][0];
            for (int i = 2; i < N; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + array[i][0];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + array[i][1];
            }
            int ans = Math.max(dp[N - 1][0], dp[N - 1][1]);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
