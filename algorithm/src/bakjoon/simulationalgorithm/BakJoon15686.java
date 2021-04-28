package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 치킨 배달
public class BakJoon15686 {
    static int N, M;
    static ArrayList<Point> chickenHouse;
    static ArrayList<Point> housePoint;
    static int totalMin = Integer.MAX_VALUE;
    static boolean[] check;

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
        int[][] area = new int[N][N];
        chickenHouse = new ArrayList<>();
        housePoint = new ArrayList<>();
        check = new boolean[14];

        for (int h = 0; h < N; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < N; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
                if (area[w][h] == 2) {
                    chickenHouse.add(new Point(w, h));
                } else if (area[w][h] == 1) {
                    housePoint.add(new Point(w, h));
                }
            }
        }
        chickenSearch(0, 0);
        System.out.println(totalMin);
    }

    static void chickenSearch(int at, int depth) {
        if (depth == M) {
            // 최단 치킨 거리 값 갱신해주기
            int chickenRoad = 0;
            for (Point house : housePoint) {
                int minDist = Integer.MAX_VALUE;
                for (int j = 0; j < 14; j++) {
                    if (!check[j]) continue;
                    Point chick = chickenHouse.get(j);
                    int dist = Math.abs(house.x - chick.x) + Math.abs(house.y - chick.y);
                    minDist = Math.min(dist, minDist);
                }
                chickenRoad += minDist;
            }
            totalMin = Math.min(totalMin, chickenRoad);
            return;
        }

        for (int i = at; i < chickenHouse.size(); i++) {
            check[i] = true;
            chickenSearch(i + 1, depth + 1);
            check[i] = false;
        }
    }
}
