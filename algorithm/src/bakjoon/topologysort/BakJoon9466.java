package bakjoon.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 텀 프로젝트
public class BakJoon9466 {
    static int[] list;
    static int[] inDegree;
    static int N;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            N = Integer.parseInt(br.readLine());
            list = new int[N + 1];
            inDegree = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int input = Integer.parseInt(st.nextToken());
                list[i] = input;
                inDegree[input]++;
            }
            int count = 0;
            visit = new boolean[N + 1];
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
            // 사이클을 이루고 있으면 진입 차수가 0이 될 수가 없다!!!!
            while(!queue.isEmpty()) {
                int check = queue.poll();
                count++;
                inDegree[list[check]]--;
                if (inDegree[list[check]] == 0) {
                    queue.add(list[check]);
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
