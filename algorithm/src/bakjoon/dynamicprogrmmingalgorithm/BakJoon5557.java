package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1학년
public class BakJoon5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N - 1];
        long[][] dp = new long[N - 1][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int ansCheck = Integer.parseInt(st.nextToken()); // 값비교!
        dp[0][array[0]] = 1;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (j - array[i] >= 0) {
                    dp[i][j - array[i]] += dp[i - 1][j];
                }
                if (j + array[i] <= 20) {
                    dp[i][j + array[i]] += dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N - 2][ansCheck]);
    }
}
// 만들어질 수 있는 숫자의 경우의 수를 체크해주자
