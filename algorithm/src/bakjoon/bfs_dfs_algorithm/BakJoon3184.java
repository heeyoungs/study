package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 양
public class BakJoon3184 {
    static int height, width;
    static char[][] area;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans1 = 0; // 양 o
    static int ans2 = 0; // 늑대 v

    static class Point {
        int x, y;

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
        area = new char[width][height];
        visit = new boolean[width][height];
        for (int h = 0; h < height; h++) {
            String input = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = input.charAt(w);
            }
        }

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (visit[w][h]) continue;
                if (area[w][h] == '#') continue;
                bfs(w, h);
            }
        }
        System.out.println(ans1 + " " + ans2);
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int sheep = 0;
        int wolve = 0;
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            if (area[check.x][check.y] == 'v') {
                wolve++;
            } else if (area[check.x][check.y] == 'o') {
                sheep++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (area[nx][ny] == '#') continue;
                if (visit[nx][ny]) continue;
                queue.add(new Point(nx, ny));
                visit[nx][ny] = true;
            }
        }
        if (sheep > wolve) {
            ans1 += sheep;
        } else {
            ans2 += wolve;
        }
    }
}
