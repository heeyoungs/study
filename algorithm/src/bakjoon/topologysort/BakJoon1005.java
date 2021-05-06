package bakjoon.topologysort;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// ACM Craft
public class BakJoon1005 {
    static int nodeCount;
    static int[] weight;
    static int[] inDegree;
    static int[] dp;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            nodeCount = Integer.parseInt(st.nextToken());
            int lineCount = Integer.parseInt(st.nextToken());
            weight = new int[nodeCount + 1];
            inDegree = new int[nodeCount + 1];
            dp = new int[nodeCount + 1];
            list = new ArrayList[nodeCount + 1];
            for (int i = 1; i <= nodeCount; i++) {
                list[i] = new ArrayList<>();
            }
            // 가중치
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= nodeCount; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < lineCount; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list[start].add(end);
                inDegree[end]++;
            }
            topology();
            int finish = Integer.parseInt(br.readLine());
            bw.write(dp[finish] + "\n");
        }
        bw.flush();
    }

    static void topology() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=nodeCount;i++){
            if (inDegree[i] == 0){
                queue.add(i);
                dp[i] = weight[i];
            }
        }
        while(!queue.isEmpty()){
            int check = queue.poll();
            for(int next : list[check]){
                dp[next] = Math.max(dp[next],dp[check] + weight[next]);
                inDegree[next]--;
                if (inDegree[next] == 0){
                    queue.add(next);
                }
            }
        }
    }
}
