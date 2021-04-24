package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.*;
// 최단 경로
public class BakJoon1753 {
    static int pointCount;
    static int lineCount;
    static int startPoint;

    static ArrayList<Point>[] list;
    static int[] distance;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        pointCount = Integer.parseInt(st.nextToken()); // 노드 개수
        lineCount = Integer.parseInt(st.nextToken()); // 간선 개수
        startPoint = Integer.parseInt(br.readLine()); // 거리를 재기위한 시작점
        // 간선 정보를 담을 배열을 초기화
        list = new ArrayList[pointCount + 1];
        for (int i = 1; i <= pointCount; i++) {
            list[i] = new ArrayList<>();
        }
        // 각 노드별 거리 정보를 담을 배열 초기화
        distance = new int[pointCount + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // 간선 정보를 배열에 담아줌
        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Point(end, weight));
        }
        // 다익스트라
        dijkstra(startPoint);
        // 출력
        for (int i = 1; i <= pointCount; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(distance[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<Point> heap = new PriorityQueue<>();
        // 방문 체크를 위한 배열
        visit = new boolean[pointCount + 1];
        // 시작 지점 -> 가중치 0
        heap.add(new Point(start, 0));
        // 시작 지점부터 시작 지점까지의 거리는 0
        distance[start] = 0;

        while (!heap.isEmpty()) {
            Point check = heap.poll();
            if (!visit[check.start]) {
                visit[check.start] = true;
                for (Point point : list[check.start]) {
                    // 최단거리 갱신
                    if (distance[check.start] + point.weight < distance[point.start]) { //
                        distance[point.start] = distance[check.start] + point.weight;
                        heap.add(new Point(point.start, distance[point.start]));
                    }
                }
            }
        }
    }


    static class Point implements Comparable<Point> {
        int start;
        int weight;

        Point(int start, int weight) {
            this.start = start;
            this.weight = weight;
        }

        // 거리가 짧은 순으로 우선 순위 큐에서 정렬됨 -> 최소 힙 생성
        @Override
        public int compareTo(Point o) {
            return weight - o.weight;
        }
    }
}
