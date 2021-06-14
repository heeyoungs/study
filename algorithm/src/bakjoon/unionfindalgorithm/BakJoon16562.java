package bakjoon.unionfindalgorithm;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 친구비
public class BakJoon16562 {
    static int N, M, K;

    static int[] parent;

    static Point[] cost;

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

    static class Point {
        int friendNumber;
        int cost;

        Point(int friendNumber, int cost) {
            this.friendNumber = friendNumber;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        cost = new Point[N];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = new Point(i + 1, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(cost, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.cost - o2.cost;
            }
        });

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            unionParent(a, b);
        }

        int ans = 0;
        for(int i=0;i<N;i++){
            if (getParent(cost[i].friendNumber) != 0){
                unionParent(cost[i].friendNumber,0);
                ans += cost[i].cost;
            }
        }
        if (ans <= K) System.out.println(ans);
        else System.out.println("Oh no");
    }
}
