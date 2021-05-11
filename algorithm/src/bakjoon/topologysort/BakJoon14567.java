package bakjoon.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 선수 과목
public class BakJoon14567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] inDegree = new int[N + 1];
        int[] dp = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            inDegree[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                dp[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int check = queue.poll();

            for (int ck : list[check]) {
                inDegree[ck]--;
                dp[ck] = Math.max(dp[ck], dp[check] + 1);
                if (inDegree[ck] == 0) {
                    queue.add(ck);
                }
            }
        }

        for(int i=1;i<=N;i++){
            System.out.print(dp[i] + " ");
        }

    }
}
