package bakjoon.bellmanfordalgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BakJoon1865 {
    static class Point {
        int point;
        int weight;

        Point(int point, int weight) {
            this.point = point;
            this.weight = weight;
        }
    }

    static ArrayList<Point>[] list;
    static int nodeCount;
    static long[] distance;
    static boolean cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for (int test = 0; test < testCase; test++) {
            cycle = false;
            // 각 테스트 케이스 입니다.!
            st = new StringTokenizer(br.readLine());
            nodeCount = Integer.parseInt(st.nextToken());
            int lineCount1 = Integer.parseInt(st.nextToken());
            int lineCount2 = Integer.parseInt(st.nextToken());
            list = new ArrayList[nodeCount + 1];
            for (int i = 1; i <= nodeCount; i++) {
                list[i] = new ArrayList<>();
            }
            // +가중치
            for (int i = 0; i < lineCount1; i++) {
                st = new StringTokenizer(br.readLine());
                int pointA = Integer.parseInt(st.nextToken());
                int pointB = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list[pointA].add(new Point(pointB, weight));
                list[pointB].add(new Point(pointA, weight));
            }
            // -가중치
            for (int i = 0; i < lineCount2; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list[start].add(new Point(end, (-1) * weight));
            }

            for (int i = 1; i <= nodeCount; i++) {
                if (cycle) {
                    break;
                }
                bellman_ford(i);
            }

            if (cycle) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    // 이부분 시간최소화!!-> 시간초과의 원인 ㅅㅂ;;
    static void bellman_ford(int start) {
        distance = new long[nodeCount + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        boolean check = false;
        for (int k = 0; k < nodeCount; k++) {
            check = false;
            for (int i = 1; i <= nodeCount; i++) {
                for (Point point : list[i]) {
                    if (distance[i] != Integer.MAX_VALUE && distance[point.point] > distance[i] + point.weight) {
                        distance[point.point] = distance[i] + point.weight;
                        check = true;
                    }
                }
            }
            if (!check){
                break;
            }
        }
        if (check){
            cycle = true;
        }
    }
}

//import java.io.*;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class BakJoon1865 { // 벨멘 포드로 cycle 이 존재하는지 확인하는 문제입니당~~
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int testCase = Integer.parseInt(st.nextToken());
//        for (int test = 0; test < testCase; test++) {
//            // 각 테스트 케이스 입니다.!
//            st = new StringTokenizer(br.readLine());
//            int nodeCount = Integer.parseInt(st.nextToken());
//            int lineCount1 = Integer.parseInt(st.nextToken());
//            int lineCount2 = Integer.parseInt(st.nextToken());
//
//            long[][] timeTable = new long[nodeCount + 1][nodeCount + 1];
//            for (int i = 1; i <= nodeCount; i++) {
//                Arrays.fill(timeTable[i], Integer.MAX_VALUE);
//            }
//
//            // +가중치
//            for (int i = 0; i < lineCount1; i++) {
//                st = new StringTokenizer(br.readLine());
//                int pointA = Integer.parseInt(st.nextToken());
//                int pointB = Integer.parseInt(st.nextToken());
//                int weight = Integer.parseInt(st.nextToken());
//                timeTable[pointA][pointB] = Math.min(weight, timeTable[pointA][pointB]);
//                timeTable[pointB][pointA] = Math.min(weight, timeTable[pointB][pointA]);
//            }
//            // -가중치
//            for (int i = 0; i < lineCount2; i++) {
//                st = new StringTokenizer(br.readLine());
//                int start = Integer.parseInt(st.nextToken());
//                int end = Integer.parseInt(st.nextToken());
//                int weight = Integer.parseInt(st.nextToken());
//                timeTable[start][end] = Math.min(-weight, timeTable[start][end]);
//            }
//
//            boolean cycle = false;
//            for (int node = 1; node <= nodeCount; node++) {
//                if (cycle) {
//                    break;
//                }
//                long[] result = new long[nodeCount + 1];
//                result[node] = 0;
//                for (int k = 0; k < nodeCount - 1; k++) { // N-1번
//                    for (int i = 1; i <= nodeCount; i++) { // 시작
//                        for (int j = 1; j <= nodeCount; j++) { // 도착
//                            if (result[i] != Integer.MAX_VALUE && timeTable[i][j] != Integer.MAX_VALUE) {
//                                if (result[j] > timeTable[i][j] + result[i]) {
//                                    result[j] = timeTable[i][j] + result[i];
//                                }
//                            }
//                        }
//                    }
//                }
//                for (int i = 1; i <= nodeCount; i++) { // 사이클 확인
//                    for (int j = 1; j <= nodeCount; j++) {
//                        if (timeTable[i][j] != Integer.MAX_VALUE && result[i] != Integer.MAX_VALUE) {
//                            if (result[j] > timeTable[i][j] + result[i]) {
//                                cycle = true;
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (cycle) {
//                bw.write("YES\n");
//            } else {
//                bw.write("NO\n");
//            }
//        }
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}
