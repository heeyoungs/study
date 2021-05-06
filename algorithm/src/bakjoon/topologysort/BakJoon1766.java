package bakjoon.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 문제집
public class BakJoon1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] inDegree = new int[N + 1];
        int[] result = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            inDegree[end]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=1;i<=N;i++){
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }

        for(int i=1;i<=N;i++){
            int check = queue.poll();
            result[i] = check;
            for(int next : list[check]){
                inDegree[next]--;
                if (inDegree[next] == 0){
                    queue.add(next);
                }
            }
        }

        for(int i=1;i<=N;i++){
            System.out.print(result[i] + " ");
        }
    }
}
