package bakjoon.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 작업
public class BakJoon2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] weightArray = new int[N + 1];
        int[] dp = new int[N + 1];
        int[] inDegree = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            weightArray[i] = weight;
            for (int k = 2; k < input.length; k++) {
                int end = Integer.parseInt(input[k]);
                list[i].add(end);
                inDegree[end]++;
            }
        }

        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if (inDegree[i] == 0){
                queue.add(i);
                dp[i] = weightArray[i];
                ans = Math.max(ans,dp[i]);
            }
        }

        while(!queue.isEmpty()){
            int check = queue.poll();
            for(int next : list[check]){
                dp[next] =  Math.max(dp[check] + weightArray[next],dp[next]);
                ans = Math.max(ans,dp[next]);
                inDegree[next]--;
                if (inDegree[next] == 0){
                    queue.add(next);
                }
            }
        }
        System.out.println(ans);
    }
}
