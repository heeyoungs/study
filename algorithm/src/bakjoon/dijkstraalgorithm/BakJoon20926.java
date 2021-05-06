package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 얼음 미로
public class BakJoon20926 {
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] area;
    static boolean[][] visit;
    static int width, height;
    static PriorityQueue<Point> PQ = new PriorityQueue<>();

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
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        area = new int[width][height];
        visit = new boolean[width][height];
        for (int h = 0; h < height; h++) {
            String input = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = input.charAt(w) - '0';
                if (input.charAt(w) == 'E') { // 목적지
                    area[w][h] = -3;
                } else if (input.charAt(w) == 'T') { // 시작위치
                    area[w][h] = 0;
                    PQ.add(new Point(w, h, 0));
                } else if (input.charAt(w) == 'H') { // 구멍
                    area[w][h] = -1;
                } else if (input.charAt(w) == 'R') { // 돌
                    area[w][h] = -2;
                }
            }
        }
//
//        for(int h=0;h<height;h++){
//            for(int w=0;w<width;w++){
//                System.out.print(area[w][h]);
//            }
//            System.out.println();
//        }

        pq();
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    // -1 구멍 , -2 돌 , -3 목적지
    static void pq() {
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();
            if (visit[check.x][check.y]) continue;
            visit[check.x][check.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (area[nx][ny] == -1 || area[nx][ny] == -2) continue; // 구멍 or 돌
                if (area[nx][ny] == -3) { // 목적지
                    ans = Math.min(ans, check.weight);
                    continue;
                }

                int weight = check.weight;
                while (true) {
                    if ((nx < 0 || ny < 0 || nx >= width || ny >= height)
                            || area[nx][ny] == -1 || area[nx][ny] == -2 || area[nx][ny] == -3) // 예외 상황시
                        break;
                    weight = weight + area[nx][ny];
                    nx = nx + dx[i];
                    ny = ny + dy[i];
                    //System.out.println(nx + " " + ny + " " + weight);
                }
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (area[nx][ny] == -2 || area[nx][ny] == -3){
                    PQ.add(new Point(nx - dx[i], ny - dy[i], weight));
                    //System.out.println(121);
                }
            }
        }
    }
}


// 시간 초과 코드

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//// 얼음 미로
//public class BakJoon20926 {
//    static int width, height;
//    static Point[][] area;
//    static int[][] dp;
//    static int[] dx = {1, 0, -1, 0};
//    static int[] dy = {0, -1, 0, 1};
//    static Point EPoint;
//
//    static class Point {
//        int x;
//        int y;
//        int weight;
//
//        Point(int x, int y, int weight) {
//            this.x = x;
//            this.y = y;
//            this.weight = weight;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        width = Integer.parseInt(st.nextToken());
//        height = Integer.parseInt(st.nextToken());
//        area = new Point[width][height];
//        dp = new int[width][height];
//        Point TPoint = null;
//
//        for (int h = 0; h < height; h++) {
//            String input = br.readLine();
//            for (int w = 0; w < width; w++) {
//                dp[w][h] = Integer.MAX_VALUE / 2;
//
//                area[w][h] = new Point(w, h, input.charAt(w));
//                if (input.charAt(w) == 'T') { // 시작 지점
//                    TPoint = new Point(w, h, '0');
//                    area[w][h] = new Point(w,h,'0');
//                    dp[w][h] = 0;
//                } else if (input.charAt(w) == 'E') {
//                    area[w][h] = new Point(w,h,'0');
//                    EPoint = new Point(w, h, '0');
//                }
//            }
//        }
//
//        boolean[][] visit = new boolean[width][height];
//
//        visit[TPoint.x][TPoint.y] = true;
//        dfs(TPoint, visit);
//        if (dp[EPoint.x][EPoint.y] == Integer.MAX_VALUE / 2) {
//            System.out.println(-1);
//        } else {
//            System.out.println(dp[EPoint.x][EPoint.y]);
//        }
//    }
//
//    static void dfs(Point TPoint, boolean[][] visit) {
//        if (TPoint.x == EPoint.x && TPoint.y == EPoint.y) {
//            return;
//        }
//
//        Out:
//        for (int i = 0; i < 4; i++) {
//            // 그 방향으로 돌, 구멍이 있는지 먼저 확인해주자
//            int goCount = 1;
//            int stopPointX = -1;
//            int stopPointY = -1;
//            while (true) {
//                int nx = TPoint.x + dx[i] * goCount;
//                int ny = TPoint.y + dy[i] * goCount;
//                if (nx < 0 || ny < 0 || nx >= width || ny >= height) // 외곽으로 나가면
//                    continue Out;
//                if (area[nx][ny].weight == 'H')  // 구멍을 만나면
//                    continue Out;
//                else if (area[nx][ny].weight == 'R') { // 돌을 만나면
//                    stopPointX = nx - dx[i];
//                    stopPointY = ny - dy[i];
//                    break;
//                } else if (area[nx][ny].weight == '0') { // 출구를 만나면
//                    stopPointX = nx;
//                    stopPointY = ny;
//                    break;
//                }
//                goCount++;
//            }
//            if (visit[stopPointX][stopPointY]) continue;
//            visit[stopPointX][stopPointY] = true;
//
//            boolean[][] copyVisit = new boolean[width][height];
//            for (int h = 0; h < height; h++) {
//                for (int w = 0; w < width; w++) {
//                    copyVisit[w][h] = visit[w][h];
//                }
//            }
//
//            int dist = dp[TPoint.x][TPoint.y];
//
//            goCount = 1;
//            while (true) {
//                int nx = TPoint.x + dx[i] * goCount;
//                int ny = TPoint.y + dy[i] * goCount;
//                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue Out;
//                dist = dist + (area[nx][ny].weight - '0');
//                if (nx == stopPointX && ny == stopPointY) break;
//                goCount++;
//            }
//
//            if (dp[stopPointX][stopPointY] > dist) {
//                dp[stopPointX][stopPointY] = dist;
//                dfs(new Point(stopPointX, stopPointY, (char) (dist)), copyVisit);
//            }
//        }
//    }
//}
