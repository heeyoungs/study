package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 개코 전쟁
public class BakJoon2325 {
    static int nodeCount;
    static ArrayList<Point>[] list;
    static int[] dist;
    static int[] parent;
    static boolean[] visit;
    static int maxDist = 0;

    static ArrayList<Point> line = new ArrayList<>();

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
        nodeCount = Integer.parseInt(st.nextToken());
        list = new ArrayList[nodeCount + 1];
        parent = new int[nodeCount + 1];
        Arrays.fill(parent, -1);
        for (int i = 1; i <= nodeCount; i++) {
            list[i] = new ArrayList<>();
        }
        int lineCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Point(end, weight));
            list[end].add(new Point(start, weight));
        }
        dijkstra1(); // 최단 경로 구하기

        // 경로를 하나씩 지워보기
        int deletePoint = nodeCount;
        while (parent[deletePoint] != -1) {
            dijkstra2(deletePoint);
            deletePoint = parent[deletePoint];
        }
        System.out.println(maxDist);
    }

    static void dijkstra2(int deletePoint) {
        dist = new int[nodeCount + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        visit = new boolean[nodeCount + 1];

        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(1, 0));
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();

            if (visit[check.point]) continue;
            visit[check.point] = true;
            for (Point next : list[check.point]) {
                if ((parent[deletePoint] == next.point) && (deletePoint == check.point)) continue;
                if ((deletePoint == next.point) && (parent[deletePoint] == check.point)) continue;
                if (dist[next.point] > dist[check.point] + next.weight) {
                    dist[next.point] = dist[check.point] + next.weight;
                    PQ.add(new Point(next.point, dist[next.point]));
                }
            }
        }
        maxDist = Math.max(maxDist, dist[nodeCount]);
    }

    static void dijkstra1() { // 최단 경로 구하기
        dist = new int[nodeCount + 1];
        visit = new boolean[nodeCount + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(1, 0));
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();

            if (visit[check.point]) continue;
            visit[check.point] = true;
            for (Point next : list[check.point]) {
                if (dist[next.point] > dist[check.point] + next.weight) {
                    dist[next.point] = dist[check.point] + next.weight;
                    parent[next.point] = check.point;
                    PQ.add(new Point(next.point, dist[next.point]));
                }
            }
        }
    }
}
