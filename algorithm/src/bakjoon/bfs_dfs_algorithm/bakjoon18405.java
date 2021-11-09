package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

// 경쟁적 전염
public class bakjoon18405 {
    static int N, K;
    static int[][] area;
    static Point[] pointArray;
    static int S, X, Y;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int pt;

    public static void main(String[] args) throws IOException {
        init();
        bfs();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        area = new int[N + 1][N + 1];
        pt = 0;
        for (int h = 1; h <= N; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 1; w <= N; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
                if (area[w][h] != 0) {
                    pt++;
                }
            }
        }
        pointArray = new Point[pt];
        pt = 0;
        for (int h = 1; h <= N; h++) {
            for (int w = 1; w <= N; w++) {
                if (area[w][h] != 0) {
                    pointArray[pt++] = new Point(w,h,area[w][h]);
                }
            }
        }


        Arrays.sort(pointArray);
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }

    static void bfs() {
        Queue<Point> Q = new LinkedList();
        for (int i = 0; i < pt; i++) {
            Q.add(pointArray[i]);
        }
        while (!Q.isEmpty()) {
            Point now = Q.poll();
            //.out.println(now.x + " " + now.y + " " + now.num);
            if (now.count == S) {
                System.out.println(area[Y][X]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 1 && ny >= 1 && nx <= N && ny <= N) {
                    if (area[nx][ny] == 0) {
                        area[nx][ny] = now.num;
                        Q.add(new Point(nx, ny, now.num, now.count + 1));
                    }
                }
            }
        }
        System.out.println(area[Y][X]);
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int num;
        int count = 0;

        Point(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        Point(int x, int y, int num, int count) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {
            return num - o.num;
        }
    }
}
