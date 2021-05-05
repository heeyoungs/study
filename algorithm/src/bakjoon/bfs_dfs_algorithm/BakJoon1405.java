package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 미친 로봇
public class BakJoon1405 {
    static int[][] area = new int[30][30];
    static int count;
    static double E, W, S, N;
    static double ans = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        count = Integer.parseInt(st.nextToken());
        E = (double) Integer.parseInt(st.nextToken()) / 100;
        W = (double) Integer.parseInt(st.nextToken()) / 100;
        S = (double) Integer.parseInt(st.nextToken()) / 100;
        N = (double) Integer.parseInt(st.nextToken()) / 100;
        boolean[][] visit = new boolean[30][30];
        visit[15][15] = true;
        Point robot = new Point(15, 15);
        dfs(0, visit, robot, 1);
        System.out.println(1 - ans);
    }

    static void dfs(int depth, boolean[][] visit, Point robot, double probability) {
        if (depth == count) {
            return;
        }

        visit[robot.x][robot.y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = robot.x + dx[i];
            int ny = robot.y + dy[i];
            if (i == 0) {
                if (visit[nx][ny]) {
                    ans += probability*E;
                    continue;
                }
                dfs(depth + 1, visit, new Point(nx, ny), probability * E);
            } else if (i == 1) {
                if (visit[nx][ny]) {
                    ans += probability*W;
                    continue;
                }
                dfs(depth + 1, visit, new Point(nx, ny), probability * W);
            } else if (i == 2) {
                if (visit[nx][ny]) {
                    ans += probability*S;
                    continue;
                }
                dfs(depth + 1, visit, new Point(nx, ny), probability * S);
            } else {
                if (visit[nx][ny]) {
                    ans += probability*N;
                    continue;
                }
                dfs(depth + 1, visit, new Point(nx, ny), probability * N);
            }
        }
        visit[robot.x][robot.y] = false;
    }
}
