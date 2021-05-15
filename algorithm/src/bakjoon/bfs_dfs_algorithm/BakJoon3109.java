package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 빵집
public class BakJoon3109 {
    static int height, width;
    static char[][] area;
    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};
    static int ans = 0;
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        height = Integer.parseInt(input[0]);
        width = Integer.parseInt(input[1]);
        area = new char[width][height];
        for (int h = 0; h < height; h++) {
            String line = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = line.charAt(w);
            }
        }
        // 오른쪽 맨 위에서 부터 시작해서 왼쪽 맨 위까지
        for (int i = 0; i < height; i++) {
            area[0][i] = 'x';
            dfs(new Point(0, i));
        }
        System.out.println(ans);
    }

    static boolean dfs(Point pt) {
        if (pt.x == width - 1) {
            ans++;
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nx = pt.x + dx[i];
            int ny = pt.y + dy[i];
            if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
            if (area[nx][ny] == 'x') continue;
            area[nx][ny] = 'x';
            if (dfs(new Point(nx,ny)))return true;
        }
        return false;
    }
}
