package bakjoon.bintreealgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BakJoon1167 {
    static ArrayList<Point>[] list;
    static boolean[] visit;
    static int node = 1;
    static int ansDist;

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
        int nodeCount = Integer.parseInt(br.readLine());
        list = new ArrayList[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            list[i] = new ArrayList<>();
        } // 배열 생성
        for (int i = 0; i < nodeCount; i++) {
            String[] input = br.readLine().split(" ");
            int startPoint = Integer.parseInt(input[0]);
            for (int k = 1; k < input.length - 1; k = k + 2) {
                int endPoint = Integer.parseInt(input[k]);
                int weight = Integer.parseInt(input[k + 1]);
                list[startPoint].add(new Point(endPoint, weight));
            }
            // input 의 맨 마지막은 -1이니 패스!
        } // 간선 정보 연결
        visit = new boolean[nodeCount + 1];
        dfs(node, 0);

        Arrays.fill(visit, false);
        dfs(node, 0);
        System.out.print(ansDist);
    }

    static void dfs(int start, int distance) {
        visit[start] = true;
        if (distance > ansDist) {
            ansDist = distance;
            node = start;
        }
        for(Point pt : list[start]){
            if(!visit[pt.point]){
                dfs(pt.point, pt.weight + distance);
            }
        }
    }
}
