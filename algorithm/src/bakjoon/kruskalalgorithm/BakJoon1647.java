package bakjoon.kruskalalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 도시 분할 계획
public class BakJoon1647 {
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

    static boolean findPoint(int a, int b) {
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        // 부모 설정
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        // 간선 설정
        PriorityQueue<Point> queue = new PriorityQueue<>();
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            queue.add(new Point(a, b, weight));
        }
        int lastWeight = 0;
        // 최소 스패닝 트리
        int ans = 0;
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            int a = check.a;
            int b = check.b;
            int weight = check.weight;
            if (!findPoint(a, b)) {
                ans += weight;
                unionParent(a, b);
                lastWeight = weight;
            }
        }
        System.out.println(ans - lastWeight);
    }
}
