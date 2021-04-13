package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.LinkedList;

public class BakJoon11724 {
    static LinkedList<Integer>[] list;
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int nodeCount = Integer.parseInt(input[0]);
        int lineCount = Integer.parseInt(input[1]);
        visit = new boolean[nodeCount + 1];
        list = new LinkedList[nodeCount +1];
        for(int i=1;i<=nodeCount;i++){
            list[i] = new LinkedList<>();
        }

        for(int i=0;i<lineCount;i++){
            input = br.readLine().split(" ");
            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);

            list[first].add(second);
            list[second].add(first);
        }

        int count = 0;
        for(int i=1;i<=nodeCount;i++){
            if (visit[i] == false){
                dfs(i);
                count++;
            }
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int index){
        visit[index] = true;
        for(int node : list[index]){
            if (!visit[node]){
                dfs(node);
            }
        }
    }
}
