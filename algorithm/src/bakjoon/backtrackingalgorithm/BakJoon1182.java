package bakjoon.backtrackingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분수열의 합
public class BakJoon1182 {
    static int totalCount = 0;
    static int N, S;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0);
        if (S == 0) totalCount = totalCount - 1;
        System.out.println(totalCount);
    }

    static void dfs(int at, int depth, int sum) {
        if (sum == S) {
            totalCount++;
        }
        if (depth == N) {
            return;
        }

        for (int i = at; i < N; i++) {
            int newSum = sum + array[i];
            dfs(i + 1, depth + 1, newSum);
        }
    }
}
