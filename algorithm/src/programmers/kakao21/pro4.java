package programmers.kakao21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class pro4 {
    public static void main(String[] args) {
        int n = 4;
        int start = 1;
        int end = 4;
        int[][] roads = {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
        int[] traps = {2, 3};
        System.out.println(solution(n, start, end, roads, traps));
    }

    static ArrayList<Point>[] list;
    static ArrayList<Point>[] listReverse;
    static int[] dist;

    static class Point implements Comparable<Point> {
        int point;
        int weight;
        boolean trapCheck;

        Point(int point, int weight, boolean trapCheck) {
            this.point = point;
            this.weight = weight;
            this.trapCheck = trapCheck;
        }

        @Override
        public int compareTo(Point o) {
            return weight - o.weight;
        }
    }

    static public int solution(int N, int start, int end, int[][] roads, int[] traps) {
        // N -> 방의 개수
        // start -> 시작 지점
        // end -> 종료 지점
        // roads -> 간선과 가중치
        // trap -> 변환 포인트
        list = new ArrayList[N + 1];
        listReverse = new ArrayList[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            listReverse[i] = new ArrayList<>();
        }
        for (int i = 0; i < roads.length; i++) {
            int startP = roads[i][0];
            int endP = roads[i][1];
            int weight = roads[i][2];
            //System.out.println(startP + " " + endP + " " + weight);
            // 끝지점의 트랩 방 구분해주기
            boolean trapEnd = false;
            boolean trapStart = false;

            for (int j = 0; j < traps.length; j++) {
                if (traps[j] == endP) { // 끝 지점에 함정이 있을 경우
                    // 시작 지점에도 함정이 있는가?
                    for(int k=0;k<traps.length;k++){
                        if (traps[k] == startP){
                            trapStart = true;
                        }
                    }
                    if (trapStart) {
                        list[startP].add(new Point(endP, weight, true));
                        listReverse[endP].add(new Point(startP, weight, false));
                    }else{
                        list[startP].add(new Point(endP, weight, true));
                        listReverse[endP].add(new Point(startP, weight, true));
                    }
                    trapEnd = true;
                }
            }
            if (!trapEnd) {
                list[startP].add(new Point(endP, weight, false));
                listReverse[startP].add(new Point(endP, weight, false));
            }
        }
        // 간선 이어주기 -> 방향 그래프
        dijkstra(start);
        return dist[end];
    }

    static void dijkstra(int start) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(start, 0, false));
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            System.out.println(check.point + " " + check.weight + "" + check.trapCheck);

            if (check.trapCheck) { // 함점이 발동된 경우
                for (Point nt : listReverse[check.point]) {
                    if (dist[nt.point] > dist[check.point] + nt.weight) {
                        dist[nt.point] = dist[check.point] + nt.weight;
                        if (nt.trapCheck) { // 함정을 또 밟음
                            queue.add(new Point(nt.point, dist[nt.point], false));
                        } else { // 안 밟음
                            queue.add(new Point(nt.point, dist[nt.point], true));
                        }
                    }
                }
            } else { // 함정이 발동되지 않은 경우
                for (Point nt : list[check.point]) {
                    if (dist[nt.point] > dist[check.point] + nt.weight) {
                        dist[nt.point] = dist[check.point] + nt.weight;
                        if (nt.trapCheck) { // 함정을 밟음
                            queue.add(new Point(nt.point, dist[nt.point], true));
                        } else { // 함정을 안 밟음
                            queue.add(new Point(nt.point, dist[nt.point], false));
                        }
                    }
                }
            }
        }
    }
}
