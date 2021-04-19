package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BakJoon9370 {
    static class Point implements Comparable<Point> {
        int point;
        int weight;

        Point(int point, int weight) {
            this.point = point;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) { // 거리가 작은 것을 기준으로 우선 순위 큐 형성
            return weight - o.weight;
        }
    }

    static ArrayList<Point>[] list;
    static boolean[] visit;
    static int[] distance;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for (int test = 0; test < testCase; test++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 정점의 개수
            int m = Integer.parseInt(st.nextToken()); // 간선의 개수
            int t = Integer.parseInt(st.nextToken()); // 목적지의 개수
            list = new ArrayList[n + 1]; // 간선의 정보를 저장할 연결 리스트 생성
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 예술가의 시작지점
            int g = Integer.parseInt(st.nextToken()); // g
            int h = Integer.parseInt(st.nextToken()); // h -> 이 둘 사이의 경로를 지나감
            for (int i = 0; i < m; i++) { // 간선끼리의 정보 저장
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list[first].add(new Point(second, weight));
                list[second].add(new Point(first, weight));
            }
            for (int i = 0; i < t; i++) { // 목적지에 대해 하나씩 검사해보기
                int p = Integer.parseInt(br.readLine()); // 목적지
                dijkstra(s);
                int direct = distance[p]; // 이 거리와 경유해서 가는 것이 값이 같은지 검사
                int peek1 = distance[g]; // s -> g -> h -> p
                int peek2 = distance[h]; // s -> h -> g -> p
                dijkstra(g);
                peek1 += distance[h];
                peek2 += distance[p];
                dijkstra(h);
                peek1 += distance[p];
                peek2 += distance[g];

               // System.out.println(direct + " " + peek1 + " " + peek2);
                if (direct == peek1 || direct == peek2){
                    heap.add(p);
                }
            }
            while(!heap.isEmpty()){
                sb.append(heap.poll() + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        visit = new boolean[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Point> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.add(new Point(start, 0));
        while (!pq.isEmpty()) {
            Point check = pq.poll();
            if (!visit[check.point]) {
                visit[check.point] = true;
                for (Point point : list[check.point]) {
                    if (distance[check.point] + point.weight < distance[point.point]) {
                        distance[point.point] = distance[check.point] + point.weight;
                        pq.add(new Point(point.point, distance[point.point]));
                    }
                }
            }
        }
    }
}
