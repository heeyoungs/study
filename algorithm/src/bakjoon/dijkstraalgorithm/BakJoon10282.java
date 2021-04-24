package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 해킹
public class BakJoon10282 {
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

    static ArrayList<Point>[] list;
    static int[] distance;
    static boolean[] visit;
    static int nodeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for (int test = 0; test < testCase; test++) {

            st = new StringTokenizer(br.readLine());
            nodeCount = Integer.parseInt(st.nextToken());
            int lineCount = Integer.parseInt(st.nextToken());
            int startPoint = Integer.parseInt(st.nextToken());
            distance = new int[nodeCount + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            visit = new boolean[nodeCount + 1];
            list = new ArrayList[nodeCount + 1];
            for (int i = 1; i <= nodeCount; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < lineCount; i++) {
                st = new StringTokenizer(br.readLine());
                int end = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list[start].add(new Point(end, weight));
            } // 간선 정보 저장

            dijkstra(startPoint);

            int saveCount = 0;
            int minTime = 0;
            for (int i = 1; i <= nodeCount; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    distance[i] = 0;
                    saveCount++;
                }
                if (distance[i] > minTime){
                    minTime = distance[i];
                }
            }
            sb.append(nodeCount-saveCount + " " + minTime + "\n");
        }
        System.out.print(sb);
    }

    static void dijkstra(int start) {
        distance[start] = 0;
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(start, 0));
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();
            if (!visit[check.point]) {
                visit[check.point] = true;
                for (Point pt : list[check.point]) {
                    if (distance[check.point] + pt.weight < distance[pt.point]) {
                        distance[pt.point] = distance[check.point] + pt.weight;
                        PQ.add(new Point(pt.point, distance[pt.point]));
                    }
                }
            }
        }
    }
}
