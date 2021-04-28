package bakjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 세금 -> 시간 초과
public class BakJoon13907 {
    static class Point implements Comparable<Point> {
        int point;
        int weight;

        Point(int point, int weight) {
            this.point = point;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return weight - o.weight;
        }
    }

    static ArrayList<Point>[] list;
    static int[] distance;
    static boolean[] visit;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 1-line
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수 -> 양방향!
        int K = Integer.parseInt(st.nextToken()); // 세금 인상 횟수
        // 2-line
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 시작 지점
        int D = Integer.parseInt(st.nextToken()); // 도착 지점
        // ~M line - 각 도로간의 간선 정보
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pointA = Integer.parseInt(st.nextToken());
            int pointB = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[pointA].add(new Point(pointB, weight));
            list[pointB].add(new Point(pointA, weight));
        }
        dijkstra(S);
        sb.append(distance[D]).append("\n");
        // last - 인상되는 세금의 값
        for (int i = 0; i < K; i++) {
            int upMoney = Integer.parseInt(br.readLine());
            for (int k = 1; k <= N; k++) {
                for (int j = 0; j < list[k].size(); j++) {
                    list[k].get(j).weight += upMoney;
                }
            }
            dijkstra(S);
            sb.append(distance[D]).append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        distance = new int[N + 1];
        visit = new boolean[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(start, 0));
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();

            if (!visit[check.point]) {
                visit[check.point] = true;
                for (Point pt : list[check.point]) {
                    if (distance[pt.point] > distance[check.point] + pt.weight) {
                        distance[pt.point] = distance[check.point] + pt.weight;
                        PQ.add(new Point(pt.point, distance[pt.point]));
                    }
                }
            }
        }
    }
}