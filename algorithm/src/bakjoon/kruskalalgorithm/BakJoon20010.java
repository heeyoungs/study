package bakjoon.kruskalalgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

// 악덕 영주 혜유
public class BakJoon20010 {
    static int N, K;
    static int[] parent;
    static long ansD = 0;

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

    static ArrayList<Link>[] list;

    static class Link {
        int a;
        long weight;

        Link(int a, long weight) {
            this.a = a;
            this.weight = weight;
        }
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

        public int compareTo(Point o) {
            return (int) (weight - o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        PriorityQueue<Point> PQ = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            PQ.add(new Point(a, b, weight));
        }

        long ans = 0;
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (!findParent(now.a, now.b)) {
                unionParent(now.a, now.b);
                ans += now.weight;
                list[now.a].add(new Link(now.b, now.weight));
                list[now.b].add(new Link(now.a, now.weight));
            }
        }

        for (int i = 0; i < N; i++) {
            if (list[i].size() == 1) {
                dfs(i);
            }
        }

        System.out.println(ans);
        System.out.println(ansD);
    }

    static void dfs(int start) {
        Stack<Link> stack = new Stack<>();
        boolean[] visit = new boolean[N];
        visit[start] = true;
        stack.push(new Link(start, 0));
        while (!stack.isEmpty()) {
            Link now = stack.pop();
            ansD = Math.max(ansD,now.weight);

            for (Link next : list[now.a]) {
                if (visit[next.a]) continue;
                visit[next.a] = true;
                stack.push(new Link(next.a, now.weight + next.weight));
            }
        }
    }
}
