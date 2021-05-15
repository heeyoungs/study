package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 제국
public class BakJoon10776 {
    static int K, N, M;
    static int startPoint, endPoint;
    static int[][] dist;
    static ArrayList<Point>[] list;
    static int ans = Integer.MAX_VALUE;

    static class Point implements Comparable<Point> {
        int pt;
        int weight;
        int cost;

        Point(int pt, int weight, int cost) {
            this.pt = pt;
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken()); // 비용
        N = Integer.parseInt(st.nextToken()); // 섬의 개수
        M = Integer.parseInt(st.nextToken()); // 간선

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[N + 1][K]; // 섬의 갯수 + 비용 -> 시간값 저장
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < K; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken()); // 시간
            int cost = Integer.parseInt(st.nextToken()); // 비용
            list[A].add(new Point(B, weight, cost));
            list[B].add(new Point(A, weight, cost));
        }

        st = new StringTokenizer(br.readLine());
        startPoint = Integer.parseInt(st.nextToken());
        endPoint = Integer.parseInt(st.nextToken());

        dijkstra();
        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    static void dijkstra() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        dist[startPoint][0] = 0;
        PQ.add(new Point(startPoint, 0, 0));
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();
            if (check.pt == endPoint){
                ans = Math.min(ans,dist[endPoint][check.cost]);
            }
            if (check.cost > ans) continue;

            for (Point next : list[check.pt]) {
                if (next.cost + check.cost >= K) continue;
                if (dist[next.pt][next.cost + check.cost] > dist[check.pt][check.cost] + next.weight) {
                    dist[next.pt][next.cost + check.cost] = dist[check.pt][check.cost] + next.weight;
                    PQ.add(new Point(next.pt, dist[next.pt][next.cost + check.cost], next.cost + check.cost));
                }
            }
        }
    }
}
