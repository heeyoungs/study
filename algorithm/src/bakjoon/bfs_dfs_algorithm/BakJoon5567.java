package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 결혼식
public class BakJoon5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        boolean[] visit = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        visit[1] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1,0));
        int count = -1;
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            if (check.count <= 2){
                count++;
            }
            for (int ck : list[check.pt]) {
                if (!visit[ck]) {
                    visit[ck] = true;
                    queue.add(new Point(ck,check.count + 1));
                }
            }
        }
        System.out.println(count);
    }

    static class Point {
        int pt;
        int count;

        Point(int pt, int count) {
            this.pt = pt;
            this.count = count;
        }
    }
}
