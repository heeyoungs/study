package bakjoon.bfs_dfs_algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.*;

// 소수 경로
public class BakJoon1963 {
    public static void main(String[] args) throws IOException {
        // 아리스토 테네스의 체!
        int[] array = new int[10000]; // 배열 생성
        for (int i = 0; i <= 9999; i++) {
            array[i] = i;
        }
        for (int i = 2; i <= 9999; i++) {
            if (array[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= 9999; j = j + i) {
                array[j] = 0;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(st.nextToken());
        while (testCase-- > 0) {
            int[] visitCount = new int[10000];
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 3 자리는 같고 1 자리만 다르다
            Queue<Integer> Q = new LinkedList<>();
            Q.add(start);
            visitCount[start] = 1;
            while (!Q.isEmpty()) {
                int now = Q.poll();

                if (now == end) {
                    sb.append(visitCount[end] - 1).append("\n");
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    // 첫째 짜리 교체
                    if (i == 0) {
                        int nextNum = (now / 10) * 10;
                        for (int j = 0; j < 10; j++) {
                            if (visitCount[nextNum + j] != 0) continue;
                            if (array[nextNum + j] == 0) continue;
                            visitCount[nextNum + j] = visitCount[now] + 1;
                            Q.add(nextNum + j);
                        }
                    }
                    // 둘째 자리 교체
                    else if (i == 1) {
                        int nextNum = (now / 100) * 100 + now % 10;
                        for (int j = 0; j < 10; j++) {
                            if (visitCount[nextNum + j * 10] != 0) continue;
                            if (array[nextNum + j * 10] == 0) continue;
                            visitCount[nextNum + j * 10] = visitCount[now] + 1;
                            Q.add(nextNum + j * 10);
                        }
                    }
                    // 셋째 자리 교체
                    else if (i == 2) {
                        int nextNum = (now / 1000) * 1000 + now % 100;
                        for (int j = 0; j < 10; j++) {
                            if (visitCount[nextNum + j * 100] != 0) continue;
                            if (array[nextNum + j * 100] == 0) continue;
                            visitCount[nextNum + j * 100] = visitCount[now] + 1;
                            Q.add(nextNum + j * 100);
                        }
                    }
                    // 넷째 자리 교체
                    else {
                        int nextNum = now % 1000;
                        for (int j = 1; j < 10; j++) {
                            if (visitCount[nextNum + j * 1000] != 0) continue;
                            if (array[nextNum + j * 1000] == 0) continue;
                            visitCount[nextNum + j * 1000] = visitCount[now] + 1;
                            Q.add(nextNum + j * 1000);
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
