package bakjoon.backtrackingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M(8)
public class BakJoon15657 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        StringBuilder zero = new StringBuilder();
        dfs(0, 0, zero);
        System.out.println(sb);
    }

    static void dfs(int at, int depth, StringBuilder line) {
        if (depth == M) {
            sb.append(line).append("\n");
            return;
        }

        for(int i=at;i<N;i++){
            StringBuilder newLine = new StringBuilder();
            newLine.append(line);
            newLine.append(array[i]).append(" ");
            dfs(i,depth + 1,newLine);
        }
    }
}
