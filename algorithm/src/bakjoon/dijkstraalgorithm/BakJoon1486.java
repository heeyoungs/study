package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

// 등산
public class BakJoon1486 {
    static int height, width, gap, during;
    static int[][] area;
    static long[][] dp1;
    static long[][] dp2;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Point implements Comparable<Point> {
        int x;
        int y;
        long weight;

        Point(int x, int y, long weight) {
            this.x = x;
            this.y = y;
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
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        gap = Integer.parseInt(st.nextToken());
        during = Integer.parseInt(st.nextToken());
        area = new int[width][height];
        for (int h = 0; h < height; h++) {
            String line = br.readLine();
            for (int w = 0; w < width; w++) {
                if (line.charAt(w) >= 'A' && line.charAt(w) <= 'Z') {
                    area[w][h] = line.charAt(w) - 65;
                } else if (line.charAt(w) >= 'a' && line.charAt(w) <= 'z') {
                    area[w][h] = line.charAt(w) - 97 + 26;
                }
            }
        }
        // solve
        dp1 = new long[width][height]; // 등산 시간
        dp2 = new long[width][height]; // 하산 시간
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                dp1[w][h] = dp2[w][h] = Integer.MAX_VALUE;
            }
        }
        dijkstra1();
        dijkstra2();

        int max = 0;
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (dp1[w][h] + dp2[w][h] > during) continue;
                max = Math.max(max,area[w][h]);
            }
        }
        System.out.print(max);
    }

    // 각 지점마다 최소시간으로 갈 수 잇는 거리 테이블  -> dp
    static void dijkstra1() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(0, 0, 0));
        dp1[0][0] = 0;
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();

            if (check.weight > during) continue;
            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (Math.abs(area[check.x][check.y] - area[nx][ny]) > gap) continue; // 차이가 gap초과
                int needTime;
                // 다음 지점이 높은 경우
                if (area[nx][ny] > area[check.x][check.y]) {
                    needTime = (area[nx][ny] - area[check.x][check.y]) * (area[nx][ny] - area[check.x][check.y]);
                }
                // 다음 지점이 낮거나 같은 경우
                else {
                    needTime = 1;
                }
                if (dp1[nx][ny] > dp1[check.x][check.y] + needTime) {
                    dp1[nx][ny] = dp1[check.x][check.y] + needTime;
                    PQ.add(new Point(nx, ny, dp1[nx][ny]));
                }
            }
        }
    }

    // 호텔에서 시작해서 호텔로 복귀, 각 지점에서 호텔까지의 최단 거리 테이블 갱신
    static void dijkstra2(){
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(0, 0, 0));
        dp2[0][0] = 0;
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();

            if (check.weight > during) continue;
            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (Math.abs(area[check.x][check.y] - area[nx][ny]) > gap) continue; // 차이가 gap초과
                int needTime;
                // 다음 지점이 높은 경우
                if (area[nx][ny] < area[check.x][check.y]) {
                    needTime = (area[nx][ny] - area[check.x][check.y]) * (area[nx][ny] - area[check.x][check.y]);
                }
                // 다음 지점이 낮거나 같은 경우
                else {
                    needTime = 1;
                }
                if (dp2[nx][ny] > dp2[check.x][check.y] + needTime) {
                    dp2[nx][ny] = dp2[check.x][check.y] + needTime;
                    PQ.add(new Point(nx, ny, dp2[nx][ny]));
                }
            }
        }
    }
}
