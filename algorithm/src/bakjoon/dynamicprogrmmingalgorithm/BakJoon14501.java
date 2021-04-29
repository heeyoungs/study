package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사
public class BakJoon14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[22];
        int max = Integer.MIN_VALUE;
        int start = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int needDay = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            for(int k=1;k<i;k++){
                start = Math.max(start,dp[k]);
            }
            dp[i + needDay - 1] = Math.max(start + value,dp[i + needDay -1]);
        }

        for (int i=1;i<=N;i++){
            //System.out.println(dp[i]);
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);
    }
}
