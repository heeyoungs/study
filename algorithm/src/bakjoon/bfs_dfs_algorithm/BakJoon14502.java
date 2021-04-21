package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BakJoon14502 {
    static int height;
    static int width;
    static int[][] area;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int safeCount = 0; // 안전 지대의 개수
    static int virusCount; // 바이러스의 영역
    static int wallCount = 0; // 벽의 개수


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new int[width][height];
        visit = new boolean[width][height];
        for (int h = 0; h < height; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < width; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
                if (area[w][h] == 1) {
                    wallCount++;
                }
            }
        } // 땅 초기화
        // 벽 세개씩 세워보기
        for (int y1 = 0; y1 < height; y1++) {
            for (int x1 = 0; x1 < width; x1++) {
                if (area[x1][y1] == 1 || area[x1][y1] == 2) continue;
                area[x1][y1] = 1;
                for (int y2 = 0; y2 < height; y2++) {
                    for (int x2 = 0; x2 < width; x2++) {
                        if (area[x2][y2] == 1 || area[x2][y2] == 2) continue;
                        area[x2][y2] = 1;
                        for (int y3 = 0; y3 < height; y3++) {
                            for (int x3 = 0; x3 < width; x3++) {
                                if (area[x3][y3] == 1 || area[x3][y3] == 2) continue;
                                area[x3][y3] = 1; // 벽 짓기

                                find();

                                area[x3][y3] = 0;
                            }
                        }
                        area[x2][y2] = 0;
                    }
                }
                area[x1][y1] = 0;
            }
        }

        System.out.print(safeCount);
    }

    static void find() {
        virusCount = 0;
        visit = new boolean[width][height];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (area[w][h] == 2 && !visit[w][h]) {
                    bfs(w, h);
                }
            }
        }
        // 안전지대의 개수 = 바이러스의 영역 - 벽의 개수
        int check = width * height - virusCount - wallCount - 3;
        safeCount = Math.max(check, safeCount);
    }

    static void bfs(int x, int y) { // 2를 기준으로
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < width && ny < height) {
                    if (!visit[nx][ny] && area[nx][ny] == 0) {
                        visit[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
        virusCount += count;
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
