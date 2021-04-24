package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 특정 거리의 도시 찾기
public class BakJoon18352 {
    static int nodeCount;
    static boolean[] visit;
    static ArrayList<Integer>[] list;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());
        int findDistance = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(st.nextToken());

        visit = new boolean[nodeCount + 1];
        list = new ArrayList[nodeCount + 1];
        distance = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
        }

        bfs(startPoint);

        for (int i = 1; i <= nodeCount; i++) {
            if(distance[i] == findDistance){
                sb.append(i + " ");
            }
        }
        if (sb.length() == 0) {
            sb.append(-1);
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        while (!queue.isEmpty()) {
            int check = queue.poll();
            for (int node : list[check]) {
                if (!visit[node]) {
                    distance[node] = distance[check] + 1;
                    visit[node] = true;
                    queue.add(node);
                }
            }
        }
    }
}

