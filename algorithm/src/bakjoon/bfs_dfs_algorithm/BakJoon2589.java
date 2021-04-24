package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 보물섬
public class BakJoon2589 {
    static int height;
    static int width;
    static int[][] area;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int Ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new int[width][height]; // 0 길 1 벽
        for (int h = 0; h < height; h++) {
            String input = br.readLine();
            for (int w = 0; w < width; w++) {
                if (input.charAt(w) == 'L') {
                    area[w][h] = 0;
                } else if (input.charAt(w) == 'W') {
                    area[w][h] = 1;
                }
            }
        }

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (area[w][h] == 0) {
                    bfs(w, h);
                }
            }
        }
        System.out.println(Ans);
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visit = new boolean[width][height];
        visit[x][y] = true;
        int ct =0;
        queue.add(new Point(x, y,0));
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            ct = Math.max(ct,check.count);

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;

                if (!visit[nx][ny] && area[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    queue.add(new Point(nx, ny,check.count+1));
                }
            }
        }
        Ans = Math.max(ct, Ans);
    }

    static class Point {
        int x;
        int y;
        int count;

        Point(int x, int y,int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
