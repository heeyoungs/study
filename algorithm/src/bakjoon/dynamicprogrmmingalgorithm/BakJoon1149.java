package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 문제 접근 방법 -> dp에 저장된 위쪽의 값들(현재보는 라인제외)와 현재 값을 더해서 작은 것을 더해준다.
// RGB 거리
public class BakJoon1149 {
    static int[][] dp = new int[3][1001];
    // 0 r 1 g 2 b
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[][] array = new int[3][input+1];
        for (int i = 1; i <= input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[0][i] = Integer.parseInt(st.nextToken());
            array[1][i] = Integer.parseInt(st.nextToken());
            array[2][i] = Integer.parseInt(st.nextToken());

            dp[0][i] = Math.min(dp[1][i-1] + array[0][i],dp[2][i-1] + array[0][i]);
            dp[1][i] = Math.min(dp[0][i-1] + array[1][i],dp[2][i-1] + array[1][i]);
            dp[2][i] = Math.min(dp[0][i-1] + array[2][i],dp[1][i-1] + array[2][i]);
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            if (min > dp[i][input]){
                min = dp[i][input];
            }
        }
        System.out.println(min);
    }
}
