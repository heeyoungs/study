package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

// 도로포장
public class BakJoon1162 {
    static int N, M, K;
    static long[][] dist;
    static boolean[][] visit;
    static ArrayList<Point>[] list;

    static class Point implements Comparable<Point> {
        int point;
        long weight;
        int kCount;

        Point(int point, long weight,int kCount) {
            this.point = point;
            this.weight = weight;
            this.kCount = kCount;
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
        K = Integer.parseInt(st.nextToken());

        dist = new long[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dist[i][j] = Long.MAX_VALUE;
            }
        }

        visit = new boolean[N + 1][K + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[a].add(new Point(b, weight,-1));
            list[b].add(new Point(a, weight,-1));
        }

        dijkstra();

        long ans = Long.MAX_VALUE;
        for(int i=0;i<=K;i++){
            ans = Math.min(ans,dist[N][i]);
        }
        System.out.println(ans);
    }

    static void dijkstra() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(1, 0,0));
        dist[1][0] = 0;
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();
            if (visit[check.point][check.kCount]) continue;
            visit[check.point][check.kCount] = true;

            for (Point next : list[check.point]) {
                // 포장안하고 거칠때
                if (dist[next.point][check.kCount] > dist[check.point][check.kCount] + next.weight) {
                    dist[next.point][check.kCount] = dist[check.point][check.kCount] + next.weight;
                    PQ.add(new Point(next.point, dist[next.point][check.kCount],check.kCount));
                }

                // 포장하고 갈때
                if (check.kCount + 1 > K) continue;
                if (dist[next.point][check.kCount + 1] > dist[check.point][check.kCount]){
                    dist[next.point][check.kCount + 1] = dist[check.point][check.kCount];
                    PQ.add(new Point(next.point,dist[next.point][check.kCount + 1],check.kCount + 1));
                }
            }
        }
    }
}
