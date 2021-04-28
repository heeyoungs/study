package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 불
public class BakJoon5427 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Deque<Point> queue = new LinkedList<>();
    static int width;
    static int height;
    static char[][] area;
    static StringBuilder sb = new StringBuilder();

    static class Point {
        int x;
        int y;
        char what;
        int count;

        Point(int x, int y, char what, int count) {
            this.x = x;
            this.y = y;
            this.what = what;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            area = new char[width][height];
            for (int h = 0; h < height; h++) {
                String line = br.readLine();
                for (int w = 0; w < width; w++) {
                    area[w][h] = line.charAt(w);
                    if (area[w][h] == '@') {
                        queue.addLast(new Point(w, h, area[w][h], 1));
                    } else if (area[w][h] == '*') {
                        queue.addFirst(new Point(w, h, area[w][h], -1));
                    }
                }
            }
            bfs();
        }
        System.out.println(sb);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Point check = queue.pop();
            int nowX = check.x;
            int nowY = check.y;
            int nowChar = check.what;

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= width || nextY >= height) {
                    if (nowChar == '@'){
                        sb.append(check.count).append("\n");
                        queue.clear();
                        return;
                    }
                    continue;
                }
                int nextChar = area[nextX][nextY];
                if (nowChar == '@') {
                    if (nextChar == '.') {
                        area[nextX][nextY] = '@';
                        queue.add(new Point(nextX, nextY, '@', check.count + 1));
                    }
                } else if (nowChar == '*') {
                    if (nextChar == '@' || nextChar == '.') {
                        area[nextX][nextY] = '*';
                        queue.add(new Point(nextX, nextY, '*', -1));
                    }
                }
            }
        }
        sb.append("IMPOSSIBLE").append("\n");
    }
}
