package bakjoon.unionfindalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 거짓말
public class BakJoon1043 {
    static int[] parent;

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

    static int getParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 사람의 수
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int M = Integer.parseInt(input[1]); // 파티의 수
        input = br.readLine().split(" ");
        for (int i = 1; i < input.length; i++) {
            int k = Integer.parseInt(input[i]); // 진실을 아는 사람의 번호
            unionParent(0, k);
        }
        ArrayList<Integer>[] list = new ArrayList[M];
        // 파티별 나누기
        for (int i = 0; i < M; i++) {
            list[i] = new ArrayList<>();
            input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]); // 파티에 오는 사람의 수
            for (int j = 1; j < input.length; j++) {
                int k = Integer.parseInt(input[j]);
                list[i].add(k);
            }
        }
        // 사람들 묶기
        for(int k=0;k<M;k++) {
            for (int i = 0; i < M; i++) {
                boolean check = false;
                // 진실을 아는 사람이 있으면
                for (int j = 0; j < list[i].size(); j++) {
                    if (getParent(list[i].get(j)) == 0)
                        check = true;
                }
                // 그 파티원 모두 0으로 처리
                if (check) {
                    for (int j = 0; j < list[i].size() - 1; j++) {
                        unionParent(list[i].get(j), list[i].get(j + 1));
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < M; i++) {
            boolean check = true;
            // 진실을 아는 사람이 있으면
            for (int j = 0; j < list[i].size(); j++) {
                if (getParent(list[i].get(j)) == 0)
                    check = false;
            }
            if (check) ans++;
        }
        System.out.println(ans);
    }
}
