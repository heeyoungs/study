package bakjoon.bintreealgorithm;

/*
고려할 점!
1. 루트 노드는 하나가 아닐수도 있다.-> 루트가 여러개
2. 이진 트리가 아닐수도 있다.-> 자식이 여러개
3. 루트 노드또한 단말 노드가 될 수 있다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 트리
public class BakJoon1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken()); // 노드 개수
        ArrayList<Integer>[] list = new ArrayList[nodeCount];
        for (int i = 0; i < nodeCount; i++) { // 간선 저장용
            list[i] = new ArrayList<>();
        }
        boolean[] visit = new boolean[nodeCount]; // 방문처리용
        st = new StringTokenizer(br.readLine()); // 간선 정보 하나씩 불러옴

        int[] arrayOfRoot = new int[51]; // 루트 노드 저장용
        int rootCount = 0; // 루트 노드의 개수

        for (int i = 0; i < nodeCount; i++) {
            int check = Integer.parseInt(st.nextToken()); // check -> 부모 i -> 자식
            if (check == -1) { // 루트 노드 구하기
                arrayOfRoot[rootCount] = i;
                rootCount++;
                continue;
            }
            list[check].add(i); // 자식노드를 향한 간선 하나 추가
        }
        int deleteNode = Integer.parseInt(br.readLine()); // 지울 노드
        visit[deleteNode] = true; // 지울 노드의 방문 처리 -> 이 밑으론 못내려간다!!
        int ans = 0; // 답 초기화
        // bfs 로 leaf 노드 개수 구하기 -> 자식 노드가 없거나, 더이상 내려갈수 없으면 ++; -> dfs 도 상관없다!!
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<rootCount;i++){ // 루트 노드를 모두 인큐
            if(deleteNode == arrayOfRoot[i]){ // 만약 루트 노드를 지웠다면 패스
                continue;
            }
            queue.add(arrayOfRoot[i]);
        }

        while (!queue.isEmpty()) {
            int check = queue.poll();
            if (list[check].size() == 0) { // 자식 간선이 없을 경우 ++;
                ans++;
            }

            for (int node : list[check]) {
                if (visit[node]) { // 이미 방문처리된 노드 -> 지운노드 만난거임
                    if(list[check].size() == 1) { // 방문처리된 노드만이 자식일 경우
                        ans++;
                        break;
                    }
                } else { // 일반적인 경우
                    queue.add(node);
                }
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}