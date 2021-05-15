package bakjoon.kruskalalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 나만 안되는 연애
public class BakJoon14621 {
    static char[] color;
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
            return weight - o.weight;
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        color = new char[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            color[i] = input[i - 1].charAt(0);
        }

        PriorityQueue<Point> PQ = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (color[a] == color[b]) continue;
            PQ.add(new Point(a, b, weight));
        }

        int ans = 0;
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();

            if (!findParent(check.a, check.b)) {
                unionParent(check.a, check.b);
                ans += check.weight;
            }
        }
        boolean check = true;
        for (int i = 1; i <= N; i++) {
            if (getParent(i) != 1) check = false;
        }
        if (check) System.out.println(ans);
        else System.out.println(-1);
    }
}
