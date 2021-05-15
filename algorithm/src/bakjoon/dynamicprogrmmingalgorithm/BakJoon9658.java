package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

// 돌게임 4
public class BakJoon9658 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[1001];
        // 상근 0
        // 창영 1
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 0;
        dp[4] = 1;
        dp[5] = 1;
        dp[6] = 1;
        //dp[7] = 1;
        int N = sc.nextInt();
        if (dp[N%7] == 1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}