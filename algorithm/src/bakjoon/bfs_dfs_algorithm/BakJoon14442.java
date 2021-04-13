package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BakJoon14442 { // 방문 여부 및 부순 벽의 개수를 가진 3차원배열을 사용해서 벽을 0,1,2,3개 부쉈을때의 평행세계를 만듬
    static int[][] ground;
    static int[][][] visit;
    static int width;
    static int height;
    static int canBreak;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static final int FORCE = 4;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        canBreak = Integer.parseInt(st.nextToken());
        ground = new int[width][height];
        visit = new int[width][height][canBreak+1];

        for (int h = 0; h < height; h++) { // 땅 초기화
            String input = br.readLine();
            for (int w = 0; w < width; w++) {
                ground[w][h] = input.charAt(w) - '0';
            }
        }
        bfs(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y) throws IOException {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 1, 0));
        visit[x][y][0] = 1;
        int ans = -1;

        while (!queue.isEmpty()) {
            Point check = queue.poll();
            if (check.x == width - 1 && check.y == height - 1) { // 종료조건
                ans = check.count;
                break;
            }
            for (int force = 0; force < FORCE; force++) {
                int nx = check.x + dx[force];
                int ny = check.y + dy[force];
                // 범위 검사
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                // 방문여부 검사
                if (visit[nx][ny][check.bombCount] == 0) { // 방문 안했다면
                    if (ground[nx][ny] == 0) { // 갈 수 있다면
                        visit[nx][ny][check.bombCount] = 1;
                        queue.add(new Point(nx, ny, check.count + 1, check.bombCount));
                    } else if (ground[nx][ny] == 1) { // 벽이 있다면
                        if (check.bombCount < canBreak) { // 부술 수 있다면
                            visit[nx][ny][check.bombCount + 1] = 1;
                            queue.add(new Point(nx, ny, check.count + 1, check.bombCount + 1));
                        }
                    }
                }
            }
        }


        bw.write(ans + "");
    }

    static class Point {
        int x;
        int y;
        int count;
        int bombCount;

        Point(int x, int y, int count, int bombCount) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.bombCount = bombCount;
        }
    }
}
