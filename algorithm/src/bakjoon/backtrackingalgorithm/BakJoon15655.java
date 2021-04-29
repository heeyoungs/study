package bakjoon.backtrackingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M(6)
public class BakJoon15655 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] array;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        array = new int[N];
        check = new boolean[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int at, int depth) {
        if (depth == M) {
            for (int i = 0; i < N; i++) {
                if (check[i]) {
                    sb.append(array[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < N; i++) {
            check[i] = true;
            dfs(i + 1, depth + 1);
            check[i] = false;
        }
    }
}
