package bakjoon.dynamicprogrmmingalgorithm;

import java.io.*;
import java.util.StringTokenizer;

// 동전 1
public class BakJoon2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        int[] dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            array[i] = input;
        }
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = array[i]; j <= K; j++) {
                dp[j] += dp[j-array[i]];
            }
        }
        bw.write(dp[K] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

