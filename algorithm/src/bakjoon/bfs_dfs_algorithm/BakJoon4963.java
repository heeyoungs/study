package bakjoon.bfs_dfs_algorithm;

import java.io.*;
// 섬의 개수
public class BakJoon4963 {
    static int[][] arr;
    static int width;
    static int height;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};
    static final int FORCE = 8;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while (true) {
            String[] input = br.readLine().split(" ");
            width = Integer.parseInt(input[0]);
            height = Integer.parseInt(input[1]);
            if (width == 0 && height == 0) {
                break;
            }  // 종료조건

            arr = new int[width][height]; // 지도 생성 1->섬 / 0->바다
            for (int h = 0; h < height; h++) {
                input = br.readLine().split(" ");
                for (int w = 0; w < width; w++) {
                    arr[w][h] = Integer.parseInt(input[w]);
                }
            }
            landCount();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void landCount() throws IOException {
        int count = 0;
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (arr[w][h] == 1) {
                    dfs(w, h);
                    count++;
                }
            }
        }
        bw.write(count + "\n");
    }

    static void dfs(int x, int y) {
        arr[x][y] = 0;

        for (int force = 0; force < FORCE; force++) {
            int nx = x + dx[force];
            int ny = y + dy[force];
            if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;

            if (arr[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
