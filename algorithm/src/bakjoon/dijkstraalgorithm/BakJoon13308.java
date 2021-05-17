package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

// 주유소
public class BakJoon13308 {
    static int N, M;
    static int[] fill;
    static long[][] dist;
    static boolean[][] visit;
    static ArrayList<Point>[] list;

    static class Point implements Comparable<Point> {
        int point;
        long weight;
        int nowFillPoint;

        Point(int point, long weight, int nowFillMoney) {
            this.point = point;
            this.weight = weight;
            this.nowFillPoint = nowFillMoney;
        }

        @Override
        public int compareTo(Point o) {
            return (int) (weight - o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 수
        M = Integer.parseInt(st.nextToken()); // 간선의 수 -> 양방향


        fill = new int[N + 1]; // 지역별 기름 값
        dist = new long[N + 1][N + 1]; // 각 지역에 도달했을 때의 상황별 기름값 배열
        visit = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = Long.MAX_VALUE;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            fill[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[a].add(new Point(b, weight, -1));
            list[b].add(new Point(a, weight, -1));
        }

        dijkstra();

        long ans = Long.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            ans = Math.min(ans, dist[N][i]);
        }
        System.out.println(ans);
    }

    static void dijkstra() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(1, 0, 1));
        dist[1][1] = 0;
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();

            if (visit[check.point][check.nowFillPoint]) continue;
            visit[check.point][check.nowFillPoint] = true;

            for (Point next : list[check.point]) {
                // 기름 값을 지금 처음 지역으로 유지시키고 움직임
                if (fill[check.nowFillPoint] < fill[next.point]) {
                    if (dist[next.point][check.nowFillPoint] > dist[check.point][check.nowFillPoint] + next.weight * fill[check.nowFillPoint]) {
                        dist[next.point][check.nowFillPoint] = dist[check.point][check.nowFillPoint] + next.weight * fill[check.nowFillPoint];
                        PQ.add(new Point(next.point, dist[next.point][check.nowFillPoint], check.nowFillPoint));
                    }
                } else {
                    // 기름 값을 현재 지역으로 초기화시키고 움직임
                    if (dist[next.point][next.point] > dist[check.point][check.nowFillPoint] + next.weight * fill[check.nowFillPoint]) {
                        dist[next.point][next.point] = dist[check.point][check.nowFillPoint] + next.weight * fill[check.nowFillPoint];
                        PQ.add(new Point(next.point, dist[next.point][next.point], next.point));
                    }
                }
            }
        }
    }
}
