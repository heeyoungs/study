package bakjoon.floydwarshallalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 호석이 두마리 치킨
public class BakJoon21278 {
    static int nodeCount;
    static int[][] distGraph;
    static boolean[] check;
    static int AnsDist = Integer.MAX_VALUE;
    static int AnsPointA = 0;
    static int AnsPointB = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());
        distGraph = new int[nodeCount + 1][nodeCount + 1];
        check = new boolean[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                if (i == j) continue;
                distGraph[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int pointA = Integer.parseInt(st.nextToken());
            int pointB = Integer.parseInt(st.nextToken());
            distGraph[pointA][pointB] = 1;
            distGraph[pointB][pointA] = 1;
        }
        // 가중치 1짜리 그뤺
        for (int k = 1; k <= nodeCount; k++) {
            for (int i = 1; i <= nodeCount; i++) {
                if (i == k) continue;
                for (int j = 1; j <= nodeCount; j++) {
                    if (j == i || j == k) continue;
                    if (distGraph[i][j] > distGraph[i][k] + distGraph[k][j]) {
                        distGraph[i][j] = distGraph[i][k] + distGraph[k][j];
                    }
                }
            }
        }
        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                if (distGraph[i][j] == Integer.MAX_VALUE / 2) {
                    distGraph[i][j] = 0;
                }
                //System.out.print(distGraph[i][j] + " ");
            }
            //System.out.println();
        }

        dfs(1, 0);
        System.out.println(AnsPointA + " " + AnsPointB + " " + AnsDist * 2);
    }

    static void dfs(int at, int depth) {
        if (depth == 2) {
            int dist = 0;
            int count = 0;
            int pointA = 0;
            int pointB = 0;
            for (int i = 1; i <= nodeCount; i++) {
                if (check[i] && count == 0) {
                    pointA = i;
                    count++;
                } else if (check[i] && count == 1) {
                    pointB = i;
                    break;
                }
            }
            for (int j = 1; j <= nodeCount; j++) {
                dist += Math.min(distGraph[pointA][j], distGraph[pointB][j]);
            }

            if (dist < AnsDist) {
                AnsDist = dist;
                AnsPointA = pointA;
                AnsPointB = pointB;
            }

            return;
        }

        for (int i = at; i <= nodeCount; i++) {
            check[i] = true;
            dfs(i + 1, depth + 1);
            check[i] = false;
        }
    }
}
