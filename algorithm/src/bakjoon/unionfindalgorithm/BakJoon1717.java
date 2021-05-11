package bakjoon.unionfindalgorithm;

import java.io.*;
import java.util.StringTokenizer;

// 집합의 표현
public class BakJoon1717 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int how = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (how == 0) { // 합침
                unionParent(a,b);
            } else{ // 확인
                if (findParent(a,b)){
                    bw.write("yes\n");
                }else{
                    bw.write("no\n");
                }
            }
        }
        bw.flush();
    }

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
}
