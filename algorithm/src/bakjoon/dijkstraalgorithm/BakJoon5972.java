package bakjoon.dijkstraalgorithm;

import java.util.*;
import java.io.*;

// 택배 배송
public class BakJoon5972 {
    static int N, M;
    static long[] dist;
    static boolean[] visit;
    static ArrayList<Point>[] list;

    static class Point implements Comparable<Point> {
        int pt;
        long weight;

        Point(int pt, long weight) {
            this.pt = pt;
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
        dist = new long[N + 1];
        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[a].add(new Point(b,weight));
            list[b].add(new Point(a,weight));
        }

        dijkstra();
        System.out.println(dist[N]);
    }

    static void dijkstra(){
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(1,0));
        while(!PQ.isEmpty()){
            Point now = PQ.poll();

            if (dist[now.pt] < now.weight) continue;
            if (visit[now.pt]) continue;
            visit[now.pt] = true;
            for(Point next : list[now.pt]){
                if (dist[next.pt] > dist[now.pt] + next.weight){
                    dist[next.pt] = dist[now.pt] + next.weight;
                    PQ.add(new Point(next.pt,dist[next.pt]));
                }
            }
        }
    }
}