package bakjoon.backtrackingalgorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 소문난 칠공주
public class BakJoon1941 {
    static int ans = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] area = new char[5][5];
        for (int h = 0; h < 5; h++) {
            String line = br.readLine();
            for (int w = 0; w < 5; w++) {
                area[w][h] = line.charAt(w);
            }
        }

        dfs(area, 0, 0);
        System.out.print(ans);
    }

    static void dfs(char[][] area, int depth, int at) {
        if (depth == 7) {
            boolean check = false;
            Out:
            for (int h = 0; h < 5; h++) {
                for (int w = 0; w < 5; w++) {
                    //System.out.print(area[w][h]);
                    if (area[w][h] == 'E' || area[w][h] == 'L') {
                        check = bfs(area, w, h);
                        break Out;
                    }
                }
                //System.out.println();
            }
            //System.out.println();
            if (check) ans++;
            return;
        }


        for (int i = at; i < 25; i++) {
            char[][] copyArea = new char[5][5];
            for (int h = 0; h < 5; h++) {
                for (int w = 0; w < 5; w++) {
                    copyArea[w][h] = area[w][h];
                }
            }
            int h = i / 5;
            int w = i % 5;
            if (copyArea[w][h] == 'Y') {
                copyArea[w][h] = 'L';
                dfs(copyArea, depth + 1, i + 1);
            } else if (copyArea[w][h] == 'S') {
                copyArea[w][h] = 'E';
                dfs(copyArea, depth + 1, i + 1);
            }
        }
    }

    static boolean bfs(char[][] area, int x, int y) {
        int countOfE = 0;
        int countOfL = 0;
        boolean[][] visit = new boolean[5][5];
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));
        while (!Q.isEmpty()) {
            Point check = Q.poll();
            if (visit[check.x][check.y]) continue;
            visit[check.x][check.y] = true;

            if (area[check.x][check.y] == 'E'){
                countOfE++;
            }else{
                countOfL++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (area[nx][ny] == 'S' || area[nx][ny] == 'Y') continue;
                Q.add(new Point(nx, ny));
            }
        }
        if ((countOfE + countOfL) == 7 && (countOfE > countOfL)) {
            return true;
        }
        return false;
    }
}

