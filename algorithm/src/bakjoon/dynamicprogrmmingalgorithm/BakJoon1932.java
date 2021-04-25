package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정수 삼각형
public class BakJoon1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];
        for (int h = 1; h <= N; h++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int w = 1; w <= h; w++) {
                triangle[w][h] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        dp[1][1] = triangle[1][1];
        for (int h = 2; h <= N; h++) {
            for (int w = 1; w <= h; w++) {
                dp[w][h] = Math.max(dp[w][h - 1], dp[w - 1][h - 1]) + triangle[w][h];
                max = Math.max(dp[w][h], max);
            }
        }
        System.out.println(max);
    }
}
