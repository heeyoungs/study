package bakjoon.kruskalalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우주신과의 교감
public class BakJoon1774 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Point[] pt = new Point[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pt[i] = new Point(x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            unionParent(x, y);
        }

        PriorityQueue<Point2> queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                queue.add(new Point2(i, j, getDist(pt[i].x, pt[i].y, pt[j].x, pt[j].y)));
            }
        }

        double ans = 0;
        while (!queue.isEmpty()) {
            Point2 check = queue.poll();
            int x = check.ptA;
            int y = check.ptB;
            double weight = check.weight;
            if (!findParent(x, y)) {
                unionParent(x, y);
                ans += weight;
            }
        }
        System.out.printf("%.2f",ans);
    }

    static double getDist(double ax, double ay, double bx, double by) {
        return Math.sqrt((ax - bx) * (ax - bx) + (ay - by) * (ay - by));
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Point2 implements Comparable<Point2> {
        int ptA;
        int ptB;
        double weight;

        Point2(int ptA, int ptB, double weight) {
            this.ptA = ptA;
            this.ptB = ptB;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point2 o) {
            return (int) (weight * 1000 - o.weight * 1000);
        }
    }
}
