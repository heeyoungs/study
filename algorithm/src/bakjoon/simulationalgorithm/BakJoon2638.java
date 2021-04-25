package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 치즈
public class BakJoon2638 {
    static int height;
    static int width;
    static int[][] area;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean isCheese = true;
    static int dayCount = -1;

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
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new int[width][height];
        for (int h = 0; h < height; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < width; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }
        // 여기까지 입력 및 초기화 부분

        while (isCheese) {
            isCheese = false;
            visit = new boolean[width][height];
            searchOut();
            // 치즈 외곽 부분을 먼저 찾아서 표시해줌 -> 2
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    if (!visit[w][h] && area[w][h] == 1) {
                        cheeseRemove(w, h);
                        isCheese = true;
                    }
                }
            }
            // 치즈 지우기
            dayCount++;
        }
        System.out.println(dayCount);
    }

    static void cheeseRemove(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;

                // 현재 위치가 치즈 다음 위치가 공기일 때!
                if (area[check.x][check.y] == 1 && area[nx][ny] == 2) {
                    int count = 0;
                    // 4방향 탐색
                    for (int k = 0; k < 4; k++) {
                        int findX = check.x + dx[k];
                        int findY = check.y + dy[k];
                        if (area[findX][findY] == 2) {
                            count++;
                        }
                    }
                    if (count >= 2) {
                        area[check.x][check.y] = 0;
                    }
                    continue;
                }


                if (!visit[nx][ny] && area[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    static void searchOut() {
        visit[0][0] = true;
        area[0][0] = 2;
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(0, 0));
        while (!stack.isEmpty()) {
            Point check = stack.pop();
            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;

                if ((area[nx][ny] == 0 || area[nx][ny] == 2) && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    area[nx][ny] = 2;
                    stack.add(new Point(nx, ny));
                }
            }
        }
    }
}
