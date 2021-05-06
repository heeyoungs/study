package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.StringTokenizer;

// ABCDE
public class BakJoon13023 {
    static int N, Ans = 0;
    static ArrayList<Integer>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }
        for (int i = 0; i < N; i++) {
            visit = new boolean[N + 1];
            visit[i] = true;
            dfs(i,1);
            if (Ans == 1){
                break;
            }
        }
        System.out.println(Ans);
    }

    static void dfs(int i,int count) {
        if (count == 5){
            Ans = 1;
            return;
        }

        for(int ck : list[i]){
            if (!visit[ck]){
                visit[ck] = true;
                dfs(ck,count + 1);
                visit[ck] = false;
            }
        }
    }
}
