package bakjoon.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 게임 개발
public class BakJoon1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[nodeCount + 1];
        int[] inDegree = new int[nodeCount + 1];
        int[] weightArray = new int[nodeCount + 1];
        int[] dp = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= nodeCount; i++) {
            String[] line = br.readLine().split(" ");
            int weight = Integer.parseInt(line[0]);
            weightArray[i] = weight;
            for (int j = 1; j < line.length - 1; j++) {
                int nextPoint = Integer.parseInt(line[j]);
                list[nextPoint].add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= nodeCount; i++) {
            if (inDegree[i] == 0){
                queue.add(i);
                dp[i] = weightArray[i];
            }
        }

        while(!queue.isEmpty()){
            int check = queue.poll();
            for(int next : list[check]){
                inDegree[next]--;
                dp[next] = Math.max(dp[check] + weightArray[next],dp[next]);
                if (inDegree[next] == 0){
                    queue.add(next);
                }
            }
        }

        for(int i=1;i<=nodeCount;i++){
            System.out.println(dp[i]);
        }
    }
}
