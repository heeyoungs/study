package sourcecode.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MakeOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int[] dp = new int[input + 1];
        int[] mem = new int[input + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= input; i++) {
            dp[i] = dp[i - 1] + 1; // 덧셈
            mem[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                mem[i] = i / 2;
                dp[i] = dp[i / 2] + 1; // 2곱셈
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                mem[i] = i / 3;
                dp[i] = dp[i / 3] + 1; // 3곱셈
            }

            if (i % 5 == 0 && dp[i] > dp[i / 5] + 1) {
                mem[i] = i / 5;
                dp[i] = dp[i / 5] + 1; // 5곱셈
            }
        }
        System.out.println(dp[input]);
        while (input != 0) {
            System.out.print(input + " ");
            input = mem[input];
        }
    }
}
