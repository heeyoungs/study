package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.StringTokenizer;
// 안전 영역
public class BakJoon2468 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static final int FORCE = 4;
    static int length;
    static int[][] ground;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        length = Integer.parseInt(br.readLine());
        ground = new int[length][length];
        int max = 0; // 땅의 최대 높이 측정
        for (int h = 0; h < length; h++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int w = 0; w < length; w++) {
                ground[w][h] = Integer.parseInt(st.nextToken());
                if (max < ground[w][h]) {
                    max = ground[w][h];
                }
            }
        }
        int[] SafeCount = new int[max];
        for (int i = 1; i <= max; i++) {
            visit = new boolean[length][length];
            int count = 0;
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    if (ground[k][j] >= i && !visit[k][j]) {
                        dfs(k, j, i);
                        count++;
                    }
                }
            }
            SafeCount[i - 1] = count;
        }
        int ans = 0;
        for (int i = 0; i < max; i++) {
            if (ans < SafeCount[i]) {
                ans = SafeCount[i];
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x, int y, int height) {
        visit[x][y] = true;
        for (int force = 0; force < FORCE; force++) {
            int nx = x + dx[force];
            int ny = y + dy[force];
            if (nx < 0 || ny < 0 || nx >= length || ny >= length) continue;

            if (!visit[nx][ny] && ground[nx][ny] >= height) {
                dfs(nx, ny, height);
            }
        }
    }
}
