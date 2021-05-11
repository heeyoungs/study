package bakjoon.unionfindalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사이클 게임
public class BakJoon20040 {
    static int[] parent;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int ans = 0;
        boolean isFindAns = false;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            if (isFindAns) continue;
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            unionParent(a, b);
            if (check) {
                ans = i;
                isFindAns = true;
            }
        }
        System.out.println(ans);
    }

    static int getParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

    static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) check = true;
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
}
