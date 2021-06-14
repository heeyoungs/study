package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 레이저 통신
public class BakJoon6087 {
    static int W, H;
    static char[][] area;
    static int[][][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Point start = null;
    static Point end = null;
    static int ans = Integer.MAX_VALUE;

    static class Point {
        int x, y, count, lastForce;

        Point(int x, int y, int count, int lastForce) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.lastForce = lastForce;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        area = new char[W][H];
        visit = new int[W][H][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<W;j++){
                for(int k=0;k<H;k++){
                    visit[j][k][i] = Integer.MAX_VALUE;
                }
            }
        }

        int count = 1;
        for (int h = 0; h < H; h++) {
            String line = br.readLine();
            for (int w = 0; w < W; w++) {
                area[w][h] = line.charAt(w);
                if (area[w][h] == 'C' && count == 1) {
                    start = new Point(w, h, -1, 4);
                    count++;
                } else if (area[w][h] == 'C' && count == 2) {
                    end = new Point(w, h, -1, -1);
                }
            }
        }
        bfs();
        System.out.print(ans);
    }

    static void bfs() {
        Queue<Point> Q = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            int nx = start.x + dx[i];
            int ny = start.y + dy[i];
            if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
            if (area[nx][ny] == '*') continue;
            Q.add(new Point(nx, ny, 0, i));
            visit[nx][ny][i] = 0;
        }
        while (!Q.isEmpty()) {
            Point check = Q.poll();
            //System.out.println(check.x + " " + check.y + " " + check.count);

            if (check.x == end.x && check.y == end.y) {
                ans = Math.min(check.count, ans);
            }

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                if (area[nx][ny] == '*') continue;
                if (visit[nx][ny][i] > check.count) {
                    if (check.lastForce == i) {
                        Q.add(new Point(nx, ny, check.count, i));
                        visit[nx][ny][i] = check.count;
                    } else {
                        Q.add(new Point(nx, ny, check.count + 1, i));
                        visit[nx][ny][i] = check.count + 1;
                    }
                }
            }
        }
    }
}
