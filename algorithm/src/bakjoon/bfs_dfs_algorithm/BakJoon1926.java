package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 그림
public class BakJoon1926 {
    static int height, width;
    static int[][] area;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int paintCount = 0;
    static int bigPaint = 0;

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
        visit = new boolean[width][height];
        for (int h = 0; h < height; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < width; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (visit[w][h]) continue;
                if (area[w][h] == 0) continue;
                bfs(w, h);
                paintCount++;
            }
        }
        System.out.println(paintCount);
        System.out.println(bigPaint);
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        int count = 0;
        queue.add(new Point(x, y));
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (visit[nx][ny]) continue;
                if (area[nx][ny] == 0) continue;
                queue.add(new Point(nx, ny));
                visit[nx][ny] = true;
            }
        }
        bigPaint = Math.max(bigPaint,count);
    }
}
