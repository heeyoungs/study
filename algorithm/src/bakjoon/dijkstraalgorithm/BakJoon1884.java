package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

// 고속도로
public class BakJoon1884 {
    static int K, N, R;
    static long[][] dist;
    static ArrayList<Point>[] list;

    static class Point implements Comparable<Point> {
        int point;
        long weight;
        int cost;

        Point(int point, long weight, int cost) {
            this.point = point;
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return (int) (weight - o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());

        dist = new long[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dist[i][j] = Long.MAX_VALUE;
            }
        }
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        dist[1][0] = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Point(end, weight, cost));
        }

        dijkstra();

        long ans = Long.MAX_VALUE;
        for(int i=0;i<=K;i++){
            ans = Math.min(ans,dist[N][i]);
        }
        if (ans == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);

    }

    static void dijkstra() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(1, 0, 0));
        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            for (Point next : list[now.point]) {
                if (now.cost + next.cost > K) continue;
                if (dist[next.point][now.cost + next.cost] > dist[now.point][now.cost] + next.weight) {
                    dist[next.point][now.cost + next.cost] = dist[now.point][now.cost] + next.weight;
                    PQ.add(new Point(next.point, dist[next.point][now.cost + next.cost], now.cost + next.cost));
                }
            }
        }
    }

}
