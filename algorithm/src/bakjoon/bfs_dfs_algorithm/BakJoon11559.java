package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 다리 만들기
public class BakJoon11559 {
    static int Ans = Integer.MAX_VALUE;
    static int N;
    static boolean[][] visit;
    static int[][] area;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int mapNum = 1;

    static class Point {
        int x;
        int y;
        int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        for (int h = 0; h < N; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < N; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 번호 지정해주기
        visit = new boolean[N][N];
        for (int h = 0; h < N; h++) {
            for (int w = 0; w < N; w++) {
                if (visit[w][h] || area[w][h] == 0) continue;
                bfs1(w, h);
                mapNum++;
            }
        }

        // 다리 짓기
        for (int h = 0; h < N; h++) {
            for (int w = 0; w < N; w++) {
                if (area[w][h] == 0) {
                    bfs2(w, h);
                }
            }
        }

        /*
        for(int h=0;h<N;h++){
            for(int w=0;w<N;w++){
                System.out.print(area[w][h] + " ");
            }
            System.out.println();
        }
        System.out.println();
         */

        System.out.println(Ans);
    }

    static void bfs1(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, mapNum));
        visit[x][y] = true;
        area[x][y] = mapNum;
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (!visit[nx][ny] && area[nx][ny] != 0) {
                    area[nx][ny] = check.count;
                    visit[nx][ny] = true;
                    queue.add(new Point(nx, ny, check.count));
                }
            }
        }
    }

    static void bfs2(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visit = new boolean[N][N];
        int dist = 0;
        // 가장 가까운 섬 번호 체크
        int firstMeet = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (area[nx][ny] != 0) {
                firstMeet = area[nx][ny];
                break;
            }
        }
        if (firstMeet == 0) {
            return;
        }
        // 해변이 아니면 종료
        queue.add(new Point(x, y, 1));

        Out:
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            if (check.count >= Ans) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (!visit[nx][ny]) {
                    if (area[nx][ny] == 0) { // 바다
                        visit[nx][ny] = true;
                        queue.add(new Point(nx, ny, check.count + 1));
                    } else if (area[nx][ny] != firstMeet) { // 다른 섬
                        dist = check.count;
                        break Out;
                    }
                }

            }
        }
        //System.out.println(dist);
        Ans = Math.min(Ans, dist);
    }
}
