package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 인구 이동
public class BakJoon16234 {
    static int N, L, R;
    static int[][] area;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        area = new int[N][N];
        for (int h = 0; h < N; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < N; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[N][N];
    }

    static void bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visit[start.x][start.y] = true;
        while(!queue.isEmpty()){
            Point check = queue.poll();

            for(int i=0;i<4;i++){
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];

            }
        }
    }
}
