package sourcecode.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoldGet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        for (int test = 0; test < testCase; test++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 세로
            int M = Integer.parseInt(st.nextToken()); // 가로
            int[][] area = new int[M][N];
            st = new StringTokenizer(br.readLine());
            for (int h = 0; h < N; h++) {
                for (int w = 0; w < M; w++) {
                    area[w][h] = Integer.parseInt(st.nextToken());
                }
            } // 금광 초기화
            int[][] dp = new int[M][N];
            for (int w = 0; w < M; w++) {
                for (int h = 0; h < N; h++) {
                    dp[w][h] = area[w][h];
                }
            } // 첫 번째 줄 초기화

            for (int w = 1; w < M; w++) {
                for (int h = 0; h < N; h++) {
                    // 첫 줄 일 경우
                    if (h ==0){
                        dp[w][h] = Math.max(dp[w-1][h] + area[w][h],dp[w-1][h+1] + area[w][h]);
                    }
                    // 마지막 줄 일 경우
                    else if (h == N-1){
                        dp[w][h] = Math.max(dp[w-1][h] + area[w][h],dp[w-1][h-1] + area[w][h]);
                    }
                    // 중간 줄 일 경우
                    else{
                        dp[w][h] = Math.max(dp[w-1][h] + area[w][h],dp[w-1][h+1] + area[w][h]);
                        dp[w][h] = Math.max(dp[w][h],dp[w-1][h-1] + area[w][h]);
                    }
                }
            }

            int max = 0;
            for(int i=0;i<N;i++){
                if (dp[M-1][i] > max){
                    max = dp[M-1][i];
                }
            }

            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
/*
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
 */