package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 네트워크 복구
public class BakJoon2211 {
    static ArrayList<PW>[] list;
    static int[] distance;
    static boolean[] visit;
    static int nodeCount;
    static int[] ans;

    static class PW {
        int point;
        int weight;

        PW(int point, int weight) {
            this.point = point;
            this.weight = weight;
        }
    }

    // 필요없는 간선들을 버리는 문제! -> 이어주는 간선들을 출력하는 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken()); // 정점의 개수
        int lineCount = Integer.parseInt(st.nextToken()); // 간선의 개수

        // 간선들의 정보를 저장할 배열
        list = new ArrayList[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            list[i] = new ArrayList<>();
        }

        // 간선들의 거리값을 저장할 배열
        distance = new int[nodeCount + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 방문 여부를 저장할 배열
        visit = new boolean[nodeCount + 1];

        for (int line = 0; line < lineCount; line++) {
            st = new StringTokenizer(br.readLine());
            int pointA = Integer.parseInt(st.nextToken());
            int pointB = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[pointA].add(new PW(pointB, weight));
            list[pointB].add(new PW(pointA, weight));
        }

        // 최소한의 간선수 = 컴퓨터수 - 1
        sb.append(nodeCount - 1).append("\n");

        // 연결된 간선 정보를 저장할 배열
        ans = new int[nodeCount + 1];

        // 1번 컴퓨터가 시작지점
        dijkstra(1);

        for(int i=2;i<=nodeCount;i++){
            sb.append(ans[i]).append(" ").append(i).append("\n");
        }

        System.out.println(sb);
    }

    // 간선 끼리의 경로 설정
    static void dijkstra(int start) {
        distance[start] = 0;
        PriorityQueue<PW> PQ = new PriorityQueue<>(new Comparator<PW>() {
            @Override
            public int compare(PW o1, PW o2) {
                return o1.weight - o2.weight;
            }
        });
        PQ.add(new PW(start, 0));

        while (!PQ.isEmpty()) {
            PW check = PQ.poll();
            if (!visit[check.point]) {
                visit[check.point] = true;
                for (PW pt : list[check.point]) {
                    if (distance[pt.point] > distance[check.point] + pt.weight) {
                        distance[pt.point] = distance[check.point] + pt.weight;
                        PQ.add(new PW(pt.point, distance[pt.point]));
                        // 마지막으로 갱신된 선 저장
                        ans[pt.point] = check.point;
                    }
                }
            }
        }
    }
}
