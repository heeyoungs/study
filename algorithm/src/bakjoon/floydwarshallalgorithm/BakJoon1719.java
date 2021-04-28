package bakjoon.floydwarshallalgorithm;

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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] area = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) area[i][j] = 0;
                else area[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        mem = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pointA = Integer.parseInt(st.nextToken());
            int pointB = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            area[pointA][pointB] = Math.min(weight, area[pointA][pointB]);
            area[pointB][pointA] = Math.min(weight, area[pointB][pointA]);
        }

        // 플로이드 와샬
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (area[i][j] > area[i][k] + area[k][j]) {
                        area[i][j] = area[i][k] + area[k][j];
                        mem[i][j] = k;
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i==j || area[i][j] == Integer.MAX_VALUE/2){
                    sb.append("- ");
                    continue;
                }
                int path = Path(i,j);
                sb.append(path).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static int[][] mem;
    static int Path(int start,int end){
        if (mem[start][end] == 0){
            return end;
        }
        return Path(start,mem[start][end]);
    }
}
