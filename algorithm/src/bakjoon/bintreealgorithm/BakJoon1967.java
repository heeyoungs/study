package bakjoon.bintreealgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BakJoon1967 {
    static int nodeCount;
    static ArrayList<PointWithWeight>[] list;
    static boolean[] visit;
    static int ans;
    static int node = 1;

    static class PointWithWeight {
        int point;
        int weight;

        PointWithWeight(int point, int weight) {
            this.point = point;
            this.weight = weight;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        list = new ArrayList[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < nodeCount - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int pointA = Integer.parseInt(st.nextToken());
            int pointB = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[pointA].add(new PointWithWeight(pointB, weight));
            list[pointB].add(new PointWithWeight(pointA, weight));
        } // 간선끼리 연결(가중치)
        visit = new boolean[nodeCount + 1];
        dfs(node, 0);

        Arrays.fill(visit,false);
        dfs(node,0);
        System.out.print(ans);
    }

    static void dfs(int start, int distance) { // dfs 재귀로 가중치 탐색
        visit[start] = true;
        if (distance > ans) {
            ans = distance;
            node = start;
        }
        for(PointWithWeight pt : list[start]) {
            if (!visit[pt.point]){
                dfs(pt.point, pt.weight + distance);
            }
        }
    }
}

// 메모리 초과!!
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class BakJoon1967 {
//    static int nodeCount;
//    static ArrayList<PointWithWeight>[] list;
//    static boolean[] visit;
//    static int[] distance;
//
//    static class PointWithWeight implements Comparable<PointWithWeight> {
//        int point;
//        int weight;
//
//        PointWithWeight(int point, int weight) {
//            this.point = point;
//            this.weight = weight;
//        }
//
//        @Override
//        public int compareTo(PointWithWeight o) {
//            return weight - o.weight;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        nodeCount = Integer.parseInt(st.nextToken()); // 노드의 개수
//        list = new ArrayList[nodeCount + 1];
//        for (int i = 1; i <= nodeCount; i++) {
//            list[i] = new ArrayList<>();
//        } // 간선 정보 저장 리스트
//        for (int i = 0; i < nodeCount - 1; i++) {
//            st = new StringTokenizer(br.readLine());
//            int pointA = Integer.parseInt(st.nextToken());
//            int pointB = Integer.parseInt(st.nextToken());
//            int weight = Integer.parseInt(st.nextToken());
//            list[pointA].add(new PointWithWeight(pointB, weight));
//            list[pointB].add(new PointWithWeight(pointA, weight));
//        } // 간선의 정보 연결 정보 및 가중치 설정
//        int max = 0; // 최대 거리?
//        for (int i = 1; i <= nodeCount; i++) {
//            // 부모 노드와의 연결만 있을 경우
//            if (list[i].size() == 1) {
//                // 다익스트라! + 최대 경로 찾기
//                dijkstra(i);
//                for (int j = 1; j <= nodeCount; j++) {
//                    if (distance[j] > max) {
//                        max = distance[j];
//                    }
//                }
//            }
//        } // 최대 거리 찾기
//        System.out.print(max);
//    }
//
//    static void dijkstra(int start) {
//        PriorityQueue<PointWithWeight> pq = new PriorityQueue<>();
//        visit = new boolean[nodeCount + 1];
//        distance = new int[nodeCount + 1];
//        Arrays.fill(distance, Integer.MAX_VALUE);
//        distance[start] = 0;
//        pq.add(new PointWithWeight(start, 0));
//        while (!pq.isEmpty()) {
//            PointWithWeight check = pq.poll();
//            if (!visit[check.point]) {
//                visit[check.point] = true;
//                for (PointWithWeight spot : list[check.point]) {
//                    if (distance[check.point] + spot.weight < distance[spot.point]) {
//                        distance[spot.point] = distance[check.point] + spot.weight;
//                        pq.add(new PointWithWeight(spot.point, distance[spot.point]));
//                    }
//                }
//            }
//        }
//    }
//}
