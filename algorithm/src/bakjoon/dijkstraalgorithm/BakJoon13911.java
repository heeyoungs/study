package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.ArrayList;

// 집 구하기
public class BakJoon13911 {
    static int N, M;
    static int mac;
    static int star;
    static long[] macDist;
    static long[] starDist;
    static boolean[] isMacOrStar;
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

        macDist = new long[N + 1];
        starDist = new long[N + 1];
        isMacOrStar = new boolean[N + 1];
        Arrays.fill(macDist, Long.MAX_VALUE);
        Arrays.fill(starDist, Long.MAX_VALUE);
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[a].add(new Point(b, weight));
            list[b].add(new Point(a, weight));
        }

        // 멕세권
        st = new StringTokenizer(br.readLine());
        int macCount = Integer.parseInt(st.nextToken());
        mac = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        for (int i = 0; i < macCount; i++) {
            int point = Integer.parseInt(st.nextToken());
            isMacOrStar[point] = true;
            macDist[point] = 0;
            PQ.add(new Point(point, 0));
        }
        dijkstraMac(PQ);

        // 스세권
        st = new StringTokenizer(br.readLine());
        int starCount = Integer.parseInt(st.nextToken());
        star = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < starCount; i++) {
            int point = Integer.parseInt(st.nextToken());
            isMacOrStar[point] = true;
            starDist[point] = 0;
            PQ.add(new Point(point, 0));
        }
        dijkstraStar(PQ);

        long minDist = Long.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            if (isMacOrStar[i]) continue;
            if (macDist[i] > mac) continue;
            if (starDist[i] > star) continue;
            minDist = Math.min(minDist, macDist[i] + starDist[i]);
        }
        if (minDist == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(minDist);
    }

    static void dijkstraMac(PriorityQueue<Point> PQ) {
        boolean[] visit = new boolean[N + 1];
        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (now.weight > mac) continue;
            if (visit[now.point]) continue;
            visit[now.point] = true;
            for (Point next : list[now.point]) {
                if (macDist[next.point] > macDist[now.point] + next.weight) {
                    macDist[next.point] = macDist[now.point] + next.weight;
                    PQ.add(new Point(next.point, macDist[next.point]));
                }
            }
        }
    }

    static void dijkstraStar(PriorityQueue<Point> PQ) {
        boolean[] visit = new boolean[N + 1];
        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (now.weight > star) continue;
            if (visit[now.point]) continue;
            visit[now.point] = true;
            for (Point next : list[now.point]) {
                if (starDist[next.point] > starDist[now.point] + next.weight) {
                    starDist[next.point] = starDist[now.point] + next.weight;
                    PQ.add(new Point(next.point, starDist[next.point]));
                }
            }
        }
    }
}
