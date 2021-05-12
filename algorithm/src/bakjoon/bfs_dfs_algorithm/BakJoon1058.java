package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 친구
public class BakJoon1058 {
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int h = 1; h <= N; h++) {
            String input = br.readLine();
            for (int w = 0; w < N; w++) {
                if (input.charAt(w) == 'Y') {
                    list[h].add(w + 1);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            boolean[] visit = new boolean[N + 1];
            dfs(i, visit, list);
        }
        System.out.println(ans);
    }

    static void dfs(int start, boolean[] visit, ArrayList<Integer>[] list) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start, 0));
        visit[start] = true;
        int freindCount = 0;
        while (!q.isEmpty()) {
            Point check = q.poll();
            if (check.count == 1 || check.count == 2) {
                freindCount++;
            }

            for (int next : list[check.point]) {
                if (visit[next]) continue;
                visit[next] = true;
                q.add(new Point(next, check.count + 1));
            }
        }
        ans = Math.max(ans, freindCount);
    }

    static class Point {
        int point;
        int count;

        Point(int point, int count) {
            this.point = point;
            this.count = count;
        }
    }
}
