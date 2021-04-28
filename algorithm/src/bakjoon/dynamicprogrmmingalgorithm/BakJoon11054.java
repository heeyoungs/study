package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 긴 바이토닉 수열
public class BakJoon11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        // LIS
        Arrays.fill(dp1,1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }
        // LIS 역
        Arrays.fill(dp2,1);
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (array[i] > array[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i=0;i<N;i++){
            max = Math.max(dp1[i] + dp2[i] - 1 ,max);
            //System.out.println(i + " " + dp1[i] + "-" + dp2[i]);
        }
        System.out.println(max);
    }
}
