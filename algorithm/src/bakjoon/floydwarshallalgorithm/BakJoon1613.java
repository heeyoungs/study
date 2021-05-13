package bakjoon.floydwarshallalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 역사
public class BakJoon1613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] area = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            area[first][end] = 1;
            area[end][first] = -1;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k || i == k) continue;
                    if ((area[i][k] == 1 || area[i][k] == -1) && (area[i][k] == area[k][j]))
                        area[i][j] = area[i][k];
                }
            }
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(area[i][j] + " ");
//            }
//            System.out.println();
//        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (area[start][end] == area[end][start]) {
                sb.append("0").append("\n");
            } else if (area[start][end] > area[end][start]) {
                sb.append("-1").append("\n");
            } else {
                sb.append("1").append("\n");
            }
        }
        System.out.println(sb);
    }
}
