package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BakJoon17396 {
    static boolean[] visit;
    static long[] distance;
    static ArrayList<Point>[] list;

    static class Point implements Comparable<Point> {
        int point;
        long weight;

        Point(int point, long weight) {
            this.point = point;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return (int)(weight - o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken()); // 정점의 개수
        int lineCount = Integer.parseInt(st.nextToken()); // 간선의 개수

        st = new StringTokenizer(br.readLine());
        boolean[] isNoWard = new boolean[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            int check = Integer.parseInt(st.nextToken());
            if (check == 1) {
                isNoWard[i] = false; // 와드 있음
            } else if (check == 0) {
                isNoWard[i] = true; // 와드 없음
            }
        } // 와드 위치 확인
        isNoWard[nodeCount - 1] = true;

        list = new ArrayList[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int pointA = Integer.parseInt(st.nextToken());
            int pointB = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (isNoWard[pointB]) { // (도착지에 와드가 없는 경우 + 도착지가 넥서스) 경로 정보를 추가해준다.
                list[pointA].add(new Point(pointB, weight));
            }
            if (isNoWard[pointA]) {
                list[pointB].add(new Point(pointA, weight));
            }
        } // 경로 설정

        visit = new boolean[nodeCount];
        distance = new long[nodeCount];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;
        dijkstra();
        for (int i = 0; i < nodeCount; i++) {
            if (distance[i] == Long.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        System.out.print(distance[nodeCount - 1]);
    }

    static void dijkstra() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(0, 0));
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();
            if (!visit[check.point]) {
                visit[check.point] = true;
                for (Point pt : list[check.point]) {
                    if (distance[pt.point] > distance[check.point] + pt.weight) {
                        distance[pt.point] = distance[check.point] + pt.weight;
                        PQ.add(new Point(pt.point, distance[pt.point]));
                    }
                }
            }
        }
    }
}
