package bakjoon.floydwarshallalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BakJoon11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int nodeCount = Integer.parseInt(br.readLine());
        int area[][] = new int[nodeCount][nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < nodeCount; j++) {
                area[j][i] = Integer.parseInt(st.nextToken());
                if (area[j][i] == 0){
                    area[j][i] = Integer.MAX_VALUE/2;
                }
                if (i==j){
                    area[i][j] = 0;
                }
            }
        } // 땅 초기화

        for (int k = 0; k < nodeCount; k++) {
            for (int i = 0; i < nodeCount; i++) {
                for (int j = 0; j < nodeCount; j++) {
                    if ( area[i][k] == 1 && area[k][j] == 1){
                        area[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++) {
                if (area[j][i] == Integer.MAX_VALUE/2){
                    area[j][i] = 0;
                }
                System.out.print(area[j][i] + " ");
            }
            System.out.println();
        }
    }
}
