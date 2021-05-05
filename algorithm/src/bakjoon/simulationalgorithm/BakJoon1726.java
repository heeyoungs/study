package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 로봇
public class BakJoon1726 {
    static int height, width;
    static int[][] area;
    static boolean[][][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int endX, endY, endForce;
    static int Ans = Integer.MAX_VALUE;

    static class Point {
        int x, y, count, force;

        Point(int x, int y, int count, int force) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.force = force;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new int[width + 1][height + 1];
        visit = new boolean[width + 1][height + 1][4];
        for (int h = 1; h <= height; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 1; w <= width; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int startForce = Integer.parseInt(st.nextToken());
        // 방향 재 설정
        if (startForce == 1) {
            startForce = 0;
        } else if (startForce == 4) {
            startForce = 1;
        }

        st = new StringTokenizer(br.readLine());
        endY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());
        endForce = Integer.parseInt(st.nextToken());

        if (endForce == 1) {
            endForce = 0;
        } else if (endForce == 4) {
            endForce = 1;
        }

//        for (int h = 1; h <= height; h++) {
//            for (int w = 1; w <= width; w++) {
//                System.out.print(area[w][h] + " ");
//            }
//            System.out.println();
//        }

        bfs(startX, startY, startForce);
        System.out.println(Ans);
    }

    static void bfs(int x, int y, int force) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0, force));
        visit[x][y][force] = true;
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            if (check.x == endX && check.y == endY && check.force == endForce) {
                Ans = check.count;
                return;
            }
            for (int i = 1; i <= 3; i++) {
                int nx = check.x + dx[check.force] * i;
                int ny = check.y + dy[check.force] * i;
                if (nx < 1 || ny < 1 || nx > width || ny > height) continue;
                if (i == 1 && area[nx][ny] == 1) break;
                if (i == 2 && area[nx][ny] == 1) break;
                if (i == 3 && area[nx][ny] == 1) break;
                if (!visit[nx][ny][check.force]) {
                    visit[nx][ny][check.force] = true;
                    queue.add(new Point(nx, ny, check.count + 1, check.force));
                }
            }
            // 회전 인큐
            // -> 좌
            if (!visit[check.x][check.y][(check.force + 1) % 4]) {
                visit[check.x][check.y][(check.force + 1) % 4] = true;
                queue.add(new Point(check.x, check.y, check.count + 1, (check.force + 1) % 4));
            }
            //-> 우
            if (!visit[check.x][check.y][(check.force + 3) % 4]) {
                visit[check.x][check.y][(check.force + 3) % 4] = true;
                queue.add(new Point(check.x, check.y, check.count + 1, (check.force + 3) % 4));
            }
        }
    }
}