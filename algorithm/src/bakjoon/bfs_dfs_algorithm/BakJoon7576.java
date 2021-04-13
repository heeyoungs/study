package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BakJoon7576 {
    static int[][] ground;
    static int width;
    static int height;
    static final int[] dx = {0, -1, 0, 1};
    static final int[] dy = {1, 0, -1, 0};
    static Queue<PointXY> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        ground = new int[width][height];

        for (int k = 0; k < height; k++) { // 토마토 심기!!
            st = new StringTokenizer(br.readLine());
            for (int t = 0; t < width; t++) {
                ground[t][k] = Integer.parseInt(st.nextToken());
                if (ground[t][k] == 1) {
                    queue.add(new PointXY(t, k)); // 토마토가 있는 자리를 큐에 넣기
                }
            }
        }

        bw.write(bfs() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        int max = 0;

        while (!queue.isEmpty()) {
            PointXY check = queue.poll();
            for (int force = 0; force < 4; force++) {
                int nx = check.x + dx[force];
                int ny = check.y + dy[force];
                if (nx >= 0 && ny >= 0 && nx < width && ny < height) {
                    if (ground[nx][ny] == 0) {
                        ground[nx][ny] = ground[check.x][check.y] + 1;
                        queue.add(new PointXY(nx, ny));
                    }
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (ground[j][i]==0){
                    return -1;
                }

                if (ground[j][i] > max){
                    max = ground[j][i];
                }
            }
        }
        return max-1;
    }

    static class PointXY {
        int x;
        int y;

        PointXY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
