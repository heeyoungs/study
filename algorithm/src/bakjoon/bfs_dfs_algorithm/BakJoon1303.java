package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 전쟁 - 전투
public class BakJoon1303 {
    static int height, width;
    static char[][] area;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int W = 0, B = 0;

    static class Point {
        int x;
        int y;
        char color;

        Point(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        area = new char[width][height];
        visit = new boolean[width][height];
        for (int h = 0; h < height; h++) {
            String input = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = input.charAt(w);
            }
        }
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (visit[w][h]) continue;
                bfs(w, h);
            }
        }
        System.out.println(W + " " + B);
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visit[x][y] = true;
        queue.add(new Point(x, y, area[x][y]));
        int count = 0;
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (visit[nx][ny]) continue;
                if (area[nx][ny] == check.color){
                    queue.add(new Point(nx,ny,check.color));
                    visit[nx][ny] = true;
                }
            }
        }
        if (area[x][y] == 'B'){
            B += count * count;
        }else{
            W += count * count;
        }
    }
}
