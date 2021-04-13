package bakjoon.bfs_dfs_algorithm;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BakJoon1707 { // 그래프를 방문할때마다 다른 값으로 초기화해주는 문제
    static int[] visit;
    static ArrayList<Integer>[] list;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean findAns = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            // 테스트 케이스 분류
            findAns = false;
            st = new StringTokenizer(br.readLine());
            int nodeCount = Integer.parseInt(st.nextToken());
            int lineCount = Integer.parseInt(st.nextToken());
            visit = new int[nodeCount + 1];
            list = new ArrayList[nodeCount + 1];
            for (int j = 1; j <= nodeCount; j++) {
                list[j] = new ArrayList<>();
            }


            for (int j = 0; j < lineCount; j++) { // 배열별 연결 리스트에 간선 정보 저장
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                list[first].add(second);
                list[second].add(first);
                // 아 ㅈㄴ 짜증나게 쓸데없는 조건문 넣었다가 계속 시간초과떳네 이거땜에 2시간날림 ㅅㄱ
                //if (!list[first].contains(second)) {
                //    list[first].add(second);
                //}
                //if (!list[second].contains(first)) {
                //   list[second].add(first);
                //}
            }

            for (int k = 1; k <= nodeCount; k++) {
                if (visit[k] == 0 && !findAns) {
                    dfs(k, true); // 깊이 탐색 시작
                }
            }

            if (!findAns) { // 위 dfs 반복에서 NO가 나오지 않으면 YES
                bw.write("YES\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int index, boolean check) throws IOException { // 정점을 분리하자
        if (check) { // 한번 재귀 돌때마다 visit 의 값을 -1,1 바꿔주기
            visit[index] = -1;
            check = false;
        } else {
            visit[index] = 1;
            check = true;
        }
        for (int node : list[index]) {
            if (visit[node] == visit[index] && !findAns){ // 인접한 노드끼리의 visit 값이 같으면 NO
                bw.write("NO\n");
                findAns = true;
                return;
            }
            if (visit[node] == 0) {
                dfs(node, check);
            }
        }
    }
}
