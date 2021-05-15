package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 소가 길을 건너간 이유 7
public class BakJoon14461 {
    static int N, T;
    static int[][] area;
    static long[][][] dist;
    static long ans = Long.MAX_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int count;
        long weight;

        Point(int x, int y, int count, long weight) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return (int) (weight - o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        area = new int[N][N];
        dist = new long[N][N][3];
        for (int h = 0; h < N; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < N; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j][k] = Long.MAX_VALUE;
                }
            }
        }

        area[0][0] = 0;
        dist[0][0][0] = 0;
        dijkstra();

        for (int i = 0; i < 3; i++) {
            ans = Math.min(dist[N - 1][N - 1][i], ans);
        }
        System.out.println(ans);

    }

    static void dijkstra() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(0, 0, 0, 0));
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();

            if (check.weight > dist[check.x][check.y][check.count]) continue;
            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (check.count == 2) {
                    if (dist[nx][ny][0] > check.weight + T + area[nx][ny]) {
                        dist[nx][ny][0] = check.weight + T + area[nx][ny];
                        PQ.add(new Point(nx, ny, 0, check.weight + T + area[nx][ny]));
                    }
                } else {
                    if (dist[nx][ny][check.count + 1] > check.weight + T) {
                        dist[nx][ny][check.count + 1] = check.weight + T;
                        PQ.add(new Point(nx, ny, check.count + 1, check.weight + T));
                    }
                }
            }
        }
    }
}
