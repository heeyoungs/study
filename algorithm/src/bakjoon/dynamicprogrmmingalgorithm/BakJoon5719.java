package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 거의 최단경로
public class BakJoon5719 {
    static int N, M, start, end;
    static ArrayList<Point>[] list;
    static ArrayList<Point>[] listReverse;
    static int[] dist;
    static boolean[] visit;

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

        @Override
        public boolean equals(Object obj){
            return (((Point) obj).point == point) && (((Point)obj).weight == weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 정점의 개수
            M = Integer.parseInt(st.nextToken()); // 간선의 개수
            list = new ArrayList[N];
            listReverse = new ArrayList[N];
            if (N == 0 && M == 0) break;
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
                listReverse[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken()); // 시작 지점
            end = Integer.parseInt(st.nextToken()); // 종료 지점
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list[a].add(new Point(b, weight));
                listReverse[b].add(new Point(a, weight));
            }
            dijkstra();
            reverse();
            dijkstra();
            int ans = dist[end];
            if (ans == Integer.MAX_VALUE) ans = -1;
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void reverse() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(end);
        visit = new boolean[N];
        while (!queue.isEmpty()) {
            int check = queue.poll();
            if (visit[check]) continue;
            visit[check] = true;

            for (Point next : listReverse[check]) {
                if (dist[check] - dist[next.point] == next.weight) {
                    queue.add(next.point);
                    list[next.point].remove(new Point(check, next.weight));
                }
            }
        }
    }

    static void dijkstra() {
        dist = new int[N];
        visit = new boolean[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(start, 0));
        dist[start] = 0;
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            if (!visit[check.point]) {
                visit[check.point] = true;

                for (Point next : list[check.point]) {
                    if (dist[next.point] > dist[check.point] + next.weight) {
                        dist[next.point] = dist[check.point] + next.weight;
                        queue.add(new Point(next.point, dist[next.point]));
                    }
                }
            }
        }
    }
}
/*
최단 경로를 찾아서 지우고
다시 다익스트라?
 */