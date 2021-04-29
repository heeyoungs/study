package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소 2
public class BakJoon17141 {
    static int N, M;
    static int[][] area;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Point> virus = new ArrayList<>();
    static boolean[] checkVirus;
    static int totalVirus;
    static int Ans = Integer.MAX_VALUE;

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
                    // 바이러스 위치 체크
                }
            }
        }
        totalVirus = virus.size();
        checkVirus = new boolean[totalVirus];

        dfs(0, 0);

        if (Ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Ans);
        }
    }

    static Queue<Point> queue = new LinkedList<>();

    static void dfs(int at, int depth) {
        if (depth == M) {
            visit = new boolean[N][N];
            for (int i = 0; i < totalVirus; i++) {
                if (checkVirus[i]) {
                    queue.add(new Point(virus.get(i).x, virus.get(i).y, 0));
                    visit[virus.get(i).x][virus.get(i).y] = true;
                }
            }
            bfs();
            return;
        }

        for (int i = at; i < totalVirus; i++) {
            checkVirus[i] = true;
            dfs(i + 1, depth + 1);
            checkVirus[i] = false;
        }
    }

    static void bfs() {
        int count = 0;
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            count = Math.max(check.count, count);

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || area[nx][ny] == 1) continue;
                visit[nx][ny] = true;
                queue.add(new Point(nx, ny, check.count + 1));
            }
        }

        Out:
        for (int h = 0; h < N; h++) {
            for (int w = 0; w < N; w++) {
                if (!visit[w][h] && area[w][h] != 1) {
                    count = Integer.MAX_VALUE;
                    break Out;
                }
            }
        }

        Ans = Math.min(count, Ans);
    }
}
