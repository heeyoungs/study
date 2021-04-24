package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 연속합
public class BakJoon1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[input];
        int[] dp = new int[input];
        for (int i = 0; i < input; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = array[0]; // 첫 번째 자리값
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < input; i++) {
            sum = sum + array[i];
            dp[i] = Math.max(sum, dp[i]);
            if (max < dp[i]){
                max = dp[i];
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(max);

    }
}
