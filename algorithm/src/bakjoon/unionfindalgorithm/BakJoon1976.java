package bakjoon.unionfindalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BakJoon1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int M = Integer.parseInt(br.readLine()); // 방문할 도시
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }


        for (int h = 1; h <= N; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 1; w <= N; w++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 1) unionParent(w,h);
            }
        }

        boolean check = true;
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int start = getParent(k);

        for (int i = 1; i < M; i++) {
            k = Integer.parseInt(st.nextToken());
            if (start != getParent(k)) check = false;
        }
        if (check){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

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
}
