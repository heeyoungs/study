package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 기타리스트
public class BakJoon1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노래의 개수
        int S = Integer.parseInt(st.nextToken()); // 시작 볼륨
        int M = Integer.parseInt(st.nextToken()); // 최대 볼륨
        st = new StringTokenizer(br.readLine());
        int[] array = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (j - array[i] >= 0) {
                    if (dp[i-1][j]) {
                        dp[i][j - array[i]] = true;
                    }
                }
                if (j + array[i] <= M) {
                    if (dp[i-1][j]) {
                        dp[i][j + array[i]] = true;
                    }
                }
            }
        }
        int i;
        for (i = M; i >= 0; i--) {
            if (dp[N][i]) break;
        }
        System.out.println(i);
    }
}
