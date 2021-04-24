package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
// 미로 탐색
public class BakJoon2178 {
    static int[][] arr;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int width;
    static int height;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        height = Integer.parseInt(input[0]);
        width = Integer.parseInt(input[1]);
        arr = new int[width][height];

        for (int h = 0; h < height; h++) {
            String inputLine = br.readLine();
            for (int w = 0; w < width; w++) {
                arr[w][h] = inputLine.charAt(w) - '0';
            }
        }
        bfs(0, 0);
        bw.flush();
        bw.close();
        br.close();
    }


    static void bfs(int x, int y) throws IOException {
        Queue<PointXY> queue = new LinkedList<>();
        queue.add(new PointXY(x, y));

        while (!queue.isEmpty()) { // 넓이탐색하면서 자릿값을 1씩 증가시킨다!!
            PointXY check = queue.poll();
            if (check.x == width - 1 && check.y == height - 1) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < width && ny < height) {
                    if (arr[nx][ny] == 1) {
                        arr[nx][ny] = arr[check.x][check.y] + 1;
                        queue.add(new PointXY(nx, ny));
                    }
                }
            }
        }
        bw.write(arr[width-1][height-1] + "");
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