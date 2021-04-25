package bakjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 치킨 배달
public class BakJoon15686 {
    static int[][] area;
    static int N, M;
    static int totalChicken = 0;
    static Point[] chickenHouse = new Point[13];
    static int[] pck = new int[13];
    static int totalMin = 0;

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
        M = Integer.parseInt(st.nextToken());
        area = new int[N][N];
        for (int h = 0; h < N; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < N; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
                if (area[w][h] == 2) {
                    chickenHouse[totalChicken] = new Point(w, h);
                    totalChicken++;
                    area[w][h] = 0;
                }
            }
        }


    }

}
