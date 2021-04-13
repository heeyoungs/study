package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BakJoon7562 {
    static int[][] chess;
    static int length;
    static final int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    static final int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Queue<PointXY> queue = new LinkedList<>();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            length = Integer.parseInt(br.readLine());
            chess = new int[length][length];

            st = new StringTokenizer(br.readLine()); // 현재 위치
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            chess[x][y] = 1;
            queue.add(new PointXY(x, y));

            st = new StringTokenizer(br.readLine()); // 가고자하는 위치
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            while (!queue.isEmpty()) {
                PointXY check = queue.poll();
                for (int force = 0; force < 8; force++) {
                    int nx = check.x + dx[force];
                    int ny = check.y + dy[force];
                    if (nx >= 0 && ny >= 0 && nx < length && ny < length) {
                        if(chess[nx][ny] == 0 ){
                            chess[nx][ny] = chess[check.x][check.y] + 1;
                            queue.add(new PointXY(nx,ny));
                        }
                    }
                }
            }
            bw.write(chess[x][y] - 1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
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
