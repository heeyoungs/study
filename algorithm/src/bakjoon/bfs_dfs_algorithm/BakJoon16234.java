package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;
// 인구 이동
public class BakJoon16234 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] area;
    static int[][] visit;
    static int visitCount = 1;
    static int N;
    static int L;
    static int R;
    static int count = -1;
    static boolean move = true;

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

        while (move) {
            move = false;
            visit = new int[N][N];

            for (int h = 0; h < N; h++) {
                for (int w = 0; w < N; w++) {
                    if (visit[w][h] == 0) {
                        bfs(w, h);
                    }
                }
            }

            for(int h=0;h<N;h++){
                for(int w=0;w<N;w++){
                    //System.out.print(area[w][h] + " ");
                    if (visit[w][h] != 0){
                        area[w][h] = map.get(visit[w][h]);
                    }
                }
                //.out.println();
            }

            count++;
        }
        System.out.println(count);
    }
    static HashMap<Integer,Integer> map = new HashMap<>();

    static void bfs(int x, int y) {
        Stack<Point> S = new Stack<>();
        visit[x][y] = visitCount;
        S.add(new Point(x, y));
        int sum = 0;
        int count = 0;
        while (!S.isEmpty()) {
            Point check = S.pop();
            sum = sum + area[check.x][check.y];
            count++;

            for (int i = 0; i < 4; i++) {
                int nextX = check.x + dx[i];
                int nextY = check.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || visit[nextX][nextY] != 0) continue; // 갔던곳 또는 맵 밖

                if (Math.abs(area[check.x][check.y] - area[nextX][nextY]) >= L && Math.abs(area[check.x][check.y] - area[nextX][nextY]) <= R) {
                    visit[nextX][nextY] = visitCount;
                    S.add(new Point(nextX, nextY));
                }
            }
        }
        int avg = sum / count;
        map.put(visitCount,avg);
        visitCount++;
        if (count != 1) {
            move = true;
        }
    }
}
