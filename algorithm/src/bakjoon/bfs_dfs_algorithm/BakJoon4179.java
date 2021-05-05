package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 불!
public class BakJoon4179 {
    static int height, width;
    static char[][] area;
    static boolean[][] visit;
    static Deque<Point> Q = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int Ans = Integer.MAX_VALUE;

    static class Point {
        int x;
        int y;
        int count;
        char who;

        Point(int x, int y, int count, char who) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.who = who;
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
                if (area[w][h] == 'J') {
                    visit[w][h] = true;
                    Q.addLast(new Point(w, h, 1, 'J'));
                } else if (area[w][h] == 'F') {
                    Q.addFirst(new Point(w, h, 0, 'F'));
                }
            }
        }
        bfs();
        if (Ans == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(Ans);
        }
    }

    static void bfs() {
        while (!Q.isEmpty()) {
            Point check = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) {
                    if (check.who == 'J') { // 종료 처리
                        Ans = Math.min(Ans, check.count);
                        return;
                    } else {
                        continue;
                    }
                }
                if (check.who == 'J') {
                    if (area[nx][ny] == '.' && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        Q.add(new Point(nx, ny, check.count + 1, 'J'));
                    }
                } else if (check.who == 'F') {
                    if (area[nx][ny] == '.') {
                        area[nx][ny] = 'F';
                        Q.add(new Point(nx, ny, 0, 'F'));
                    }
                }

            }
        }
    }
}
