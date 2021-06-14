package bakjoon.topologysort;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;

// 최종 순위
public class BakJoon3665 {
    static int[] array;
    static int[] inDegree;
    static int[] ansArray;
    static ArrayList<Integer>[] list;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }
            array = new int[N];
            inDegree = new int[N + 1];
            ansArray = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    list[array[j]].add(array[i]);
                    inDegree[array[i]]++;
                }
            }
            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (list[a].contains(b)) {
                    list[a].remove((Integer) b);
                    inDegree[b]--;
                    list[b].add(a);
                    inDegree[a]++;
                } else if (list[b].contains(a)) {
                    list[b].remove((Integer)a);
                    inDegree[a]--;
                    list[a].add(b);
                    inDegree[b]++;
                }
            }

            Queue<Integer> Q = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    Q.add(i);
                }
            }

            boolean ck = true;
            for (int i = 0; i < N; i++) {
                if (Q.isEmpty()) {
                    ck = false;
                    break;
                }
                int check = Q.poll();
                ansArray[i] = check;

                for (int next : list[check]) {
                    inDegree[next]--;
                    if (inDegree[next] == 0){
                        Q.add(next);
                    }
                }
            }
            if (ck) {
                for(int i=0;i<N;i++){
                    sb.append(ansArray[i]).append(" ");
                }
                sb.append("\n");
            }else sb.append("IMPOSSIBLE").append("\n");
        }
        System.out.print(sb);
    }
}
