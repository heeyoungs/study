package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baaaaaaaaaduk2 (Easy)
public class BakJoon16988 {
    static int height, width;
    static int[][] area;
    static int ans = 0;
    static int count;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new int[width][height];
        for (int h = 0; h < height; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < width; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, area, 0);

        System.out.println(ans);
    }

    static void dfs(int depth, int[][] area, int pt) {
        // 이 안에서 bfs
        if (depth == 2) {
            count = 0;
            boolean[][] visit = new boolean[width][height];
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    if (visit[w][h]) continue;
                    if (area[w][h] == 2) {
                        bfs(w, h, visit);
                    }
                }
            }
            ans = Math.max(ans,count);
            return;
        }

        // 바둑알 채우기 backTracking
        for (int i = pt; i < width * height; i++) {
            int w = i % width;
            int h = i / width;
            if (area[w][h] == 0) {
                area[w][h] = 1;
                dfs(depth + 1, area, i + 1);
                area[w][h] = 0;
            }
        }
    }

    static void bfs(int x, int y, boolean[][] visit) {
        boolean ck = true;
        Queue<Point> queue = new LinkedList<>();
        visit[x][y] = true;
        int tt = 0;
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            tt++;

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (visit[nx][ny]) continue;
                if (area[nx][ny] == 0) {
                    ck = false;
                    continue;
                } else if (area[nx][ny] == 1) {
                    continue;
                } else if (area[nx][ny] == 2) {
                    queue.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
        if (ck) count += tt;
    }
}