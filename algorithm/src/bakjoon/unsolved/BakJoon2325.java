package bakjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 개코 전쟁 -> 시간 초과
public class BakJoon2325 {
    static int[] distance;
    static boolean[] visit;
    static ArrayList<Point>[] list;
    static int N;
    static int max = 0;

    static class Point implements Comparable<Point> {
        int point;
        int weight;
        int lineNum;

        Point(int point, int weight,int lineNum) {
            this.point = point;
            this.weight = weight;
            this.lineNum = lineNum;
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
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pointA = Integer.parseInt(st.nextToken());
            int pointB = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[pointA].add(new Point(pointB, weight,i));
            list[pointB].add(new Point(pointA, weight,i));
        }
        for (int i = 0; i < M; i++) {
            dijkstra(i);
        }
        System.out.println(max);
    }

    static void dijkstra(int i) {
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        visit = new boolean[N + 1];

        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(1, 0,-1));
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();

            if (!visit[check.point]) {
                visit[check.point] = true;
                for (Point pt : list[check.point]) {
                    if (pt.lineNum == i) continue;
                    if (distance[pt.point] > distance[check.point] + pt.weight) {
                        distance[pt.point] = distance[check.point] + pt.weight;
                        PQ.add(new Point(pt.point, distance[pt.point], check.lineNum));
                    }
                }
            }
        }
        max = Math.max(distance[N], max);
    }
}
