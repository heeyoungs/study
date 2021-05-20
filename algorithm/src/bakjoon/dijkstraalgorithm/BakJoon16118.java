package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.*;

// 달빛 여우
public class BakJoon16118 {
    static int N, M;
    static long[] fox;
    static long[][] wolves;
    static ArrayList<Point>[] list;

    static class Point implements Comparable<Point>{
        int point;
        long weight;
        boolean run;

        Point(int point, long weight) {
            this.point = point;
            this.weight = weight;
        }

        Point(int point, long weight, boolean run) {
            this.point = point;
            this.weight = weight;
            this.run = run;
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
        fox = new long[N + 1];
        wolves = new long[N + 1][2];
        for(int i=2;i<=N;i++){
            fox[i] = wolves[i][0] = wolves[i][1] = Long.MAX_VALUE;
        }
        wolves[1][1] = Long.MAX_VALUE;
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[a].add(new Point(b, weight * 2));
            list[b].add(new Point(a, weight * 2));
        }

        dijkstra1();
        dijkstra2();
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (fox[i] < wolves[i][0] && fox[i] < wolves[i][1]) count++;
        }
        System.out.println(count);
    }

    static void dijkstra1() {
        boolean[] visit = new boolean[N + 1];
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(1, 0));
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            if(fox[check.point] < check.weight) continue;
            if (!visit[check.point]) {
                visit[check.point] = true;
                for (Point next : list[check.point]) {
                    if (fox[next.point] > fox[check.point] + next.weight) {
                        fox[next.point] = fox[check.point] + next.weight;
                        queue.add(new Point(next.point, fox[next.point]));
                    }
                }
            }
        }
    }

    static void dijkstra2() {
        boolean[][] visit = new boolean[N + 1][2];
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(1, 0, true));
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            if (check.run) {
                if (wolves[check.point][0] < check.weight) continue;
                if (visit[check.point][1]) continue;
                visit[check.point][1] = true;
                for (Point next : list[check.point]) {
                    if (wolves[next.point][1] > wolves[check.point][0] + next.weight / 2) {
                        wolves[next.point][1] = wolves[check.point][0] + next.weight / 2;
                        queue.add(new Point(next.point, wolves[next.point][1], false));
                    }
                }
            } else {
                if (wolves[check.point][1] < check.weight) continue;
                if (visit[check.point][0]) continue;
                visit[check.point][0] = true;
                for (Point next : list[check.point]) {
                    if (wolves[next.point][0] > wolves[check.point][1] + next.weight * 2) {
                        wolves[next.point][0] = wolves[check.point][1] + next.weight * 2;
                        queue.add(new Point(next.point, wolves[next.point][0], true));
                    }
                }
            }
        }
    }
}
