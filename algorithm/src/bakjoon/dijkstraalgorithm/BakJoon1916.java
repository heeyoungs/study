package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BakJoon1916 {
    public static void main(String[] args) throws IOException {
        class Point implements Comparable<Point> {
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
        PriorityQueue<Point> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int nodeCount = Integer.parseInt(br.readLine());
        int lineCount = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[nodeCount + 1];
        int[] distance = new int[nodeCount + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        ArrayList<Point>[] list = new ArrayList[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            list[i] = new ArrayList<>();
        }
        for (int line = 0; line < lineCount; line++) {
            st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[startPoint].add(new Point(endPoint, weight));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        distance[start] = 0;
        pq.add(new Point(start,0));
        while(!pq.isEmpty()){
            Point check = pq.poll();
            if(!visit[check.point]){
                visit[check.point] = true;
                for(Point point : list[check.point]){
                    if (distance[check.point] + point.weight < distance[point.point]){
                        distance[point.point] = distance[check.point] + point.weight;
                        pq.add(new Point(point.point,distance[point.point]));
                    }
                }
            }
        }
        System.out.println(distance[end]);
    }
}
