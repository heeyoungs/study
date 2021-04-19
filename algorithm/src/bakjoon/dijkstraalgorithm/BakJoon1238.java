package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BakJoon1238 {
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
    static boolean[] visit;
    static int[] distance;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N명 N개의 마을
        int M = Integer.parseInt(st.nextToken()); // M개의 라인 -> 단방향
        int X = Integer.parseInt(st.nextToken()); // X번 마을에서 파티
        list = new ArrayList[N + 1];
        int[] personDistance = new int[N + 1];
        personDistance[0] = 0;
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        } // 간선 정보를 담을 배열!

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Point(end, weight)); //
        } // 간선 정보 초기화

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
            personDistance[i] = distance[X];
        }
        dijkstra(X);
        for (int i = 1; i <= N; i++) {
            personDistance[i] += distance[i];
        }
        Arrays.sort(personDistance);
        System.out.println(personDistance[N]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        visit = new boolean[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new Point(start, 0));
        while (!pq.isEmpty()) {
            Point check = pq.poll();
            if (!visit[check.point]) {
                visit[check.point] = true;
                for (Point point : list[check.point]) {
                    if (distance[check.point] + point.weight < distance[point.point]) {
                        distance[point.point] = distance[check.point] + point.weight;
                        pq.add(new Point(point.point, distance[point.point]));
                    }
                }
            }

        }

    }
}
