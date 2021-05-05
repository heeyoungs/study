package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 내려가기 -> 슬라이딩 윈도우? 왔다리 갔다리
public class BakJoon2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[3][2][2]; // 0 최대 1 최소
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0][0][0] = dp[0][0][1] = Integer.parseInt(st.nextToken());
        dp[1][0][0] = dp[1][0][1] = Integer.parseInt(st.nextToken());
        dp[2][0][0] = dp[2][0][1] = Integer.parseInt(st.nextToken());

        for (int h = 1; h < N; h++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for (int w = 0; w < 3; w++) {
                int k = h % 2;
                if (k == 1) {
                    if (w == 0) {
                        dp[w][k][0] = Math.max(dp[w][k - 1][0], dp[w + 1][k - 1][0]) + a;
                        dp[w][k][1] = Math.min(dp[w][k - 1][1], dp[w + 1][k - 1][1]) + a;
                    } else if (w == 1) {
                        dp[w][k][0] = Math.max(dp[w - 1][k - 1][0], Math.max(dp[w][k - 1][0], dp[w + 1][k - 1][0])) + b;
                        dp[w][k][1] = Math.min(dp[w - 1][k - 1][1], Math.min(dp[w][k - 1][1], dp[w + 1][k - 1][1])) + b;
                    } else {
                        dp[w][k][0] = Math.max(dp[w][k - 1][0], dp[w - 1][k - 1][0]) + c;
                        dp[w][k][1] = Math.min(dp[w][k - 1][1], dp[w - 1][k - 1][1]) + c;
                    }
                } else {
                    if (w == 0) {
                        dp[w][k][0] = Math.max(dp[w][k + 1][0], dp[w + 1][k + 1][0]) + a;
                        dp[w][k][1] = Math.min(dp[w][k + 1][1], dp[w + 1][k + 1][1]) + a;
                    } else if (w == 1) {
                        dp[w][k][0] = Math.max(dp[w - 1][k + 1][0], Math.max(dp[w][k + 1][0], dp[w + 1][k + 1][0])) + b;
                        dp[w][k][1] = Math.min(dp[w - 1][k + 1][1], Math.min(dp[w][k + 1][1], dp[w + 1][k + 1][1])) + b;
                    } else {
                        dp[w][k][0] = Math.max(dp[w][k + 1][0], dp[w - 1][k + 1][0]) + c;
                        dp[w][k][1] = Math.min(dp[w][k + 1][1], dp[w - 1][k + 1][1]) + c;
                    }
                }
            }
        }
        if (N % 2 == 0) {
            System.out.print(Math.max(dp[0][1][0], Math.max(dp[1][1][0], dp[2][1][0])));
            System.out.print(" ");
            System.out.print(Math.min(dp[0][1][1], Math.min(dp[1][1][1], dp[2][1][1])));
        } else {
            System.out.print(Math.max(dp[0][0][0], Math.max(dp[1][0][0], dp[2][0][0])));
            System.out.print(" ");
            System.out.print(Math.min(dp[0][0][1], Math.min(dp[1][0][1], dp[2][0][1])));
        }
    }
}
