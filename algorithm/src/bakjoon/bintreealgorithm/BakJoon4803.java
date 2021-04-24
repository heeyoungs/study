package bakjoon.bintreealgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
// 트리
public class BakJoon4803 {
    static int treeCount;
    static int[] visit;
    static ArrayList<Integer>[] list;
    static int nowCase = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true) {
            treeCount = 0; // 트리의 개수
            st = new StringTokenizer(br.readLine());
            int nodeCount = Integer.parseInt(st.nextToken()); // 정점의 개수
            int lineCount = Integer.parseInt(st.nextToken()); // 간선의 개수
            if (nodeCount == 0 && lineCount == 0) {
                break;
            } // 종료 조건

            list = new ArrayList[nodeCount + 1]; // 간선 정보 저장
            for (int i = 1; i <= nodeCount; i++) {
                list[i] = new ArrayList<>();
            }
            visit = new int[nodeCount + 1]; // 방문 초기화
            for (int i = 0; i < lineCount; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            for (int i=1;i<=nodeCount;i++){ // 헤드 노드를 집어넣어야하는데 어떻게 해야할까~ -> 단말 노드를 넣을까
                if (visit[i] == 0 && list[i].size() == 1){
                    dfs(i,0);
                    treeCount++;
                }else if (list[i].size() == 0){ // 혼자 동 떨어진 애
                    treeCount++;
                }
            }

            if (treeCount == 0) {
                bw.write("Case " + nowCase + ": " + "No trees.\n");
            } else if (treeCount == 1) {
                bw.write("Case " + nowCase + ": " + "There is one tree.\n");
            } else {
                bw.write("Case " + nowCase + ": " + "A forest of " + treeCount + " trees.\n");
            }
            nowCase++;
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int start,int mother){
        visit[start] = 1;
        Stack<SM> stack = new Stack<>();
        stack.add(new SM(start,mother));
        while(!stack.isEmpty()){
            SM check = stack.pop();
            for(int node:list[check.start]){
                if (check.mother == node) continue;

                if (visit[node] == 0){
                    stack.push(new SM(node,check.start));
                    visit[node] = 1;
                }else{
                    treeCount--;
                    return;
                }
            }
        }

    }
    static class SM{
        int start;
        int mother;
        SM(int start, int mother){
            this.start = start;
            this.mother = mother;
        }
    }
}
