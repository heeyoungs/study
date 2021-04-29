package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이동하기
public class BakJoon11048 {
    static int width;
    static int height;
    static int[][] area;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new int[width][height];
        dp = new int[width][height];
        for (int h = 0; h < height; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < width; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (w == 0 && h == 0) {
                    dp[0][0] = area[0][0];
                } else if (w == 0) {
                    dp[0][h] = dp[0][h - 1] + area[0][h];
                } else if (h == 0) {
                    dp[w][0] = dp[w - 1][0] + area[w][0];
                } else {
                    dp[w][h] = Math.max(dp[w - 1][h], dp[w][h - 1]) + area[w][h];
                }
            }
        }
        System.out.println(dp[width - 1][height - 1]);
    }
}