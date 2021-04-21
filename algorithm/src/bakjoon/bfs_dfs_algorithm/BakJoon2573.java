package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BakJoon2573 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        area = new int[width][height];
        for (int h = 0; h < height; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < width; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        } // 할당
        queue = new LinkedList<>();
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (area[w][h] == 0) {
                    queue.add(new Point(w, h, 0));
                }
            }
        }
        bfs();
    }

    static int height;
    static int width;
    static Queue<Point> queue;
    static int[][] area;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visit;

    static int count = 0;

    static void searchCount() { // 빙산 개수 탐색
        visit = new boolean[width][height];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (area[w][h] != 0 && !visit[w][h]) { // 방문하지 않고 빙산 있는 구역
                    dfs(w, h);
                    count++;
                }
            }
        }
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= width || ny >= height || visit[nx][ny]) continue;
            if (area[nx][ny] != 0){
                dfs(nx,ny);
            }
        }
    }

    static void bfs() {
        int dayCount = 0;
        int ans = 0;
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            if (check.time > dayCount) { // 하루가 지남
                // 빙산이 갈라졌는지 검사해야지~
                count = 0;
                searchCount();
                if (count > 1) { // 두 덩어리 이상일 경우
                    ans = check.time;
                    break;
                }

                dayCount++;
            }
            boolean kk = false;
            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height || area[nx][ny] == 0) continue;

                if (area[nx][ny] != 0) { // 빙산이 있을 경우
                    area[nx][ny] = area[nx][ny] - 1; // 하나씩 녹여
                    if (area[nx][ny] == 0) { // 다 녹았으면 넣어
                        queue.add(new Point(nx, ny, check.time + 1));
                    }
                    if (!kk) {
                        queue.add(new Point(check.x, check.y, check.time + 1)); // 이거 중북 제거 해줘야될듯
                        kk = true;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static class Point {
        int x;
        int y;
        int time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
