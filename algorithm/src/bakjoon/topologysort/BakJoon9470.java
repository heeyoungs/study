package bakjoon.topologysort;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Strahler 순서
public class BakJoon9470 {
    static int[] inDegree;
    static int[] strahler;
    static int[] count;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            inDegree = new int[M + 1];
            strahler = new int[M + 1];
            count = new int[M + 1];
            list = new ArrayList[M + 1];
            for (int i = 1; i <= M; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                inDegree[b]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= M; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                    strahler[i] = 1;
                }
            }
            while (!queue.isEmpty()) {
                int check = queue.poll();

                for (int next : list[check]) {
                    inDegree[next]--;
                    if (strahler[next] == strahler[check]) {
                        count[next]++;
                        if (count[next] == 2) {
                            strahler[next]++;
                        }
                    } else if (strahler[next] < strahler[check]) {
                        strahler[next] = strahler[check];
                        count[next] = 1;
                    }
                    if (inDegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
            int ans = 0;
            for (int i = 1; i <= M; i++) {
                ans = Math.max(ans, strahler[i]);
            }
            sb.append(K).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
