package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 자동차 경주
public class BakJoon2611 {
    static class Point {
        int pt;
        int weight;

        Point(int pt, int weight) {
            this.pt = pt;
            this.weight = weight;
        }

        Point(int pt) {
            this.pt = pt;
        }
    }

    static boolean[] visit;
    static int[] dist;
    static int[] parent;
    static ArrayList<Point>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        dist = new int[N + 1];
        visit = new boolean[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Point(end, weight));
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1));
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            visit[check.pt] = false;
            for (Point next : list[check.pt]) {
                if (next.pt == 1) {
                    if (dist[1] <= dist[check.pt] + next.weight) {
                        dist[1] = dist[check.pt] + next.weight;
                        parent[1] = check.pt;
                    }
                } else {
                    if (dist[next.pt] > dist[check.pt] + next.weight) continue;
                    dist[next.pt] = dist[check.pt] + next.weight;
                    parent[next.pt] = check.pt;
                    if (!visit[next.pt]) {
                        visit[next.pt] = true;
                        queue.add(new Point(next.pt, dist[next.pt]));
                    }
                }
            }
        }
        System.out.println(dist[1]);

        Stack<Integer> stack = new Stack<>();
        int k = 1;
        while(true){
            stack.push(k);
            k = parent[k];
            if (k== 1)break;;
        }
        stack.push(1);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
