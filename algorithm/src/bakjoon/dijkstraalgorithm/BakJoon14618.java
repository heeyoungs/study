package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// 총깡 총깡
public class BakJoon14618 {
    static char[] House;
    static boolean[] visit;
    static int[] dist;
    static int N, M;
    static int myHouse;
    static int K;
    static ArrayList<Point>[] list;

    static class Point implements Comparable<Point> {
        int point;
        int weight;

        Point(int point, int weight) {
            this.point = point;
            this.weight = weight;
        }

        public int compareTo(Point o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        // 1 line
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2 line
        st = new StringTokenizer(br.readLine());
        myHouse = Integer.parseInt(st.nextToken());

        // 3 line
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        House = new char[N + 1];

        // 4 line
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            House[Integer.parseInt(st.nextToken())] = 'A';
        }

        // 5 line
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            House[Integer.parseInt(st.nextToken())] = 'B';
        }

        // 6 ~
        list = new ArrayList[N + 1];
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

        dijkstra();

        int ans = Integer.MAX_VALUE;
        char Color = 'C';
        for (int i = 1; i <= N; i++) {
            if (i == myHouse) continue;
            if (dist[i] == Integer.MAX_VALUE) continue;
            if (dist[i] < ans && (House[i] == 'A' || House[i] == 'B') ) {
                ans = dist[i];
                Color = House[i];
            }else if (dist[i] == ans){
                if (House[i] == 'A')
                    Color = 'A';
            }
        }

        if (Color == 'C') System.out.println(-1);
        else {
            System.out.println(Color);
            System.out.println(ans);
        }
    }

    static void dijkstra() {
        visit = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[myHouse] = 0;

        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(myHouse, 0));
        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (dist[now.point] < now.weight) continue;
            if (visit[now.point]) continue;
            visit[now.point] = true;
            for (Point next : list[now.point]) {
                if (dist[next.point] > dist[now.point] + next.weight) {
                    dist[next.point] = dist[now.point] + next.weight;
                    PQ.add(new Point(next.point, dist[next.point]));
                }
            }
        }
    }
}
