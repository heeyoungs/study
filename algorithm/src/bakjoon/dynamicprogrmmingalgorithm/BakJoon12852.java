package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;
// 1로 만들기 2
public class BakJoon12852 {
    static int[] dp = new int[1000001];
    static int[] mem = new int[1000001]; // 전 숫자가 뭔지

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 뺼셈 기준
            mem[i] = i - 1;

            if (i % 2 == 0) {
                if (dp[i / 2] + 1 < dp[i]) {
                    mem[i] = i / 2;
                }
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                if (dp[i / 3] + 1 < dp[i]) { // 값이 변할 경우
                    mem[i] = i / 3;
                }
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        sb.append(dp[N]).append("\n");
        while (N != 0) {
            sb.append(N).append(" ");
            N = mem[N];
        }
        System.out.println(sb);
    }
}
