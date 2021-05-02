package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 말이 되고픈 원숭이
public class BakJoon1600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] area = new int[W][H];
        boolean[][][] visit = new boolean[W][H][K + 1];
        int[] dx = {1, 0, -1, 0, -2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {0, -1, 0, 1, -1, 1, -2, 2, 2, -2, 1, -1}; // 4방향
        for (int h = 0; h < H; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < W; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }
        class Point {
            int x;
            int y;
            int count;
            int houseJumpCount;

            Point(int x, int y, int count, int houseJumpCount) {
                this.x = x;
                this.y = y;
                this.count = count;
                this.houseJumpCount = houseJumpCount;
            }
        }
        // 여기까진 초기화!!
        visit[0][0][0] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0, 0));
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            if (check.x == W - 1 && check.y == H - 1) {
                System.out.println(check.count);
                return;
            }
            for (int i = 0; i < 12; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= W || ny >= H || area[nx][ny] == 1) continue;

                if (check.houseJumpCount < K && !visit[nx][ny][check.houseJumpCount + 1] && i >= 4) {
                    visit[nx][ny][check.houseJumpCount + 1] = true;
                    queue.add(new Point(nx, ny, check.count + 1, check.houseJumpCount + 1));
                } else if (!visit[nx][ny][check.houseJumpCount] && i < 4) {
                    visit[nx][ny][check.houseJumpCount] = true;
                    queue.add(new Point(nx, ny, check.count + 1, check.houseJumpCount));
                }
            }

        }
        System.out.println(-1);
    }
}
