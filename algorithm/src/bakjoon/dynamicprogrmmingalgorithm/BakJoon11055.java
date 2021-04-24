package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 가장 큰 증가하는 부분 수열
public class BakJoon11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[N];
        dp[0] = list.get(0);
        int max = list.get(0);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i) > list.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j]);
                    // 자기보다 작은 것들의 합들중에 최대를 저장함
                }
            }
            dp[i] += list.get(i);// 자기 자신을 더해줌
            //System.out.println(dp[i]);
            max = Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}