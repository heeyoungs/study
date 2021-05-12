package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사 2
public class BakJoon15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TC[] tc = new TC[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tc[i] = new TC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] dp = new int[1500100];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            dp[i + tc[i].time - 1] = Math.max(dp[i + tc[i].time - 1],max + tc[i].cost);
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }

    static class TC {
        int time;
        int cost;

        TC(int time, int cost) {
            this.time = time;
            this.cost = cost;
        }
    }
}
