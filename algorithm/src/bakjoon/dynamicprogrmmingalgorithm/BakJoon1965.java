package bakjoon.dynamicprogrmmingalgorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 상자 넣기 -> LIS 문제
public class BakJoon1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 1);
        int maxPoint = 0;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < j; i++) {
                if (array[j] > array[i]){
                    dp[j] = Math.max(dp[j],dp[i] + 1);
                }
            }
            maxPoint = Math.max(dp[j],maxPoint);
        }
        System.out.println(maxPoint);
    }
}
