package bakjoon.kruskalalgorithm;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 전기가 부족해
public class BakJoon10423 {
    static int N, M, K;

    static int[] parent;

    static int getParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

    static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }

    static boolean findParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) return true;
        else return false;
    }

    static class Point implements Comparable<Point> {
        int a;
        int b;
        int weight;

        Point(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        // 1 line
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        // 2 line
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            parent[Integer.parseInt(st.nextToken())] = 0;
        }
        // 3 line
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            PQ.add(new Point(a, b, weight));
        }
        // solve
        long ans = 0;
        while(!PQ.isEmpty()){
            Point check = PQ.poll();

            if (!findParent(check.a,check.b)){
                unionParent(check.a,check.b);
                ans += check.weight;
            }
        }
        System.out.println(ans);
    }
}