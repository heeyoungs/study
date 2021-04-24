package sourcecode.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NiceCost {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken()); // 화폐의 종류 수
        int cost = Integer.parseInt(st.nextToken()); // 환전할 화폐
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            int input = Integer.parseInt(br.readLine());
            array[i] = input;
        } // 화폐 단위 별 배열에 저장

        int[] dp = new int[cost + 1];

        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int i = 0; i < num; i++) {
            for (int j = array[i]; j <= cost; j++) {
                if (dp[j - array[i]] != Integer.MAX_VALUE / 2) {
                    dp[j] = Math.min(dp[j], dp[j - array[i]] + 1);
                }
            }
        }

        if (dp[cost] == Integer.MAX_VALUE / 2) {
            System.out.println(-1);
        } else {
            System.out.println(dp[cost]);
        }
    }
}
