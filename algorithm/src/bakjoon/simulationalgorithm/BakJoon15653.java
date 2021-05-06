package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 구슬 탈출 4
public class BakJoon15653 {
    static int height, width;
    static char[][] area;
    static boolean[][][][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = -1;

    static Point ball = null;

    static class Point {
        int rx;
        int ry;
        int bx;
        int by;
        int count;

        Point(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new char[width][height];
        visit = new boolean[width][height][width][height];
        int rx = -1, ry = -1, bx = -1, by = -1;
        for (int h = 0; h < height; h++) {
            String input = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = input.charAt(w);
                if (area[w][h] == 'R') {
                    rx = w;
                    ry = h;
                    area[w][h] = '.';
                }
                if (area[w][h] == 'B') {
                    bx = w;
                    by = h;
                    area[w][h] = '.';
                }
            }
        }
        ball = new Point(rx, ry, bx, by, 0);
        visit[rx][ry][bx][by] = true;

        bfs();

        System.out.println(ans);
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(ball);
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            Out:
            for (int i = 0; i < 4; i++) {
                boolean goalCheck = false;
                int nrx = check.rx + dx[i];
                int nry = check.ry + dy[i];
                int nbx = check.bx + dx[i];
                int nby = check.by + dy[i];
                // 빨강구슬
                while (true) {
                    if (area[nrx][nry] == '#' || (nrx == check.bx && nry == check.by)) { // 벽 또는 파랑구슬에 부딪치면
                        nrx = nrx - dx[i];
                        nry = nry - dy[i];
                        break;
                    } else if (area[nrx][nry] == 'O') { // 골인
                        goalCheck = true;
                        nrx = -1;
                        nry = -1;
                        break;
                    }
                    nrx += dx[i];
                    nry += dy[i];
                }
                // 파랑 구슬
                while (true) {
                    if (area[nbx][nby] == '#' || (nbx == nrx && nby == nry)) { // 벽 또는 빨강 구슬에 부딪치면
                        nbx = nbx - dx[i];
                        nby = nby - dy[i];
                        break;
                    } else if (area[nbx][nby] == 'O') { // 골인
                        continue Out;
                    }
                    nbx += dx[i];
                    nby += dy[i];
                }
                //System.out.println(nrx + " " + nry + " " + nbx + " "  + nby);
                // 빨강 구슬
                while (true) {
                    if (nrx == -1 && nry == -1) break; // 이미 골인한 경우
                    if (area[nrx][nry] == '#' || (nrx == nbx && nry == nby)) { // 벽 또는 파랑 구슬에 부딪치면
                        nrx = nrx - dx[i];
                        nry = nry - dy[i];
                        break;
                    }
                    nrx += dx[i];
                    nry += dy[i];
                }
                if (goalCheck) {
                    ans = check.count + 1;
                    return;
                } // 문제없이 골인했을 경우
                if (visit[nrx][nry][nbx][nby]) continue;// 방문했던 위치
                visit[nrx][nry][nbx][nby] = true;
                queue.add(new Point(nrx, nry, nbx, nby, check.count + 1));
            }
        }
    }
}

