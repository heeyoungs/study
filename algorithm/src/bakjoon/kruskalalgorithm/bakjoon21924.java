package bakjoon.kruskalalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 도시 건설
public class bakjoon21924 {
    static int[] parent;

    static int getParent(int x) {
        if (parent[x] == x) {
            return x;
        } return parent[x] = getParent(parent[x]);
    }

    static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    static boolean findParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b)
            return true;
        else
            return false;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        long totalDist = 0;
        long needDist = 0;
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            totalDist += weight;
            PQ.add(new Point(a, b, weight));
        }

        while (!PQ.isEmpty()) {
            Point check = PQ.poll();
            if (!findParent(check.a,check.b)){
                unionParent(check.a,check.b);
                needDist += check.weight;
            }
        }

        for(int i=1;i<=N;i++){
            if (getParent(i) != 1){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(totalDist - needDist);
    }
}
