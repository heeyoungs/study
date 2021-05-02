package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 미세먼지 안녕!
public class BakJoon17144 {
    static int height, width, T;
    static int[][] area;
    static int[][] copyArea;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Point UpCleaner;
    static Point DownCleaner;

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
        T = Integer.parseInt(st.nextToken());
        area = new int[width][height];
        int cleaner = 0;
        for (int h = 0; h < height; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < width; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
                if (area[w][h] == -1 && cleaner == 0) {
                    UpCleaner = new Point(w, h);
                    cleaner++;
                }
                if (area[w][h] == -1 && cleaner == 1) {
                    DownCleaner = new Point(w, h);
                }
            }
        }
        int upX = UpCleaner.x;
        int upY = UpCleaner.y;
        int downX = DownCleaner.x;
        int downY = DownCleaner.y;

        int dayCount = 0;
        while (dayCount != T) {
            copyArea = new int[width][height];
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    if (area[w][h] == 0 || area[w][h] == -1) continue;
                    spread(w, h);
                }
            }
            // 먼지를 퍼뜨려서 copyArea 에 저장 -> 후에 copyArea 값을 area 에 복사
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    if (area[w][h] == -1) {
                        area[w][h] = -1;
                    } else {
                        area[w][h] = copyArea[w][h];
                    }
                }
            }
            // 먼지를 회전 시키는 거! -> 위쪽 공기
            // 위쪽 청소
            area[upX][upY - 1] = 0;
            for (int h = upY - 1; h > 0; h--) {
                area[0][h] = area[0][h - 1];
            }
            for (int w = 0; w < width - 1; w++) {
                area[w][0] = area[w + 1][0];
            }
            for (int h = 0; h < upY; h++) {
                area[width - 1][h] = area[width - 1][h + 1];
            }
            for (int w = width - 1; w > 1; w--) {
                area[w][upY] = area[w - 1][upY];
            }
            area[upX + 1][upY] = 0;
            // 아래쪽 청소
            area[downX][downY + 1] = 0;
            for (int h = downY + 1; h < height-1; h++) {
                area[0][h] = area[0][h + 1];
            }
            for (int w = 0; w < width - 1; w++) {
                area[w][height-1] = area[w + 1][height-1];
            }

            for (int h = height-1; h > downY; h--) {
                area[width-1][h] = area[width-1][h - 1];
            }

            for (int w = width - 1; w > 1; w--) {
                area[w][downY] = area[w - 1][downY];
            }
            area[downX + 1][downY] = 0;
            dayCount++;
        }
        // 정답 출력
        int ans = 0;
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                //System.out.print(area[w][h] + " ");
                if (area[w][h] == -1) continue;
                ans += area[w][h];
            }
            //System.out.println();
        }
        System.out.println(ans);
    }

    static void spread(int x, int y) {
        int count = 0; // 1. 퍼뜨릴 위치를 세준다
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
            if (area[nx][ny] == -1) continue;
            count++;
        }
        // 2. 값을 계산해준다.
        int center = area[x][y] - (area[x][y] / 5) * count;
        int outside = area[x][y] / 5;
        copyArea[x][y] += center;
        // 3. 퍼뜨릴 값을 저장해준다.
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
            if (area[nx][ny] == -1) continue;
            ;
            copyArea[nx][ny] += outside;
        }
    }
}
