package bakjoon.unsolved;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

// 회의 준비
public class BakJoon2610 {
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
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] area = new int[N + 1][N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                area[i][j] = Integer.MAX_VALUE / 2;
                if (i == j) area[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            area[a][b] = 1;
            area[b][a] = 1;
            unionParent(a, b);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == k || k == j || j == i) continue;
                    if (area[i][j] > area[i][k] + area[k][j])
                        area[i][j] = area[i][k] + area[k][j];
                }
            }
        }


        boolean[] check = new boolean[N + 1];
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!check[getParent(i)]) {
                count++;
                check[getParent(i)] = true;
            }
        }

        System.out.println(count);

        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int total = 0;
            for (int j = 1; j <= N; j++) {
                if (area[i][j] == Integer.MAX_VALUE / 2)
                    area[i][j] = 0;
                total += area[i][j];
                if (!maps.containsKey(getParent(i))){
                    maps.put(getParent(i),total);
                }
                if (maps.get(getParent(i)) > total){
                    maps.put(getParent(i),total);
                }
            }
        }
        for(int i=0;i<maps.size();i++){

        }

    }
}
