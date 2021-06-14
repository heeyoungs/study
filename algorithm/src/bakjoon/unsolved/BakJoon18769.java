package bakjoon.unsolved;

import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

// 그리드 네트워크
public class BakJoon18769 {
    static int[][] parent;

    static int getParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

    static void unionParent(int a, int b) {
        if (a == b) parent[a] = b;
        else parent[b] = a;
    }

    static boolean findParent(int a, int b) {
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
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            parent = new int[R + 1][C + 1];
            int pt = 1;
            for(int r=1;r<=R;r++){
                for(int c=1;c<=C;c++){
                    parent[r][c] = pt;
                    pt++;
                }
            }

            PriorityQueue<Point> PQ = new PriorityQueue<Point>();
            for (int i = 1; i <= R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= C - 1; j++) {

                }
            }
        }
    }
}
