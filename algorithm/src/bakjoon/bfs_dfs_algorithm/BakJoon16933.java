package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 벽 부수고 이동하기 3
public class BakJoon16933 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][][] visit; // 방문 여부
    static String[] ground; // 지역
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0}; // 동서북남
    static final int FORCE = 4;

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
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int canBreak = Integer.parseInt(st.nextToken());

        visit = new boolean[width][height][canBreak + 1]; // 방문여부 및, 벽 부숨 여부
        ground = new String[height]; // 갈 수 있는 곳과 없는 곳 생성

        for (int h = 0; h < height; h++) {
            ground[h] = br.readLine();
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1, 0, true));
        visit[0][0][0] = true;
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
                if (nx >= 0 && ny >= 0 && nx < width && ny < height && !visit[nx][ny][check.bombCount]) {
                    if (ground[ny].charAt(nx) == '0') { // 벽 없음
                        queue.add(new Point(nx, ny, check.count + 1, check.bombCount, !check.day));
                        visit[nx][ny][check.bombCount] = true;
                    } else if (check.bombCount < canBreak && ground[ny].charAt(nx) == '1' && !visit[nx][ny][check.bombCount+1]) { //  벽있음 + 부술 수 있음 + **안겹침**
                        // 낮일 경우 부숨
                        if (check.day) {
                            queue.add(new Point(nx, ny, check.count + 1, check.bombCount + 1, false));
                            visit[nx][ny][check.bombCount + 1] = true;
                        }
                        // 밤일 경우 그냥 하루 올림
                        else {
                            queue.add(new Point(check.x, check.y, check.count + 1, check.bombCount, true));
                        }
                    }
                }
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}