package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 점프 점프
public class BakJoon11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        int[] dp = new int[N];
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= i + array[i]; j++) {
                if (j >= N) continue;
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        if (dp[N-1] == Integer.MAX_VALUE/2) {
            System.out.println(-1);
        }else{
            System.out.println(dp[N - 1]);
        }
    }
}
