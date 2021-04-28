package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS
public class BakJoon9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String line2 = br.readLine();

        int[][] dp = new int[1002][1002];
        line1 = '0' + line1;
        line2 = '0' + line2;

        for (int i = 1; i < line1.length(); i++) {
            for (int j = 1; j < line2.length(); j++) {
                if (line1.charAt(i) == line2.charAt(j)){
                    dp[j][i] = dp[j-1][i-1] + 1;
                    // 같은 문자열일 때에는 왼쪽 대각선위의 값 + 1
                }else{
                    dp[j][i] = Math.max(dp[j][i-1],dp[j-1][i]);
                    // 다른 문자열일 때에는 위쪽과 왼쪽 비교해서 큰 값
                }
                System.out.print(dp[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[line2.length()-1][line1.length()-1]);
    }
}
