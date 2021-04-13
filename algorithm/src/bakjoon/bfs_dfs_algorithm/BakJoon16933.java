package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BakJoon16933 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][][] visit; // 방문 여부 및 벽부숨 여부
    static int[][] ground; // 지역
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1}; // 동서북남
    static final int FORCE = 4;
    static int width; // 가로
    static int height; // 세로
    static int canBreak; // 부술 수 있는 벽의 수

    static class Point {
        int x;
        int y;
        int count;
        int bombCount;
        boolean day;

        Point(int x, int y, int count, int bombCount, boolean day) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.bombCount = bombCount;
            this.day = day; // 참->낮, 거짓->밤
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        canBreak = Integer.parseInt(st.nextToken());

        visit = new int[width][height][canBreak + 1]; // 방문여부 및, 벽 부숨 여부
        ground = new int[width][height]; // 갈 수 있는 곳과 없는 곳 생성

        for (int h = 0; h < height; h++) {
            String input = br.readLine();
            for (int w = 0; w < width; w++) {
                ground[w][h] = input.charAt(w) - '0';
            }
        }
        bfs(new Point(0, 0, 1, 0,true));

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(Point start) throws IOException {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visit[start.x][start.y][start.bombCount] = 1;
        int ans = -1;

        while (!queue.isEmpty()) {
            Point check = queue.poll();
            if (check.x == width - 1 && check.y == height - 1) {
                ans = check.count;
                break;
            }

            for (int force = 0; force < FORCE; force++) {
                int nx = check.x + dx[force];
                int ny = check.y + dy[force];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;

                if (visit[nx][ny][check.bombCount] == 0) { // 방문 안함
                    if (ground[nx][ny] == 0) { // 벽 없음
                        visit[nx][ny][check.bombCount] = 1;
                        queue.add(new Point(nx, ny, check.count + 1, check.bombCount,!check.day));




                    } else { // 벽있음
                        if (check.bombCount < canBreak && check.day) { // 낮에만 부술 수 있다
                            visit[nx][ny][check.bombCount + 1] = 1;
                            queue.add(new Point(nx, ny, check.count + 1, check.bombCount + 1,false));
                        }
                    }
                }
            }
        }
        bw.write(ans + "");
    }
}
