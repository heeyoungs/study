package bakjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 택배
public class BakJoon1719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int NodeCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());

        int[][] areaWeight = new int[NodeCount + 1][NodeCount + 1];
        int[][] areaCheckPoint = new int[NodeCount + 1][NodeCount + 1];
        for (int h = 1; h <= NodeCount; h++) {
            for (int w = 1; w <= NodeCount; w++) {
                if (h == w) {
                    areaWeight[w][h] = 0;
                } else {
                    areaWeight[w][h] = Integer.MAX_VALUE / 2;
                }
            }
        }
        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int pointA = Integer.parseInt(st.nextToken());
            int pointB = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            areaWeight[pointA][pointB] = Math.min(weight, areaWeight[pointA][pointB]);
            areaWeight[pointB][pointA] = Math.min(weight, areaWeight[pointB][pointA]);
            areaCheckPoint[pointA][pointB] = pointB;
            areaCheckPoint[pointB][pointA] = pointA;
        }

        for (int k = 1; k <= NodeCount; k++) {
            for (int i = 1; i <= NodeCount; i++) {
                if (i == k) continue;
                for (int j = 1; j <= NodeCount; j++) {
                    if (j == i || j == k) continue;
                    if (areaWeight[i][j] > areaWeight[i][k] + areaWeight[k][j]) {
                        areaWeight[i][j] = areaWeight[i][k] + areaWeight[k][j];
                        areaCheckPoint[i][j] = k;
                    }
                }
            }
        }
        // 틀린 이유 -> 최단경로의 시작점을 찍어줘야하는데 최단경로의 끝점을 찍어줘서..
        // -> 어떻게 수정해야할까요?
        for (int i = 1; i <= NodeCount; i++) {
            for (int j = 1; j <= NodeCount; j++) {
                if (i == j) {
                    sb.append("- ");
                } else {
                    sb.append(areaCheckPoint[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
