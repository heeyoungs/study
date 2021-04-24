package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 순열 사이클
public class BakJoon10451 {
    static int[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        for (int test = 0; test < testCase; test++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            list = new int[N + 1];
            visit = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (!visit[i]) {
                    dfs(i);
                    count++;
                }
            }
            sb.append(count).append("\n");

        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        visit[start] = true;
        if (!visit[list[start]]) {
            dfs(list[start]);
        }
    }
}
