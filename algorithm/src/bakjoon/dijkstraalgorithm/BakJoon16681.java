package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 등산
public class BakJoon16681 {
    static int N, M, D, E;
    static long[] distByStart; // 체력 소모량
    static long[] distByEnd;
    static int[] height; // 위치별 높이
    static ArrayList<Point>[] list;

    static class Point implements Comparable<Point> {
        int point;
        long weight;

        Point(int point, long weight) {
            this.point = point;
            this.weight = weight;
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
        D = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        distByStart = new long[N + 1];
        distByEnd = new long[N + 1];
        Arrays.fill(distByStart, Long.MAX_VALUE);
        Arrays.fill(distByEnd, Long.MAX_VALUE);
        height = new int[N + 1];
        list = new ArrayList[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[a].add(new Point(b, weight));
            list[b].add(new Point(a, weight));
        }


        // 1번 지점에서 올라가는 경로
        dijkstraA();
        // N번 지점에서 올라가는 경로
        dijkstraB();

        long ans = Long.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (distByEnd[i] == Long.MAX_VALUE) continue;
            if (distByStart[i] == Long.MAX_VALUE) continue;
            ans = Math.max(ans, (long) height[i] * E - (distByStart[i] + distByEnd[i]) * D);
        }
        if (ans == Long.MIN_VALUE) System.out.println("Impossible");
        else System.out.println(ans);
    }

    static void dijkstraA() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(1, 0));
        distByStart[1] = 0;
        boolean[] visit = new boolean[N + 1];
        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (distByStart[now.point] < now.weight) continue;
            if (!visit[now.point]) {
                visit[now.point] = true;
                for (Point next : list[now.point]) {
                    if (height[next.point] > height[now.point]) {
                        if (distByStart[next.point] > distByStart[now.point] + next.weight) {
                            distByStart[next.point] = distByStart[now.point] + next.weight;
                            PQ.add(new Point(next.point, distByStart[next.point]));
                        }
                    }
                }
            }
        }
    }

    static void dijkstraB() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(N, 0));
        distByEnd[N] = 0;
        boolean[] visit = new boolean[N + 1];
        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (distByEnd[now.point] < now.weight) continue;
            if (!visit[now.point]) {
                visit[now.point] = true;
                for (Point next : list[now.point]) {
                    if (height[next.point] > height[now.point]) {
                        if (distByEnd[next.point] > distByEnd[now.point] + next.weight) {
                            distByEnd[next.point] = distByEnd[now.point] + next.weight;
                            PQ.add(new Point(next.point, distByEnd[next.point]));
                        }
                    }
                }
            }
        }
    }
}
