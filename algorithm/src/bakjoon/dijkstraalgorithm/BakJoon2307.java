package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 도로검문
public class BakJoon2307 {
    static int N, M;
    static long[] dist;
    static int[] parent;
    static ArrayList<Point>[] list;

    static class Point implements Comparable<Point> {
        int pt;
        long weight;

        Point(int pt, long weight) {
            this.pt = pt;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return (int) (weight - o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[a].add(new Point(b, weight));
            list[b].add(new Point(a, weight));
        }
        parent = new int[N + 1];
        dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        dijkstra1();

        long notBlockDist = dist[N];
        long blockedMaxDist = 0;
        int start = N;
        while (start != 0) {
            // 최단 경로중 하나를 지우기
            dijkstra2(start, parent[start]);
            blockedMaxDist = Math.max(dist[N], blockedMaxDist);
            start = parent[start];
        }
        if (blockedMaxDist == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(blockedMaxDist - notBlockDist);
    }

    static void dijkstra1() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(1, 0));
        boolean[] visit = new boolean[N + 1];
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();

            if (dist[check.pt] < check.weight) continue;
            if (visit[check.pt]) continue;
            visit[check.pt] = true;
            for (Point next : list[check.pt]) {
                if (dist[next.pt] > dist[check.pt] + next.weight) {
                    dist[next.pt] = dist[check.pt] + next.weight;
                    PQ.add(new Point(next.pt, dist[next.pt]));
                    parent[next.pt] = check.pt;
                }
            }
        }
    }

    static void dijkstra2(int a, int b) {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(1, 0));
        boolean[] visit = new boolean[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();

            if (dist[check.pt] < check.weight) continue;
            if (visit[check.pt]) continue;
            visit[check.pt] = true;
            for (Point next : list[check.pt]) {
                if (check.pt == a && next.pt == b) continue;
                if (check.pt == b && next.pt == a) continue;
                if (dist[next.pt] > dist[check.pt] + next.weight) {
                    dist[next.pt] = dist[check.pt] + next.weight;
                    PQ.add(new Point(next.pt, dist[next.pt]));
                }
            }
        }
    }
}
