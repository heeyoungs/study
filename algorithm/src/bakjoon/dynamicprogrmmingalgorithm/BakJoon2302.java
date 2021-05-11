package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

// 극장 좌석
public class BakJoon2302 {
    static int[] dp = new int[41];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        // 피보나치
        fibonacci(40);

        int cnt = sc.nextInt();
        int last = 1;
        int count = 1;
        for (int i = 0; i < cnt; i++) {
            int input = sc.nextInt();
            count *= dp[input - last];
            last = input + 1;
        }
        count *= dp[N + 1 - last];
        System.out.println(count);
    }

    static int fibonacci(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
