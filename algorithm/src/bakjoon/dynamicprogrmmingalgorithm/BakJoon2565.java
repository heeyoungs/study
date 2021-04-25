package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 전깃줄 -> 다음 배열에 저장된 수가 자기 자신보다 커야함! + LIS
public class BakJoon2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] prob = new int[501];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            prob[start] = end;
        }
        int[] dp = new int[501];

        for (int i = 1; i <= 500; i++) {
            for (int j = 1; j < i; j++) {
                if (prob[j] == 0) continue;
                if (prob[i] > prob[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //System.out.println(i + " - " + dp[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= 500; i++) {
            max = Math.max(max, dp[i] + 1);
        }
        System.out.println(N - max);
    }
}
