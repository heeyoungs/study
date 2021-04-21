package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BakJoon11779 {
    static int nodeCount;
    static boolean[] visit;
    static ArrayList<Point>[] list;
    static int[] distance;
    static int endPoint;
    static int road[];
    static StringBuilder sb = new StringBuilder();

    static class Point implements Comparable<Point> {
        int point;
        int weight;

        Point(int point, int weight) {
            this.point = point;
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
        nodeCount = Integer.parseInt(st.nextToken()); // 노드의 개수
        distance = new int[nodeCount + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        visit = new boolean[nodeCount + 1];
        list = new ArrayList[nodeCount + 1];
        road = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        int lineCount = Integer.parseInt(st.nextToken()); // 간선의 개수
        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Point(end, weight));
        } // 간선 정보 입력
        st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken()); // 시작 지점
        endPoint = Integer.parseInt(st.nextToken()); // 도착 지점
        dijkstra(startPoint);
        System.out.println(distance[endPoint]);
        // 경로 되추적!!
        Stack<Integer> stack = new Stack<>();
        while(endPoint != startPoint){
            stack.push(endPoint);
            endPoint = road[endPoint];
        }
        System.out.println(stack.size() + 1);
        System.out.print(startPoint + " ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }

    static void dijkstra(int start) {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        distance[start] = 0;
        PQ.add(new Point(start, 0));
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();

            if (!visit[check.point]) {
                visit[check.point] = true;
                for (Point point : list[check.point]) {
                    if (distance[check.point] + point.weight < distance[point.point]) {
                        distance[point.point] = distance[check.point] + point.weight;
                        PQ.add(new Point(point.point, distance[point.point]));
                        road[point.point] = check.point;
                    }
                }
            }
        }
    }
}
