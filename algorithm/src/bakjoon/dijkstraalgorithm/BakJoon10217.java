package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// KCM Travel -> 비용기준 탐색
public class BakJoon10217 {
    static ArrayList<Point>[] list;
    static boolean[] visit;
    static int[][] distance;
    static int N, M;

    static class Point implements Comparable<Point> {
        int point;
        int weight;
        int cost;

        Point(int point, int weight, int cost) {
            this.point = point;
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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // testCase
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 노드의 개수
            M = Integer.parseInt(st.nextToken()); // 총 지원비용
            int K = Integer.parseInt(st.nextToken()); // 티켓정보의 수
            list = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list[start].add(new Point(end, weight, cost));
            }
            visit = new boolean[N + 1];
            distance = new int[101][10001];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }
            distance[1][0] = 0;

            dijkstra();

            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= M; i++) {
                min = Math.min(distance[N][i], min);
                //System.out.println(distance[N][i]);
            }
            if (min == Integer.MAX_VALUE) {
                sb.append("Poor KCM").append("\n");
            } else {
                sb.append(min).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(1, 0, 0));
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();
            for (Point pt : list[check.point]) {

                if (pt.cost + check.cost > M) continue;
                if ( distance[pt.point][pt.cost + check.cost] > pt.weight + distance[check.point][check.cost]) {
                    distance[pt.point][pt.cost + check.cost] = pt.weight + distance[check.point][check.cost];
                    PQ.add(new Point(pt.point, pt.weight + distance[check.point][check.cost], pt.cost + check.cost));
                }
            }
        }
    }
}