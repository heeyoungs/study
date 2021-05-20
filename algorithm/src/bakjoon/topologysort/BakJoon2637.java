package bakjoon.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 장난감 조립
public class BakJoon2637 {
    static int[] inDegree;
    static int[] toy;
    static ArrayList<Point>[] list;

    static class Point {
        int pt;
        int weight;

        Point(int pt, int weight) {
            this.pt = pt;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        inDegree = new int[N + 1];
        list = new ArrayList[N + 1];
        toy = new int[N + 1];
        boolean[] ck = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int make = Integer.parseInt(st.nextToken());
            int need = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            // make를 만드는데 need가 count개 필요하다!
            list[make].add(new Point(need, count));
            ck[make] = true;
            inDegree[need]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                toy[i] = 1;
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int check = queue.poll();

            for (Point next : list[check]) {
                toy[next.pt] += toy[check] * next.weight;
                if (--inDegree[next.pt] == 0){
                    queue.add(next.pt);
                }
            }
        }

        for(int i=1;i<=N;i++){
            if (ck[i]) continue;
            System.out.println(i + " " + toy[i]);
        }
    }
}
