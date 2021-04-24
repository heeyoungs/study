package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 스타트 링크
public class BakJoon5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken()); // 총 층수
        int S = Integer.parseInt(st.nextToken()); // 강호가 위치한 층
        int G = Integer.parseInt(st.nextToken()); // 사무실이 위치한 층
        int U = Integer.parseInt(st.nextToken()); // up 버튼을 눌렀을 때 올라가지는 층
        int D = Integer.parseInt(st.nextToken()); // Down 버튼을 눌렀을 때 내려가지는 층

        int[] floor = new int[F + 1];
        Arrays.fill(floor,Integer.MAX_VALUE);
        floor[S] = 0;
        boolean[] visit = new boolean[F + 1];

        Queue<Integer> Q = new LinkedList<>();
        Q.add(S);
        visit[S] = true;
        while (!Q.isEmpty()) {
            int nowF = Q.poll();

            int upF = nowF + U;
            int downF = nowF - D;

            if (upF <= F && upF > 0) {
                if (!visit[upF]) {
                    visit[upF] = true;
                    Q.add(upF);
                    floor[upF] = floor[nowF] + 1;
                }

            }
            if (downF <= F && downF > 0) {
                if (!visit[downF]) {
                    visit[downF] = true;
                    Q.add(downF);
                    floor[downF] = floor[nowF] + 1;
                }
            }
        }

        if (floor[G] == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        } else {
            System.out.println(floor[G]);
        }
    }
}
