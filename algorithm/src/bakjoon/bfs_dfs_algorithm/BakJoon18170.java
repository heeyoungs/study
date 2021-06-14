package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 두 동전 언리미티드
public class BakJoon18170 {
    static int height, width;
    static char[][] area;
    static boolean[][][][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = -1;

    static class Point {
        int x1;
        int y1;
        int x2;
        int y2;
        int count;

        Point(int x1, int y1, int x2, int y2, int count) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new char[width][height];
        visit = new boolean[width][height][width][height];
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0, count = 1;
        for (int h = 0; h < height; h++) {
            String line = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = line.charAt(w);
                if (area[w][h] == 'o' && count == 1) {
                    x1 = w;
                    y1 = h;
                    count++;
                } else if (area[w][h] == 'o' && count == 2) {
                    x2 = w;
                    y2 = h;
                }
            }
        }
        Point coin = new Point(x1, y1, x2, y2, 1);
        bfs(coin);
        System.out.print(ans);
    }

    static void bfs(Point coin) {
        visit[coin.x1][coin.y1][coin.x2][coin.y2] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(coin);
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx1 = now.x1 + dx[i];
                int ny1 = now.y1 + dy[i];
                int nx2 = now.x2 + dx[i];
                int ny2 = now.y2 + dy[i];
                int count = 0;
                if (nx1 < 0 || ny1 < 0 || nx1 >= width || ny1 >= height) count++;
                if (nx2 < 0 || ny2 < 0 || nx2 >= width || ny2 >= height) count++;
                if (count == 1) {
                    ans = now.count;
                    return;
                } else if (count == 0) {
                    int moveX1;
                    int moveY1;
                    int moveX2;
                    int moveY2;
                    if (area[nx1][ny1] == '#') {
                        moveX1 = now.x1;
                        moveY1 = now.y1;
                    } else {
                        moveX1 = nx1;
                        moveY1 = ny1;
                    }
                    if (area[nx2][ny2] == '#') {
                        moveX2 = now.x2;
                        moveY2 = now.y2;
                    } else {
                        moveX2 = nx2;
                        moveY2 = ny2;
                    }
                    if (visit[moveX1][moveY1][moveX2][moveY2]) continue;
                    visit[moveX1][moveY1][moveX2][moveY2] = true;
                    queue.add(new Point(moveX1, moveY1, moveX2, moveY2, now.count + 1));
                }
            }
        }
    }
}
