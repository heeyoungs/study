package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// K번째 최단 경로 찾기
public class BakJoon1854 {
    static int N, M, K;
    static PriorityQueue<Integer>[] dist;
    static ArrayList<Point>[] list;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new PriorityQueue[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            dist[i] = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Point(end, weight));
        }
        dijkstra();

        for (int i = 1; i <= N; i++) {
            if (dist[i].size() < K) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i].poll());
            }
        }
    }

    static void dijkstra() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(1, 0));
        dist[1].add(0);
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            for (Point nt : list[check.point]) {
                if (dist[nt.point].size() < K) {
                    // 저장된 최단 비용의 수가 K개 이하일때
                    dist[nt.point].add(check.weight + nt.weight);
                    queue.add(new Point(nt.point, check.weight + nt.weight));
                } else if (dist[nt.point].size() == K && dist[nt.point].peek() > check.weight + nt.weight) {
                    // 저장된 최단 비용의 수가 K개 및 더 짧은 거리가 있을 때
                    dist[nt.point].poll();
                    dist[nt.point].add(check.weight + nt.weight);
                    queue.add(new Point(nt.point, check.weight + nt.weight));
                }
            }
        }
    }
}
