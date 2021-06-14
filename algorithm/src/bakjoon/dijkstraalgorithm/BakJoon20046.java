package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Road Reconstruciton
public class BakJoon20046 {
    static int height, width;
    static int[][] area;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = Integer.MAX_VALUE;

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int weight;

        Point(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return weight - o.weight;
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

        dijkstra();
        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    static void dijkstra() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        if (area[0][0] == -1) return;
        PQ.add(new Point(0, 0, area[0][0]));
        boolean[][] visit = new boolean[width][height];
        while (!PQ.isEmpty()) {
            Point now = PQ.poll();
            if (now.x == width - 1 && now.y == height - 1) {
                ans = Math.min(now.weight, ans);
            }
            if (visit[now.x][now.y]) continue;
            visit[now.x][now.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (area[nx][ny] == -1) continue;
                PQ.add(new Point(nx, ny, now.weight + area[nx][ny]));
            }
        }
    }
}
