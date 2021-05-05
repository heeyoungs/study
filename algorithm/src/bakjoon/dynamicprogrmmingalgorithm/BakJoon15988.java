package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 1,2,3 더하기
public class BakJoon15988 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long dp[] = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3])%1000000009;
        }
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int N = sc.nextInt();
            bw.write(dp[N] + "\n");
        }
        bw.flush();
    }
}
/*
1 -> 1
2 -> 2
3 -> 4
4 -> 1 + 2 + 4 -> 7
5 -> 7 + 4 + 2 -> 13
6 -> 13  + 7 + 4 -> 24
7 -> 44
 */