package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BakJoon7569 {
    static int[][][] ground;
    static int width;
    static int height;
    static int high;
    static final int[] dx = {0, -1, 0, 1, 0, 0};
    static final int[] dy = {1, 0, -1, 0, 0, 0};
    static final int[] dz = {0, 0, 0, 0, 1, -1}; // 3차원 이동
    static Queue<PointXYZ> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        high = Integer.parseInt(st.nextToken());

        ground = new int[width][height][high];

        for (int h = 0; h < high; h++) {
            for (int k = 0; k < height; k++) { // 토마토 심기!!
                st = new StringTokenizer(br.readLine());
                for (int t = 0; t < width; t++) {
                    ground[t][k][h] = Integer.parseInt(st.nextToken());
                    if (ground[t][k][h] == 1) {
                        queue.add(new PointXYZ(t, k, h)); // 토마토가 있는 자리를 큐에 넣기
                    }
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
            PointXYZ check = queue.poll();
            for (int force = 0; force < 6; force++) {
                int nx = check.x + dx[force];
                int ny = check.y + dy[force];
                int nz = check.z + dz[force];
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < width && ny < height && nz < high) {
                    if (ground[nx][ny][nz] == 0) {
                        ground[nx][ny][nz] = ground[check.x][check.y][check.z] + 1;
                        queue.add(new PointXYZ(nx, ny,nz));
                    }
                }
            }
        }

        for(int k =0;k<high;k++) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (ground[j][i][k] == 0) {
                        return -1;
                    }

                    if (ground[j][i][k] > max) {
                        max = ground[j][i][k];
                    }
                }
            }
        }
        return max - 1;
    }

    static class PointXYZ {
        int x;
        int y;
        int z;

        PointXYZ(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
