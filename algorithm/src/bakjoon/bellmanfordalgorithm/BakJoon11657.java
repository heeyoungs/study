package bakjoon.bellmanfordalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BakJoon11657 { // 벨멘 포드 -> 다익스트라
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());
        long[][] timeTable = new long[nodeCount + 1][nodeCount + 1];
        long[] result = new long[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            Arrays.fill(timeTable[i], Integer.MAX_VALUE);
        }
        Arrays.fill(result, Integer.MAX_VALUE);
        result[1] = 0;
        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            timeTable[start][end] = Math.min(weight, timeTable[start][end]);
        }// 간선끼리 이어줌

        boolean cycle = false;

        for (int k = 0; k < nodeCount - 1; k++) { // n-1번 반복!!
            for (int i = 1; i <= nodeCount; i++) {
                for (int j = 1; j <= nodeCount; j++) {
                    if (i == j || result[i] == Integer.MAX_VALUE || timeTable[i][j] == Integer.MAX_VALUE)
                        continue;
                    if (result[i] + timeTable[i][j] < result[j]) {
                        result[j] = result[i] + timeTable[i][j];
                    }
                }
            }
        }

        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                if (i == j || result[i] == Integer.MAX_VALUE || timeTable[i][j] == Integer.MAX_VALUE) continue;
                if (result[i] + timeTable[i][j] < result[j]) {
                    result[j] = result[i] + timeTable[i][j];
                    cycle = true;
                    break;
                }
            }
        }

        if (cycle) {
            sb.append(-1);
        } else {
            for (int i = 2; i <= nodeCount; i++) {
                if (result[i] == Integer.MAX_VALUE) { // 경로가 없는 경우
                    result[i] = -1;
                }
                sb.append(result[i] + "\n");
            }
        }
        System.out.print(sb);
    }
}
