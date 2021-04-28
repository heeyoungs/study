package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS 2
public class BakJoon9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line1 = br.readLine();
        String line2 = br.readLine();
        StringBuilder ans = new StringBuilder();

        line1 = '0' + line1;
        line2 = '0' + line2;

        int[][] dp = new int[1002][1002];

        for (int i = 1; i < line1.length(); i++) {
            for (int j = 1; j < line2.length(); j++) {
                if (line1.charAt(i) == line2.charAt(j)) {
                    dp[j][i] += dp[j - 1][i - 1] + 1;
                } else {
                    dp[j][i] = Math.max(dp[j - 1][i], dp[j][i - 1]);
                }
                //System.out.print(dp[j][i] + " ");
            }
            //System.out.println();
        }

        // 가장 밑 줄부터 올라가면서 같은 문자 + 최고 숫자 찾아붙이기
        int checkPoint = dp[line2.length() - 1][line1.length() - 1];
        sb.append(dp[line2.length() - 1][line1.length() - 1]).append("\n");
        for (int i = line1.length() - 1; i >= 1; i--) {
            for (int j = line2.length() - 1; j >= 1; j--) {
                if ((line1.charAt(i) == line2.charAt(j)) && (dp[j][i] == checkPoint)) {
                    ans.insert(0, line1.charAt(i));
                    checkPoint--;
                    break;
                }
            }
        }
        sb.append(ans);

        System.out.println(sb);
    }
}
