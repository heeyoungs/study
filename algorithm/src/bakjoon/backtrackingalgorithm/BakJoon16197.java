package bakjoon.backtrackingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 두 동전
public class BakJoon16197 {
    static int width, height;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] area;
    static int Ans = Integer.MAX_VALUE;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new char[width][height];
        Point coinA = null;
        Point coinB = null;
        boolean cC = false;
        for (int h = 0; h < height; h++) {
            String input = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = input.charAt(w);
                if (!cC && area[w][h] == 'o') {
                    coinA = new Point(w, h);
                    cC = true;
                    area[w][h] = '.';
                }
                if (cC && area[w][h] == 'o') {
                    coinB = new Point(w, h);
                    area[w][h] = '.';
                }
            }
        }
        dfs(0, coinA, coinB);
        if (Ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Ans);
        }
    }

    static void dfs(int depth, Point coinA, Point coinB) {
        if (depth == 10) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            Point copyCoinA = new Point(coinA.x, coinA.y);
            Point copyCoinB = new Point(coinB.x, coinB.y);

            int outCount = 0;
            int aNX = coinA.x + dx[i];
            int aNY = coinA.y + dy[i];
            int bNX = coinB.x + dx[i];
            int bNY = coinB.y + dy[i];
            // 밖으로 떨어짐 처리
            if (aNX < 0 || aNY < 0 || aNX >= width || aNY >= height)
                outCount++;
            if (bNX < 0 || bNY < 0 || bNX >= width || bNY >= height)
                outCount++;

            // 하나도 안떨어짐
            if (outCount == 0) {
                // A 동전의 이동
                if (area[aNX][aNY] == '.') {
                    copyCoinA = new Point(aNX, aNY);
                }
                // B 동전의 이동
                if (area[bNX][bNY] == '.') {
                    copyCoinB = new Point(bNX, bNY);
                }
                dfs(depth + 1, copyCoinA, copyCoinB);
            }

            // 하나만 떨어짐
            else if (outCount == 1) {
                Ans = Math.min(Ans, depth + 1);
            }
            // 둘다 떨어짐 -> 처리 x
        }
    }
}
