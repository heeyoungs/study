package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BakJoon1325 {
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int[] count;
    static int nodeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());
        list = new ArrayList[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int pointA = Integer.parseInt(st.nextToken());
            int pointB = Integer.parseInt(st.nextToken());
            //list[pointA].add(pointB);
            list[pointB].add(pointA);
        }
        count = new int[nodeCount + 1];
        count[0] = 0;
        int max  =0;
        for (int i = 1; i <= nodeCount; i++) {
            count[i] = bfs(i);
            if (count[i] > max){
                max = count[i];
            }
        }
        for(int i=1;i<=nodeCount;i++){
            if (count[i] == max){
                sb.append(i + " ");
            }
        }
        System.out.print(sb);
    }

    static int bfs(int start) {
        visit = new boolean[nodeCount + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        int count = 0;
        while(!queue.isEmpty()){
            int check = queue.poll();
            count++;

            for(int node :list[check]){
                if (!visit[node]){
                    visit[node] = true;
                    queue.add(node);
                }
            }
        }
        return count;
    }
}
