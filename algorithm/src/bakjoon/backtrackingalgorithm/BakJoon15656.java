package bakjoon.backtrackingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M(7)
public class BakJoon15656 {
    static int N, M;
    static int[] array;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        StringBuilder no = new StringBuilder();
        dfs(0, no);
        System.out.println(sb);
    }

    static void dfs(int depth, StringBuilder k) {
        if (depth == M) {
            sb.append(k).append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            StringBuilder ss = new StringBuilder();
            ss.append(k);
            ss.append(array[i]).append(" ");
            dfs(depth + 1, ss);
        }
    }
}