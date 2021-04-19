package bakjoon.floydwarshallalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BakJoon1956 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());
        int[][] distance = new int[nodeCount + 1][nodeCount + 1];
        // 초기화
        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }
        // 입력
        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            distance[start][end] = weight;
        }
        // 플루이드 와샬
        for (int k = 1; k <= nodeCount; k++) {
            for (int i = 1; i <= nodeCount; i++) {
                if (i == k) continue;
                for (int j = 1; j <= nodeCount; j++) {
                    if (j == i || j == k) continue;
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        // 후처리
        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                if (distance[i][j] == Integer.MAX_VALUE / 2) {
                    distance[i][j] = 0;
                }
                //System.out.print(distance[i][j] + " ");
            }
            //System.out.println();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                if (i == j || distance[i][j] == 0 || distance[j][i] == 0) continue;
                int sum = distance[i][j] + distance[j][i];
                if (sum < min) {
                    min = sum;
                }
            }
        }
        if (min == Integer.MAX_VALUE){
            System.out.print(-1);
        }else{
            System.out.println(min);
        }
    }
}
