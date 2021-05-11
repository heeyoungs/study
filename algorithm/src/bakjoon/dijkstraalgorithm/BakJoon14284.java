package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 간선 이어가기 2
public class BakJoon14284 {

    static int N;
    static boolean[] visit;
    static int[] dist;
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
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        visit = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Point(b, c));
            list[b].add(new Point(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(dist[end]);
    }

    static void dijkstra(int start){
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(start,0));
        dist[start] = 0;
        while(!queue.isEmpty()){
            Point check = queue.poll();
            if (!visit[check.pt]){
                visit[check.pt] = true;
                for(Point nt : list[check.pt]){
                    if (dist[nt.pt] > dist[check.pt] + nt.weight){
                        dist[nt.pt] = dist[check.pt] + nt.weight;
                        queue.add(new Point(nt.pt,dist[nt.pt]));
                    }
                }
            }
        }
    }
}
