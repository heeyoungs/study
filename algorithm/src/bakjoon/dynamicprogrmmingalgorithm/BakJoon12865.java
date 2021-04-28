package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평범한 배낭(냅색 문제)
public class BakJoon12865 {
    static int[] weight;
    static int[] value;
    static int[][] dp = new int[101][100001];
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weight = new int[N];
        value = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(NP(0,0));
    }

    static int NP(int i, int w) { // i 넣을까 말까 인덱스, w 현재 무게
        if (dp[i][w] != 0) return dp[i][w];
        if (i == N) {
            return 0;
        }

        int n1 = 0;
        if (w + weight[i] <= K){
            n1 = value[i] + NP(i + 1, w + weight[i]); // 현재 물건을 포함
        }
        int n2 = NP(i + 1,w); // 현재 물건 미포함
        return dp[i][w] = Math.max(n1,n2);
    }
}
