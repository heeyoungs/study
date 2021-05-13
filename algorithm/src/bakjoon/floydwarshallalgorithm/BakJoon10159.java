package bakjoon.floydwarshallalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 저울
public class BakJoon10159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] area = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            area[front][back] = 1;
            area[back][front] = -1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (k == i || i == j || j == k) continue;
                    if ((area[i][k] == 1 || area[i][k] == -1) && (area[i][k] == area[k][j]))
                        area[i][j] = area[i][k];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int count = -1;
            for (int j = 1; j <= N; j++) {
                if (area[i][j] == 0) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
