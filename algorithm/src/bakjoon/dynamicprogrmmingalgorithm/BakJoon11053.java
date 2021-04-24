package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
// 가장 긴 증가하는 부분 수열
public class BakJoon11053 {
    static int dp[] = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열의 크기
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 현재 보는 값보다 작은 값이 존재하면 그 위치의 dp값+1 과 현재 dp 값을 비교해서 큰거 저장
        Arrays.fill(dp, 1);
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i) > list.get(j))
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int max = 0;
        for(int i=0;i<N;i++){
            max = Math.max(dp[i],max );
        }
        System.out.println(max);
    }
}
