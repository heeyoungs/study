package bakjoon.kruskalalgorithm;

import java.io.*;
import java.util.*;

// 학교 탐방하기
public class BakJoon13418 {
    static int N;

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

    static class Point {
        int a, b, weight;

        Point(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Point[] array = new Point[M + 1];
        for (int i = 0; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = (Integer.parseInt(st.nextToken()) + 1) % 2;
            array[i] = new Point(a, b, weight);
        }

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        Arrays.sort(array, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.weight - o2.weight;
            }
        });
        Queue<Point> Q1 = new LinkedList<>();
        for (int i = 0; i <= M; i++) {
            Q1.add(array[i]);
        }
        int count1 = 0;
        for(int i=0;i<=M;i++){
            if (!findParent(array[i].a, array[i].b)) {
                unionParent(array[i].a, array[i].b);
                count1 += array[i].weight;
            }
        }

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        Arrays.sort(array, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o2.weight - o1.weight;
            }
        });
        int count2 = 0;
        for(int i=0;i<=M;i++){

            if (!findParent(array[i].a, array[i].b)) {
                unionParent(array[i].a, array[i].b);
                count2 += array[i].weight;
            }
        }
        System.out.println(count2 * count2 - count1 * count1);
    }
}
