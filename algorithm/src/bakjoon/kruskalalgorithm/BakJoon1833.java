package bakjoon.kruskalalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BakJoon1833 {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        parent = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            parent[i] = i;
        }

        int ans = 0;
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        for (int h = 1; h <= M; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < M; w++) {
                int weight = Integer.parseInt(st.nextToken());
                if (weight < 0) {
                    unionParent(w + 1, h);
                    ans = ans + -weight;
                } else if (weight > 0) {
                    PQ.add(new Point(w + 1, h, weight));
                }
            }
        }
        ans /= 2;
        int count = 0;
        while(!PQ.isEmpty()){
            Point check = PQ.poll();
            if (!findParent(check.a,check.b)){
                unionParent(check.a,check.b);
                ans += check.weight;
                count++;
                sb.append(check.a).append(" ").append(check.b).append("\n");
            }
        }
        System.out.println(ans + " " + count);
        System.out.println(sb);
    }
}
