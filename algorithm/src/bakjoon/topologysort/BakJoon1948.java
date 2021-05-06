package bakjoon.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 임계 경로
public class BakJoon1948 {
    static int[] inDegree;
    static int[] result;
    static boolean[] visit;
    static ArrayList<Point>[] list;
    static ArrayList<Point>[] reverse;
    static int start, finish, nodeCount;

    static class Point {
        int point;
        int weight;

        Point(int point, int weight) {
            this.point = point;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeCount = Integer.parseInt(br.readLine());
        int lineCount = Integer.parseInt(br.readLine());
        list = new ArrayList[nodeCount + 1]; // 경로
        reverse = new ArrayList[nodeCount + 1]; // 경로 역추적
        visit = new boolean[nodeCount + 1]; // 방문 체크
        inDegree = new int[nodeCount + 1]; // 진입차수
        result = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            list[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < lineCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[startPoint].add(new Point(endPoint, weight));
            reverse[endPoint].add(new Point(startPoint, weight));
            inDegree[endPoint]++;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        finish = Integer.parseInt(st.nextToken());
        topologySort();
    }

    static void topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        // 임계경로 찾기
        queue.add(start);
        while (!queue.isEmpty()) {
            int check = queue.poll();
            for (Point next : list[check]) {
                if (result[next.point] <= result[check] + next.weight) {
                    result[next.point] = result[check] + next.weight;
                }
                inDegree[next.point]--;
                if (inDegree[next.point] == 0) {
                    queue.add(next.point);
                }
            }
        }
        // 역추적
        int count = 0;
        queue.add(finish);
        while (!queue.isEmpty()) {
            int check = queue.poll();
            for (Point next : reverse[check]) {
                if (result[check] - result[next.point] == next.weight) {
                    count++;
                    if (!visit[next.point]) {
                        visit[next.point] = true;
                        queue.add(next.point);
                    }
                }
            }
        }
        System.out.println(result[finish]);
        System.out.println(count);
    }
}
