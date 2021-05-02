package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

// 떡 먹는 호랑이
public class BakJoon2502 {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt(); // d째날 준 떡의 개수는
        int K = sc.nextInt(); // k개

        dp = new int[D + 1];
        dp[1] = 1;
        dp[2] = 1;
        fibonacci(D);
        int x= 1;
        int y =0;
        while(true){
            int check = K - x*dp[D-2];
            if (check%dp[D-1] == 0){
                y = check/dp[D-1];
                break;
            }
            x++;
        }
        System.out.println(x);
        System.out.println(y);
    }

    static int fibonacci(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
