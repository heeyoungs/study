package bakjoon.floydwarshallalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 비밀 모임
public class BakJoon13424 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int TestCase = Integer.parseInt(br.readLine());
        for (int T = 0; T < TestCase; T++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 정점의 개수
            int M = Integer.parseInt(st.nextToken()); // 간선의 개수
            int[][] distance = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE / 2);
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int pointA = Integer.parseInt(st.nextToken());
                int pointB = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                distance[pointA][pointB] = Math.min(weight, distance[pointA][pointB]);
                distance[pointB][pointA] = Math.min(weight, distance[pointB][pointA]);
            }
            // 플로이드 와샬
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    if (i == k) continue;
                    for (int j = 1; j <= N; j++) {
                        if (j == i || j == k) continue;
                        if (distance[i][j] > distance[i][k] + distance[k][j]) {
                            distance[i][j] = distance[i][k] + distance[k][j];
                        }
                    }
                }
            }
            int friendCount = Integer.parseInt(br.readLine());
            int[] friendArray = new int[friendCount];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < friendCount; i++) {
                friendArray[i] = Integer.parseInt(st.nextToken());
            } // 친구들이 위치한 방의 정보

            int minPoint = 0;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = 0; j < friendCount; j++) {
                    int startPoint = friendArray[j];
                    if (startPoint == i) {
                        sum += 0;
                    } else {
                        sum += distance[startPoint][i];
                    }
                }
                if (minDistance > sum) {
                    minPoint = i;
                    minDistance = sum;
                }
            }
            sb.append(minPoint).append("\n");
        }
        System.out.println(sb);
    }
}
