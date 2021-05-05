package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 음식물 피하기
public class BakJoon1743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int trashCount = Integer.parseInt(st.nextToken());
        int Ans = -1;
        int[][] area = new int[width + 1][height + 1];
        for (int i = 0; i < trashCount; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            area[x][y] = 1;
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        boolean[][] visit = new boolean[width + 1][height + 1];
        class Point {
            int x;
            int y;

            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        for (int h = 1; h <= height; h++) {
            for (int w = 1; w <= width; w++) {
                if (!visit[w][h] && area[w][h] == 1) {
                    int count = 0;
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(w, h));
                    visit[w][h] = true;
                    while (!queue.isEmpty()) {
                        Point check = queue.poll();
                        count++;
                        for (int i = 0; i < 4; i++) {
                            int nx = check.x + dx[i];
                            int ny = check.y + dy[i];
                            if (nx < 1 || ny < 1 || nx > width || ny > height) continue;
                            if (area[nx][ny] == 1 && !visit[nx][ny]){
                                visit[nx][ny]= true;
                                queue.add(new Point(nx,ny));
                            }
                        }
                    }
                    Ans = Math.max(Ans,count);
                }
            }
        }
        System.out.println(Ans);
    }
}
