package bakjoon.kruskalalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 행성 연결
public class BakJoon16398 {
    static int parent[];

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
        long weight;

        Point(int a, int b, long weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return (int) (weight - o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        PriorityQueue<Point> queue = new PriorityQueue<>();
        for (int h = 1; h <= N; h++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int w = 1; w <= N; w++) {
                int weight = Integer.parseInt(st.nextToken());
                if (h == w) continue;
                queue.add(new Point(h, w, weight));
            }
        }

        long ans = 0;
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            if (!findParent(check.a, check.b)) {
                unionParent(check.a, check.b);
                ans += check.weight;
            }
        }
        System.out.println(ans);
    }
}
