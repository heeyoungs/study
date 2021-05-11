package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프 옮기기 1
public class BakJoon17070 {
    static int N;
    static int[][] area;
    static int ans = 0;
    static int[] dx = {1, 1, 0};
    static int[] dy = {0, 1, 1}; // 가로 대각선 세로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        for (int h = 0; h < N; h++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int w = 0; w < N; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, 0, 0);
        System.out.println(ans);
    }
/*
마지막 위치에 따른 다음 위치 제한 !
 */

    static void dfs(int x, int y, int force) {
        if (x == N - 1 && y == N - 1) {
            ans++;
            return;
        }

        // 마지막으로 움직인 방향에 따른 분기
        if (force == 0) {
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= N || ny >= N) continue;
                if (area[nx][ny] == 1) continue;
                if (i == 1) {
                    if ((x + 1 >= N || area[x + 1][y] == 1)) continue;
                    if ((y + 1 >= N || area[x][y + 1] == 1)) continue;
                }
                dfs(nx, ny, i);
            }
        } else if (force == 1) {
            for (int i = 0; i < 3; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= N || ny >= N) continue;
                if (area[nx][ny] == 1) continue;
                if (i == 1) {
                    if ((x + 1 >= N || area[x + 1][y] == 1)) continue;
                    if ((y + 1 >= N || area[x][y + 1] == 1)) continue;
                }
                dfs(nx, ny, i);
            }
        } else if (force == 2) {
            for (int i = 1; i < 3; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= N || ny >= N) continue;
                if (area[nx][ny] == 1) continue;
                if (i == 1) {
                    if ((x + 1 >= N || area[x + 1][y] == 1)) continue;
                    if ((y + 1 >= N || area[x][y + 1] == 1)) continue;
                }
                dfs(nx, ny, i);
            }
        }
    }
}
