package bakjoon.dynamicprogrmmingalgorithm;

import java.math.BigInteger;
import java.util.Scanner;
// 피보나치 수 2
public class BakJoon2748 {
    static BigInteger[] dp = new BigInteger[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        dp[0] = new BigInteger(String.valueOf(0));
        dp[1] = new BigInteger(String.valueOf(1));
        dp[2] = new BigInteger(String.valueOf(1));
        System.out.print(fibonacci(input));
    }

    static BigInteger fibonacci(int n) {
        if (dp[n] != null) {
            return dp[n];
        }
        return dp[n] = fibonacci(n - 1).add(fibonacci(n - 2));
    }
}
