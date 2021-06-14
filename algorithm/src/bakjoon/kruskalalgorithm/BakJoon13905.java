package bakjoon.kruskalalgorithm;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 세부
public class BakJoon13905 {
    static int N, M, Start, End;
    static int[] parent;

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
            return o.weight - weight;
        }
    }

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Start = Integer.parseInt(st.nextToken());
        End = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        PriorityQueue<Point> PQ = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            PQ.add(new Point(a, b, weight));
        }

        while(!PQ.isEmpty()){
            Point now = PQ.poll();

            if (!findParent(now.a,now.b)){
                unionParent(now.a,now.b);
            }
            if (findParent(Start,End)){
                System.out.println(now.weight);
                return;
            }
        }
        System.out.println(0);
    }
}
