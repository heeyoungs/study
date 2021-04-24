package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 포도주 시식
public class BakJoon2156 {
    static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1){
            System.out.println(br.readLine());
            return;
        }

        int[] array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(br.readLine());
            array[i] = input;
        }
        dp[1] = array[1];
        dp[2] = array[1] + array[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + array[i], dp[i - 1]);
            dp[i] = Math.max(dp[i], dp[i - 3] + array[i - 1] + array[i]);
        }

        System.out.println(dp[n]);
    }
}
/*
D[3] = (다음 세 식의 결과 중 최대값)
    1) D[1] + W[3]    // 지금 접근한 잔과 2칸 전의 잔을 선택한 경우
    2) W[2] + W[3]    // 바로 1칸 전의 잔과 지금 접근한 잔을 선택한 경우
    3) D[2]           // 지금 접근한 잔은 무시하고 이전 잔과 전전 잔을 선택한 경우
 */
