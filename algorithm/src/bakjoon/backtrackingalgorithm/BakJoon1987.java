package bakjoon.backtrackingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알파벳
public class BakJoon1987 {
    static int height, width;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};
    static char[][] area;
    static int Ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new char[width][height];
        for (int h = 0; h < height; h++) {
            String input = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = input.charAt(w);
            }
        }
        boolean[] visit = new boolean[26];
        visit[area[0][0] - 'A'] = true;
        dfs(0, 0, 1, visit);
        System.out.println(Ans);
    }

    static void dfs(int x, int y, int depth, boolean[] visit) {
        if(depth == 27){
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
            boolean[] copyVisit = new boolean[26];
            for (int k = 0; k < 26; k++) {
                copyVisit[k] = visit[k];
            }

            int nextChar = area[nx][ny] - 'A';
            if (!copyVisit[nextChar]) {
                copyVisit[nextChar] = true;
                Ans = Math.max(Ans, depth + 1);
                dfs(nx, ny, depth + 1, copyVisit);
            }
        }
    }
}
