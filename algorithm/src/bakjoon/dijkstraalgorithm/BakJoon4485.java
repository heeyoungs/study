package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 녹색 옷 입은 애가 젤다지?
public class BakJoon4485 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] distance;
    static int[][] area;
    static boolean[][] visit;
    static int N;
    static int totalCount = 1;

    static class Point {
        int x;
        int y;
        int weight;

        Point(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            area = new int[N][N];
            distance = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }
            visit = new boolean[N][N];
            for (int h = 0; h < N; h++) {
                st = new StringTokenizer(br.readLine());
                for (int w = 0; w < N; w++) {
                    area[w][h] = Integer.parseInt(st.nextToken());
                }
            }
            // 여기까지 초기화 단계

            dijkstra(0, 0);

            int ans = distance[N - 1][N - 1];
            sb.append("Problem ").append(totalCount).append(": ").append(ans).append("\n");
            totalCount++;
        }
        System.out.println(sb);
    }

    static void dijkstra(int x, int y) {
        distance[0][0] = area[0][0];
        PriorityQueue<Point> Q = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.weight - o2.weight;
            }
        });
        visit[0][0] = true;
        Q.add(new Point(0, 0,area[0][0]));
        while (!Q.isEmpty()) {
            Point check = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = check.x + dx[i];
                int nextY = check.y + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;

                if (!visit[nextX][nextY]) {
                    visit[nextX][nextY] = true;
                    if (distance[nextX][nextY] > distance[check.x][check.y] + area[nextX][nextY]) {
                        distance[nextX][nextY] = distance[check.x][check.y] + area[nextX][nextY];
                        Q.add(new Point(nextX, nextY,distance[nextX][nextY]));
                    }
                }
            }
        }
    }
}
