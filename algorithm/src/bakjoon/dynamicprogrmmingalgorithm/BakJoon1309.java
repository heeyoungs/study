package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

// 동물원
public class BakJoon1309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[100001];
        dp[1] = 3;
        dp[2] = 7;
        for (int i = 3; i <= 100000; i++) {
            dp[i] = (dp[i-2] + (dp[i-1]*2))%9901;
        }
        System.out.println(dp[N]);
    }
}
// n = 1 -> 3
// n = 2 -> 7
// n = 3 -> 17
// n = 4 -> 41