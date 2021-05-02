package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 캐슬 디펜스
public class BakJoon17135 {
    static int height, width, dist;
    static int[][] area;
    static Point[] archerPoint;
    static int Ans = -1;

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
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        dist = Integer.parseInt(st.nextToken());
        area = new int[width][height];
        for (int h = 0; h < height; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < width; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }
        archerPoint = new Point[3];
        combine(0, 0);
        System.out.println(Ans);
    }

    static void combine(int at, int depth) {
        if (depth == 3) {
            int[][] copyArea = new int[width][height];
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    copyArea[w][h] = area[w][h];
                }
            }
            int count = 0;
            int dayCount = 0;

            while (dayCount != height) {
                Point[] deletePoint = new Point[3];
                int[] distSave = new int[3];
                Arrays.fill(distSave, Integer.MAX_VALUE);
                // 여기까지 궁수 배치
                for (int h = 0; h < height; h++) {
                    for (int w = 0; w < width; w++) {
                        if (copyArea[w][h] == 1) {
                            for (int i = 0; i < 3; i++) {
                                int getDist = Math.abs(archerPoint[i].x - w) + Math.abs(archerPoint[i].y - h);
                                if (getDist <= dist && distSave[i] >= getDist) {
                                    // 가장 왼쪽의 병사를 지우게 해야됨!!
                                    if (distSave[i] > getDist) {
                                        distSave[i] = getDist;
                                        deletePoint[i] = new Point(w, h);
                                    }else if (distSave[i] == getDist ){ // 최단거리가 같게 들어왔을 경우
                                        if (deletePoint[i].x > w){
                                            deletePoint[i] = new Point(w,h);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // 가장 왼쪽 위 지우기
                for (int i = 0; i < 3; i++) {
                    if (deletePoint[i] == null) continue;
                    if (copyArea[deletePoint[i].x][deletePoint[i].y] == 1) {
                        copyArea[deletePoint[i].x][deletePoint[i].y] = 0;
                        count++;
                    }
                }

                // 배열을 한칸씩 아래로 내려주기
                for (int h = height - 1; h > 0; h--) {
                    for (int w = 0; w < width; w++) {
                        copyArea[w][h] = copyArea[w][h - 1];
                    }
                }
                // 맨 윗줄 초기화
                for (int w = 0; w < width; w++) {
                    copyArea[w][0] = 0;
                }

                dayCount++;
            }
            Ans = Math.max(count, Ans);
            return;
        }

        for (int i = at; i < width; i++) {
            archerPoint[depth] = new Point(i, height);
            combine(i + 1, depth + 1);
        }
    }
}
