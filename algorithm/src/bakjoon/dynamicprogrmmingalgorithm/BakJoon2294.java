package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 동전 2
public class BakJoon2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동전의 종류
        int K = Integer.parseInt(st.nextToken()); // 환전할 동전의 량

        int[] moneyList = new int[N];
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            moneyList[i] = input;
        }

        int[] dp = new int[K + 1]; // 각 값에 따른 필요한 동전의 개수

        Arrays.fill(dp, Integer.MAX_VALUE/2);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = moneyList[i]; j <= K; j++) {
                if (j - moneyList[i] != Integer.MAX_VALUE/2) {
                    dp[j] = Math.min(dp[j], dp[j - moneyList[i]] + 1);
                }
            }
        }

        if (dp[K] == Integer.MAX_VALUE/2) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }
}
