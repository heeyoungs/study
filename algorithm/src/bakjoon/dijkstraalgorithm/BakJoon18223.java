package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 민준이와 마산 그리고 건우
public class BakJoon18223 {
    static int N, M, P;
    static int[] dist;
    static boolean[] visit;
    static boolean ck;
    static ArrayList<Point>[] list;

    static class Point implements Comparable<Point> {
        int pt;
        int weight;

        Point(int pt, int weight) {
            this.pt = pt;
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
        P = Integer.parseInt(st.nextToken());
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

        dijkstra(1);
        int goToGunWoo = dist[P];
        int maSan = dist[N];
        dijkstra(P);
        int gunWooToMaSan = dist[N];
        //System.out.println(goToGunWoo + " " + maSan + " " + gunWooToMaSan);
        if (maSan == goToGunWoo + gunWooToMaSan) ck = true;
        if (ck) System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");
    }

    static void dijkstra(int start){
        visit = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(start,0));
        while(!PQ.isEmpty()){
            Point check = PQ.poll();

            if (visit[check.pt]) continue;
            visit[check.pt] = true;
            for(Point next:list[check.pt]){
                if (dist[next.pt] >= dist[check.pt] + next.weight){
                    dist[next.pt] = dist[check.pt] + next.weight;
                    PQ.add(new Point(next.pt,dist[next.pt]));
                }
            }
        }
    }
}
