package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

// 타일 장식물
public class BakJoon13301 {
    static long[] fibo = new long[81];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[81];
        dp[1] = 4;
        fibo[1] = 1;
        fibo[2] = 1;
        fibonacci(80);
        for (int i = 2; i < 81; i++) {
            dp[i] = dp[i - 1] + fibo[i] * 2;
        }
        System.out.println(dp[N]);
    }

    static long fibonacci(int i) {
        if (fibo[i] != 0) {
            return fibo[i];
        }

        return fibo[i] = fibonacci(i - 1) + fibonacci(i - 2);
    }
}
