package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
// 가장 긴 감소하는 부분 수열
public class BakJoon11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            list.add(input);
        }
        Collections.reverse(list);
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int max = dp[0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i) > list.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.print(max);
    }
}
