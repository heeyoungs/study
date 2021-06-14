package bakjoon.topologysort;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

// 영우는 사기꾼 (위상 정렬?)
public class BakJoon14676 {
    static int N, M, K;
    static int[] needParent;
    static int[] buildCount;
    static ArrayList<Integer>[] parentList;
    static final String wrong = "Lier!";
    static final String correct = "King-God-Emperor";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        needParent = new int[N + 1];
        buildCount = new int[N + 1];
        parentList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            parentList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            parentList[start].add(end);
            needParent[end]++;
        }

        boolean check = true;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int whatHappen = Integer.parseInt(st.nextToken());
            int towerNum = Integer.parseInt(st.nextToken());
            // 건물을 짓다.
            if (check) {
                if (whatHappen == 1) {
                    for (int next : parentList[towerNum]) {
                        needParent[next]--;
                    }
                    buildCount[towerNum]++;
                    if (needParent[towerNum] > 0) check = false;
                }
                // 건물을 파괴하다.
                else if (whatHappen == 2) {
                    buildCount[towerNum]--;
                    if (buildCount[towerNum] < 0) {
                        check = false;
                        break;
                    }
                    else if (needParent[towerNum] == 0 && buildCount[towerNum] == 0) {
                        for (int next : parentList[towerNum]) {
                            needParent[next]++;
                        }
                    }
                }
            }
        }
        if (check) System.out.println(correct);
        else System.out.println(wrong);
    }
}
