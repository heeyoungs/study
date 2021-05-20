package bakjoon.topologysort;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 음악 프로그램
public class BakJoon2623 {
    static int[] ans;
    static int[] inDegree;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ans = new int[N + 1];
        inDegree = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int[] array = new int[K];
            for (int j = 0; j < K; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < K - 1; j++) {
                list[array[j]].add(array[j + 1]);
                inDegree[array[j + 1]]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        boolean ck = true;
        for (int i = 0; i < N; i++) {
            if (queue.isEmpty()){
                ck = false;
                break;
            }
            int check = queue.poll();
            ans[i] = check;

            for(int next : list[check]){
                inDegree[next]--;
                if (inDegree[next] == 0){
                    queue.add(next);
                }
            }
        }

        if (ck) {
            for (int i = 0; i < N; i++) {
                System.out.println(ans[i]);
            }
        }else{
            System.out.println(0);
        }
    }
}
