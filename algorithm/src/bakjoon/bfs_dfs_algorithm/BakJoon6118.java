package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 숨바꼭질
public class BakJoon6118 {
    static int N;
    static int maxDist = 0;
    static ArrayList<Integer>[] list;
    static PriorityQueue<Integer> PQ = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        bfs1();
        bfs2();

        System.out.println(PQ.peek() + " " + maxDist + " " + PQ.size());
    }

    static void bfs1() { // 거리 구하기
        Queue<Point> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        visit[1] = true;
        queue.add(new Point(1, 0));
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            maxDist = Math.max(check.count, maxDist);
            for (int next : list[check.point]) {
                if (visit[next]) continue;
                visit[next] = true;
                queue.add(new Point(next, check.count + 1));
            }
        }
    }

    static void bfs2() { // 거리 구하기
        Queue<Point> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        visit[1] = true;
        queue.add(new Point(1, 0));
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            if (check.count == maxDist){
               PQ.add(check.point);
            }

            for (int next : list[check.point]) {
                if (visit[next]) continue;
                visit[next] = true;
                queue.add(new Point(next, check.count + 1));
            }
        }
    }

    static class Point {
        int point;
        int count;

        Point(int point, int count) {
            this.point = point;
            this.count = count;
        }
    }
}
