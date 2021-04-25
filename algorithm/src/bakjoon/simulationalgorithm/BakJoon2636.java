package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 치즈
public class BakJoon2636 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] area;
    static boolean[][] visit;
    static int height;
    static int width;
    static boolean isCheese = true;
    static int dayCount = -1;
    static int cheeseCount = 0;

    // point!
    // 치즈 개수 세주기
    // 중간 공기 처리 해주기

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
        } // 초기화

        int temp = 0;
        while (isCheese) {
            int cheeeeeeeeeezzzzz = 0;
            isCheese = false;
            visit = new boolean[width][height];
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    if (area[w][h] == 1) {
                        cheeeeeeeeeezzzzz++;
                    }
                }
            }
            cheeseCount = temp;
            temp = cheeeeeeeeeezzzzz;

            bfs0(0, 0); // 치즈 외부 방문 처리하기
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    if (!visit[w][h] && area[w][h] == 1) {
                        bfs(w, h);
                        isCheese = true;
                    }
                }
            }
            dayCount++;
        }
        System.out.println(dayCount);
        System.out.println(cheeseCount);
    }

    static void bfs0(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[x][y] = true;
        area[x][y] = 2;
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;

                if (!visit[nx][ny] && (area[nx][ny] == 0 || area[nx][ny] == 2)) {
                    visit[nx][ny] = true;
                    area[nx][ny] = 2;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    // 2를 만났을 때 치즈가 녹는걸로 하자
    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;

                // 현재위치가 1, 다음 위치가 2
                if (area[check.x][check.y] == 1 && area[nx][ny] == 2) {
                    area[check.x][check.y] = 0; // 현재 위치를 0으로 바꿔줌!
                    continue;
                }

                // 다음 위치에 치즈가 있고 방문하지 않았으면!
                if (area[nx][ny] == 1 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }

            }
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
