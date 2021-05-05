package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 데스 나이트
public class BakJoon16948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] area = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());
        bfs(N, startX, startY, area);
//        for(int h=0;h<N;h++){
//            for(int w=0;w<N;w++){
//                System.out.print(area[w][h] + " ");
//            }
//            System.out.println();
//        }


        if (area[endX][endY] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(area[endX][endY]);
        }
    }

    static void bfs(int N, int x, int y, int[][] area) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (area[nx][ny] == 0) {
                    area[nx][ny] = area[check.x][check.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
