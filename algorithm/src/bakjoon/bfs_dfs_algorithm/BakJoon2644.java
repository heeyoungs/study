package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// 촌수 계산
public class BakJoon2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int personNum = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]); // 시작 노드
        int end = Integer.parseInt(input[1]); // 종료 노드
        int lineCount = Integer.parseInt(br.readLine()); // 간선 개수

        int[] who = new int[personNum + 1]; // visit
        ArrayList<Integer>[] line = new ArrayList[personNum + 1]; // 리스트 초기화
        for (int i = 1; i <= personNum; i++) {
            line[i] = new ArrayList<>();
        }

        for (int p = 0; p < lineCount; p++) { // 간선 정보 연결
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            line[a].add(b);
            line[b].add(a);
        }
        int ans = -1;

        Queue<Integer> queue = new LinkedList<>();
        who[start] = 1;
        queue.add(start);
        while(!queue.isEmpty()){
            int check = queue.poll();
            if (check == end){ // 종료조건
                ans = who[check] - 1;
                break;
            }

            for(int node : line[check]){
                if(who[node] == 0){
                    who[node] = who[check] + 1;
                    queue.add(node);
                }
            }
        }
        bw.write(ans + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}
