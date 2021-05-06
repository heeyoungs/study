package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자판 점프
public class BakJoon2210 {
    static boolean[] visit = new boolean[1000000];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] area;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        area = new int[5][5];
        for (int h = 0; h < 5; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < 5; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }
        for (int h = 0; h < 5; h++) {
            for (int w = 0; w < 5; w++) {
                StringBuilder sb = new StringBuilder();
                sb.append(area[w][h]);
                dfs(0, sb, new Point(w, h));
            }
        }
        System.out.println(count);
    }

    static void dfs(int depth, StringBuilder sb, Point now) {
        if (depth == 5) {
            int check = Integer.parseInt(String.valueOf(sb));
            if (!visit[check]){
                visit[check] = true;
                count++;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            StringBuilder copySb = new StringBuilder();
            copySb.append(sb);
            int nx = now.x + dx[i];
            int ny = now.y + dy[i];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            Point next = new Point(nx,ny);
            copySb.append(area[nx][ny]);
            dfs(depth + 1,copySb,next);
        }

    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
