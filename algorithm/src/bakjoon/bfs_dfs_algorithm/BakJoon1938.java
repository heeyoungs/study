package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 통나무 옮기기
public class BakJoon1938 {
    static int N;
    static char[][] area;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = 0;
    static boolean[][][] visit;
    static Point end;
    static Point logPoint;

    static class Point {
        int ax;
        int ay;
        int bx;
        int by;
        int cx;
        int cy;
        int count;
        int force;

        Point() {
        }

        Point(int ax, int ay, int bx, int by, int cx, int cy, int count, int force) {
            this.ax = ax;
            this.ay = ay;
            this.bx = bx;
            this.by = by;
            this.cx = cx;
            this.cy = cy;
            this.count = count;
            this.force = force;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new char[N][N];
        visit = new boolean[N][N][2]; // 0수평 1수직
        int logC = 1;
        int endC = 1;
        logPoint = new Point();
        end = new Point();
        for (int h = 0; h < N; h++) {
            String input = br.readLine();
            for (int w = 0; w < N; w++) {
                area[w][h] = input.charAt(w);
                // 통나무 위치 찍어주기
                if (area[w][h] == 'B') {
                    if (logC == 1) {
                        logPoint.ax = w;
                        logPoint.ay = h;
                        logC++;
                    } else if (logC == 2) {
                        logPoint.bx = w;
                        logPoint.by = h;
                        logC++;
                    } else if (logC == 3) {
                        logPoint.cx = w;
                        logPoint.cy = h;
                    }
                }
                // 도착지점 위치 찍어주기
                if (area[w][h] == 'E') {
                    if (endC == 1) {
                        end.ax = w;
                        end.ay = h;
                        endC++;
                    } else if (endC == 2) {
                        end.bx = w;
                        end.by = h;
                        endC++;
                    } else if (endC == 3) {
                        end.cx = w;
                        end.cy = h;
                    }
                }

            }
        }

        bfs(logPoint);
        System.out.println(ans);
    }

    static void bfs(Point logPoint) {
        Queue<Point> queue = new LinkedList<>();
        // 수평
        if (((logPoint.bx + 1 == logPoint.ax) && (logPoint.by == logPoint.ay))
                || ((logPoint.bx - 1 == logPoint.ax) && (logPoint.by == logPoint.ay))) {
            visit[logPoint.bx][logPoint.by][0] = true;
            queue.add(new Point(logPoint.ax, logPoint.ay, logPoint.bx, logPoint.by, logPoint.cx, logPoint.cy, 0, 0));
        } else {
            visit[logPoint.bx][logPoint.by][1] = true;
            queue.add(new Point(logPoint.ax, logPoint.ay, logPoint.bx, logPoint.by, logPoint.cx, logPoint.cy, 0, 1));
        }
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            if (((check.ax == end.ax && check.ay == end.ay) && (check.bx == end.bx && check.by == end.by) && (check.cx == end.cx && check.cy == end.cy))
                    || ((check.cx == end.ax && check.cy == end.ay) && (check.bx == end.by && check.by == end.by) && (check.ax == end.cx && check.ay == end.cy))) {
                ans = check.count;
                return;
            }

            for (int i = 0; i < 4; i++) { // 상하 좌우 이동
                int nax = check.ax + dx[i];
                int nay = check.ay + dy[i];
                int nbx = check.bx + dx[i];
                int nby = check.by + dy[i];
                int ncx = check.cx + dx[i];
                int ncy = check.cy + dy[i];
                if (nax < 0 || nay < 0 || nax >= N || nay >= N) continue;
                if (nbx < 0 || nby < 0 || nbx >= N || nby >= N) continue;
                if (ncx < 0 || ncy < 0 || ncx >= N || ncy >= N) continue;
                if (area[nax][nay] == '1') continue;
                if (area[nbx][nby] == '1') continue;
                if (area[ncx][ncy] == '1') continue;
                if (visit[nbx][nby][check.force]) continue;
                visit[nbx][nby][check.force] = true;
                queue.add(new Point(nax, nay, nbx, nby, ncx, ncy, check.count + 1, check.force));
            }
            // 90도 턴!
            // -> ax 위쪽, ax 오른쪽, ax 왼쪽, ax 아래쪽 -> 회전은 오른쪽으로만 해주자
            if ((check.bx + 1 == check.ax) && (check.by == check.ay)) { // 오른쪽 일 시
                // 8방체크
                if (check.bx + 1 >= N) continue;
                if (check.by + 1 >= N) continue;
                if (check.bx - 1 < 0) continue;
                if (check.by - 1 < 0) continue;
                if (area[check.bx + 1][check.by] == '1') continue;
                if (area[check.bx - 1][check.by] == '1') continue;
                if (area[check.bx][check.by + 1] == '1') continue;
                if (area[check.bx][check.by - 1] == '1') continue;
                if (area[check.bx + 1][check.by + 1] == '1') continue;
                if (area[check.bx + 1][check.by - 1] == '1') continue;
                if (area[check.bx - 1][check.by + 1] == '1') continue;
                if (area[check.bx - 1][check.by - 1] == '1') continue;
                int nax = check.bx;
                int nay = check.by + 1;
                int ncx = check.bx;
                int ncy = check.by - 1;
                if (visit[check.bx][check.by][(check.force + 1)%2]) continue;
                visit[check.bx][check.by][(check.force + 1)%2] = true;
                queue.add(new Point(nax, nay, check.bx, check.by, ncx, ncy, check.count + 1,(check.force + 1)%2));
            } else if ((check.bx == check.ax) && (check.by - 1 == check.ay)) { // 아래쪽 일 시시
                // 8방체크
                if (check.bx + 1 >= N) continue;
                if (check.by + 1 >= N) continue;
                if (check.bx - 1 < 0) continue;
                if (check.by - 1 < 0) continue;
                if (area[check.bx + 1][check.by] == '1') continue;
                if (area[check.bx - 1][check.by] == '1') continue;
                if (area[check.bx][check.by + 1] == '1') continue;
                if (area[check.bx][check.by - 1] == '1') continue;
                if (area[check.bx + 1][check.by + 1] == '1') continue;
                if (area[check.bx + 1][check.by - 1] == '1') continue;
                if (area[check.bx - 1][check.by + 1] == '1') continue;
                if (area[check.bx - 1][check.by - 1] == '1') continue;
                int nax = check.bx - 1;
                int nay = check.by;
                int ncx = check.bx + 1;
                int ncy = check.by;
                if (visit[check.bx][check.by][(check.force + 1)%2]) continue;
                visit[check.bx][check.by][(check.force + 1)%2] = true;
                queue.add(new Point(nax, nay, check.bx, check.by, ncx, ncy, check.count + 1,(check.force + 1)%2));
            } else if ((check.bx - 1 == check.ax) && (check.by == check.ay)) { // 왼쪽 일 시
                // 8방체크
                if (check.bx + 1 >= N) continue;
                if (check.by + 1 >= N) continue;
                if (check.bx - 1 < 0) continue;
                if (check.by - 1 < 0) continue;
                if (area[check.bx + 1][check.by] == '1') continue;
                if (area[check.bx - 1][check.by] == '1') continue;
                if (area[check.bx][check.by + 1] == '1') continue;
                if (area[check.bx][check.by - 1] == '1') continue;
                if (area[check.bx + 1][check.by + 1] == '1') continue;
                if (area[check.bx + 1][check.by - 1] == '1') continue;
                if (area[check.bx - 1][check.by + 1] == '1') continue;
                if (area[check.bx - 1][check.by - 1] == '1') continue;
                int nax = check.bx;
                int nay = check.by - 1;
                int ncx = check.bx;
                int ncy = check.by + 1;
                if (visit[check.bx][check.by][(check.force + 1)%2]) continue;
                visit[check.bx][check.by][(check.force + 1)%2] = true;
                queue.add(new Point(nax, nay, check.bx, check.by, ncx, ncy, check.count + 1,(check.force + 1)%2));
            } else if ((check.bx == check.ax) && (check.by + 1 == check.ay)) { // 위쪽일시
                // 8방체크
                if (check.bx + 1 >= N) continue;
                if (check.by + 1 >= N) continue;
                if (check.bx - 1 < 0) continue;
                if (check.by - 1 < 0) continue;
                if (area[check.bx + 1][check.by] == '1') continue;
                if (area[check.bx - 1][check.by] == '1') continue;
                if (area[check.bx][check.by + 1] == '1') continue;
                if (area[check.bx][check.by - 1] == '1') continue;
                if (area[check.bx + 1][check.by + 1] == '1') continue;
                if (area[check.bx + 1][check.by - 1] == '1') continue;
                if (area[check.bx - 1][check.by + 1] == '1') continue;
                if (area[check.bx - 1][check.by - 1] == '1') continue;
                int nax = check.bx + 1;
                int nay = check.by;
                int ncx = check.bx - 1;
                int ncy = check.by;
                if (visit[check.bx][check.by][(check.force + 1)%2]) continue;
                visit[check.bx][check.by][(check.force + 1)%2] = true;
                queue.add(new Point(nax, nay, check.bx, check.by, ncx, ncy, check.count + 1,(check.force + 1)%2));
            }
        }
    }
}
