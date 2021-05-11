package bakjoon.kruskalalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 별자리 만들기
public class BakJoon4386 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        Point[] pt = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            pt[i] = new Point(x, y);
        }
        PriorityQueue<xyw> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                queue.add(new xyw(i, j, getDist(pt[i].x, pt[i].y, pt[j].x, pt[j].y)));
            }
        }

        double ans = 0;
        while (!queue.isEmpty()) {
            xyw check = queue.poll();
            int x = check.start;
            int y = check.end;
            double weight = check.weight;
            if (!findParent(x, y)) {
                unionParent(x, y);
                ans += weight;
            }
        }
        System.out.printf("%.2f", ans);
    }

    static int getParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

    static boolean findParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) return true;
        else return false;
    }

    static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }

    static double getDist(double ax, double ay, double bx, double by) {
        return Math.sqrt((ax - bx) * (ax - bx) + (ay - by) * (ay - by));
    }

    static class xyw implements Comparable<xyw> {
        int start;
        int end;
        double weight;

        xyw(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(xyw o) {
            return (int) (weight * 1000 - o.weight * 1000);
        }
    }

    static class Point {
        double x;
        double y;


        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
