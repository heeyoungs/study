package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 그대, 그머가 되어
public class BakJoon14496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        System.out.println(bfs(start, end, list, N));
    }

    static int bfs(int start, int end, ArrayList<Integer>[] list, int N) {
        int[] count = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int ans = -1;
        while (!queue.isEmpty()) {
            int check = queue.poll();

            if (check == end) {
                ans = count[end];
                break;
            }

            for (int next : list[check]) {
                if (count[next] != 0) continue;
                count[next] = count[check] + 1;
                queue.add(next);
            }
        }

        return ans;
    }
}
