package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 침략자 진아
public class BakJoon15812 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visit;
    static int[][] area;
    static int Ans = Integer.MAX_VALUE;
    static int totalCountry = 0; // 마을의 수
    static int width, height;
    static Point[] pt = new Point[2];

    static class Point {
        int x;
        int y;
        int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

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
            String input = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = input.charAt(w) - '0';
                if (area[w][h] == 1) {
                    totalCountry++;
                }
            }
        }
        combine(0, 0);
        System.out.println(Ans);
    }

    static void combine(int at, int depth) {
        if (depth == 2) {
            bfs();
            return;
        }

        for (int i = at; i < width * height; i++) {
            int w = i % width;
            int h = i / width;
            if (area[w][h] != 1 && area[w][h] != 2) {
                pt[depth] = new Point(w, h);
                area[w][h] = 2;
                combine( i + 1, depth + 1);
                area[w][h] = 0;
            }
        }
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        visit = new boolean[width][height];
        visit[pt[0].x][pt[0].y] = true;
        visit[pt[1].x][pt[1].y] = true;
        queue.add(new Point(pt[0].x, pt[0].y, 0));
        queue.add(new Point(pt[1].x, pt[1].y, 0));
        int day = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            if (area[check.x][check.y] == 1) {
                count++;
            }
            if (count == totalCountry) {
                day = check.count;
                break;
            }
            if (check.count > Ans) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (!visit[nx][ny]) {
                    queue.add(new Point(nx, ny, check.count + 1));
                    visit[nx][ny] = true;
                }
            }
        }
        Ans = Math.min(day, Ans);
    }
}
