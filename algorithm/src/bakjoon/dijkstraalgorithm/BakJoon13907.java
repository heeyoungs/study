package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.*;

// 세금
public class BakJoon13907 {
    static int N, M, K;
    static int startCity, endCity;
    static int[][] dist;
    static ArrayList<Point>[] list;

    static class Point{
        int pt;
        int weight;
        int count;

        Point(int endPt, int weight, int count) {
            this.pt = endPt;
            this.weight = weight;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken()); // 도시의 수
        M = Integer.parseInt(st.nextToken()); // 간선의 수
        K = Integer.parseInt(st.nextToken()); // 인상되는 세금의 횟수
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        st = new StringTokenizer(br.readLine());
        startCity = Integer.parseInt(st.nextToken()); // 시작 도시
        endCity = Integer.parseInt(st.nextToken()); // 도착 도시
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[a].add(new Point(b, weight, 0));
            list[b].add(new Point(a, weight, 0));
        }
        bfs();

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            if(dist[endCity][i] == Integer.MAX_VALUE) continue;
            min = Math.min(min,dist[endCity][i]);
        }
        sb.append(min).append("\n");

        for(int i=0;i<K;i++){
            min = Integer.MAX_VALUE;
            int upMoney = Integer.parseInt(br.readLine());
            for(int j=1;j<=N;j++){
                if (dist[endCity][j] == Integer.MAX_VALUE) continue;
                dist[endCity][j] += upMoney * j;
                min = Math.min(min,dist[endCity][j]);
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startCity, 0, 0));
        dist[startCity][0] = 0;
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            if (dist[check.pt][check.count] < check.weight) continue;
            for (Point next : list[check.pt]) {
                if (check.count + 1 > N) continue;
                if ( dist[next.pt][check.count + 1] > check.weight + next.weight){
                    dist[next.pt][check.count + 1] = check.weight + next.weight;
                    queue.add(new Point(next.pt,dist[next.pt][check.count + 1],check.count + 1));
                }
            }
        }
    }
}
