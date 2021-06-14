package bakjoon.dijkstraalgorithm;

import java.util.*;
import java.io.*;

// 좀비
public class BakJoon11952 {
    static int N, M, K, S;
    static boolean[] isDestroy;
    static boolean[] unSafe;
    static long[] cost;
    static ArrayList<Integer>[] list;
    static int safeSleep, unSafeSleep;
    static Queue<Point> Q = new LinkedList<>();

    static class Point implements Comparable<Point>{
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
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        // 1
        st = new StringTokenizer(br.readLine());
        safeSleep = Integer.parseInt(st.nextToken());
        unSafeSleep = Integer.parseInt(st.nextToken());
        // 2
        unSafe = new boolean[N + 1];
        isDestroy = new boolean[N + 1];
        for (int i = 0; i < K; i++) {
            int destroy = Integer.parseInt(br.readLine());
            Q.add(new Point(destroy, 0));
            isDestroy[destroy] = true;
            unSafe[destroy] = true;
        }
        // 3
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        // 4

        // solve
        // 1 불안전 도시 체크
        bfs();
        // 2 최소 비용 구하기
        cost = new long[N + 1];
        Arrays.fill(cost,Long.MAX_VALUE);
        dijkstra();
        // 3 마지막 지점 숙박비 빼기
        long ans = cost[N];
        if (isDestroy[N]){
            System.out.println(ans - unSafeSleep);
        }else{
            System.out.println(ans - safeSleep);
        }
    }

    static void dijkstra(){
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(1,0));
        cost[1] = 0;
        boolean[] visit = new boolean[N + 1];
        while(!PQ.isEmpty()){
            Point now = PQ.poll();

            if (cost[now.pt] < now.weight) continue;
            if (visit[now.pt]) continue;
            visit[now.pt] = true;
            for(int next : list[now.pt]){
                if (unSafe[next]) continue;
                if (isDestroy[next]){
                    if (cost[next] > cost[now.pt] + unSafeSleep){
                        cost[next] = cost[now.pt] + unSafeSleep;
                        PQ.add(new Point(next,cost[next]));
                    }
                }else{
                    if (cost[next] > cost[now.pt] + safeSleep){
                        cost[next] = cost[now.pt] + safeSleep;
                        PQ.add(new Point(next,cost[next]));
                    }
                }
            }
        }
    }

    static void bfs() {
        while (!Q.isEmpty()) {
            Point now = Q.poll();

            if (now.weight + 1 > S) continue;
            for (int next : list[now.pt]) {
                if (!isDestroy[next]) {
                    isDestroy[next] = true;
                    Q.add(new Point(next, now.weight + 1));
                }
            }
        }
    }
}
