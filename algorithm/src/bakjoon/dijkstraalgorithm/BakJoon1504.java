package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 특정한 최단 경로
public class BakJoon1504 {

    static boolean[] visit;
    static ArrayList<Point>[] list;
    static int[] distance;
    static int nodeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());
        list = new ArrayList[nodeCount + 1];
        for(int i=1;i<=nodeCount;i++){
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[first].add(new Point(second, weight));
            list[second].add(new Point(first, weight));
        }
        st = new StringTokenizer(br.readLine());
        int checkPoint1 = Integer.parseInt(st.nextToken()); // 정점1
        int checkPoint2 = Integer.parseInt(st.nextToken()); // 정점2
        long ans1 = 0; // 1-> c1 -> c2 -> n
        long ans2 = 0; // 1-> c2 -> c1 -> n

        dijkstra(1);
        ans1 += distance[checkPoint1];
        ans2 += distance[checkPoint2];

        dijkstra(checkPoint1);
        ans1 += distance[checkPoint2];
        ans2 += distance[nodeCount];

        dijkstra(checkPoint2);
        ans2 += distance[checkPoint1];
        ans1 += distance[nodeCount];

        if (ans1 >= Integer.MAX_VALUE || ans2 >= Integer.MAX_VALUE){
            System.out.println(-1);
        }else if (ans2>ans1){
            System.out.println(ans1);
        }else{
            System.out.println(ans2);
        }
    }

    static void dijkstra(int start) {
        // 거리 정보 초기화
        distance = new int[nodeCount + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // 방문 여부 초기화
        visit = new boolean[nodeCount + 1];
        PriorityQueue<Point> heap = new PriorityQueue<>();
        distance[start] = 0;
        heap.add(new Point(start,0));
        while(!heap.isEmpty()){
            Point check = heap.poll();
            if (!visit[check.start]){
                visit[check.start] = true;
                for(Point point :list[check.start]){
                    if (distance[check.start] + point.weight < distance[point.start]){
                        distance[point.start] = distance[check.start] + point.weight;
                        heap.add(new Point(point.start,distance[point.start]));
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

        @Override
        public int compareTo(Point o) {
            return weight - o.weight;
        }
    }
}
