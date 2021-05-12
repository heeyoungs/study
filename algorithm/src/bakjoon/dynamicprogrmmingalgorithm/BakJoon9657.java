package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

// 돌게임
public class BakJoon9657 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[1001];
        // 상근 0
        // 창영 1
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 0;
        dp[4] = 0;
        dp[5] = 0;
        dp[6] = 0;
        dp[7] = 1;
        dp[8] = 0;
        for (int i = 9; i <= 1000; i++) {
            if (dp[i - 1] == 0 && dp[i - 3] == 0 && dp[i - 4] == 0) {
                dp[i] = 1;
            }else{
                dp[i] = 0;
            }
        }
        int N = sc.nextInt();
        if (dp[N] == 0){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}
