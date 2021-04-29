package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 카드 구매하기
public class BakJoon11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N + 1]; // N 필요한 카드의 개수
        int[] dp = new int[N + 1];
        array[0] = 0;
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = array[i];
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[j] + dp[i - j], dp[i]);
            }
        }
        System.out.println(dp[N]);
    }
}
/*
 * dp[0] = p[0] = 0
 * dp[1] = p[1]     // 카드 한 장 구매 (최대)가격
 * dp[2] = max(p[2], dp[1] + dp[1])
 * dp[3] = max(p[3], dp[2] + dp[1])
 * dp[4] = max(p[4], dp[3] + dp[1], dp[2] + dp[2])
 * dp[4] = max(p[5], dp[4] + dp[1], dp[3] + dp[2])
 * ...
 * dp[n] = max(p[n], dp[n-1] + dp[1],,,dp[0] + dp[n])       // n : 카드 개수
 */