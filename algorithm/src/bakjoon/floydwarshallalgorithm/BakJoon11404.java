package bakjoon.floydwarshallalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BakJoon11404 { // 플루이드 와샬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int nodeCount = Integer.parseInt(br.readLine());
        int lineCount = Integer.parseInt(br.readLine());
        int[][] distance = new int[nodeCount + 1][nodeCount + 1];
        for (int h = 1; h <= nodeCount; h++) {
            for (int w = 1; w <= nodeCount; w++) {
                if (w == h) {
                    distance[w][h] = 0;
                } else {
                    distance[w][h] = Integer.MAX_VALUE;
                }
            }
        } // 초기화

        for (int i = 0; i < lineCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            distance[start][end] = Math.min(weight,distance[start][end]);
        } // 간선 정보 입력

        // 경유지
        for (int k = 1; k <= nodeCount; k++) {
            // 출발지
            for (int i = 1; i <= nodeCount; i++) {
                if (i == k) continue;
                // 도착지
                for (int j = 1; j <= nodeCount; j++) {
                    if (i == j || j == k) continue;
                    if (distance[i][j] > distance[i][k] + distance[k][j] && distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                if (distance[i][j] == Integer.MAX_VALUE || i == j) {
                    distance[i][j] = 0;
                }
                sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;

//public class BakJoon11404 { // 다익스트라로 풀어보기
//    static int N;
//    static boolean[] visit;
//    static int[][] distance;
//    static ArrayList<Point>[] list;
//
//    static class Point implements Comparable<Point> {
//        int point;
//        int weight;
//
//        Point(int point, int weight) {
//            this.point = point;
//            this.weight = weight;
//        }
//
//        @Override
//        public int compareTo(Point o) {
//            return weight - o.weight;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        N = Integer.parseInt(br.readLine());
//        int M = Integer.parseInt(br.readLine());
//        list = new ArrayList[N + 1];
//        distance = new int[N + 1][N + 1];
//
//        for (int i = 1; i <= N; i++) {
//            Arrays.fill(distance[i], Integer.MAX_VALUE);
//        }
//
//        for (int i = 1; i <= N; i++) {
//            list[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//            int weight = Integer.parseInt(st.nextToken());
//            list[start].add(new Point(end, weight));
//        } // 간선 정보를 담아준다.
//
//        for (int i = 1; i <= N; i++) {
//            dijkstra(i, i);
//        }
//
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                if (distance[j][i] == Integer.MAX_VALUE) { // 갈 수 없는 경우!!
//                    distance[j][i] = 0;
//                }
//                System.out.print(distance[j][i] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    static void dijkstra(int start, int depth) {
//        PriorityQueue<Point> pq = new PriorityQueue<>();
//        distance[start][depth] = 0;
//        visit = new boolean[N + 1];
//        pq.add(new Point(start, 0));
//        while (!pq.isEmpty()) {
//            Point check = pq.poll();
//            if (!visit[check.point]) {
//                visit[check.point] = true;
//                for (Point point : list[check.point]) {
//                    if (distance[check.point][depth] + point.weight < distance[point.point][depth]) {
//                        distance[point.point][depth] = distance[check.point][depth] + point.weight;
//                        pq.add(new Point(point.point, distance[point.point][depth]));
//                    }
//                }
//            }
//        }
//    }
//}
