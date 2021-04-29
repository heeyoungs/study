package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 연구소 3
public class BakJoon17142 {
    static int[][] area;
    static boolean[][] visit;
    static int N, M;
    static ArrayList<Point> virus = new ArrayList<>();
    static boolean[] checkVirus;
    static int virusCount;
    static int Ans = Integer.MAX_VALUE;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};

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

    // 맵 설정 및 바이러스 위치 체크
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][N];
        for (int h = 0; h < N; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < N; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
                if (area[w][h] == 2) {
                    virus.add(new Point(w, h, -1));
                }
            }
        }
        virusCount = virus.size();
        checkVirus = new boolean[virusCount];

        dfs(0, 0);

        if (Ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Ans);
        }
    }

    static Queue<Point> queue = new LinkedList<>();

    // 조합 처리
    static void dfs(int at, int depth) {
        if (depth == M) {
            visit = new boolean[N][N];
            for (int i = 0; i < virusCount; i++) {
                Point v = virus.get(i);
                //visit[v.x][v.y] = true;
                if (checkVirus[i]) {
                    visit[v.x][v.y] = true;
                    queue.add(new Point(v.x, v.y, 0));
                }
            }
            bfs();
            return;
        }

        for (int i = at; i < virusCount; i++) {
            checkVirus[i] = true;
            dfs(i + 1, depth + 1);
            checkVirus[i] = false;
        }
    }

    static void bfs() {
        int count = 0;
       // int[][] timetable = new int[N][N];
        while (!queue.isEmpty()) {
            Point check = queue.poll();
           // timetable[check.x][check.y] = check.count;

            int nowCount;
            if (area[check.x][check.y] == 2){
                nowCount = 0;
            }else{
                nowCount = check.count;
            }

            count = Math.max(count, nowCount);

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || area[nx][ny] == 1 || visit[nx][ny]) continue;
                visit[nx][ny] = true;
                queue.add(new Point(nx, ny, check.count + 1));
            }
        }
        // 빈칸이 잇으면!
        for (int h = 0; h < N; h++) {
            for (int w = 0; w < N; w++) {
                if (area[w][h] != 1 && !visit[w][h]) {
                    count = Integer.MAX_VALUE;
                }
            }
        }
        Ans = Math.min(Ans, count);
    }
}