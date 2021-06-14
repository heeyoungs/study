package sourcecode.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 줄 세우기 -> 위상 정렬의 기초 문제 2252
public class TopologySort {
    static int[] lineCount; // -> 그 노드의 진입 차수
    static ArrayList<Integer>[] list; // -> 간선의 정보 저장
    static int[] ansArray;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        lineCount = new int[N + 1];
        ansArray = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            lineCount[end]++;
        }
        topology();
        for (int i = 1; i <= N; i++) {
            System.out.print(ansArray[i] + " ");
        }
    }

    static void topology() {
        Queue<Integer> queue = new LinkedList<>();
        // 진입 차수가 0인 노드를 인큐
        for (int i = 1; i <= N; i++) {
            if (lineCount[i] == 0) {
                queue.add(i);
            }
        }
        // 정렬이 완전히 수행되려면 정확히 n개의 노드를 방문해야함
        for (int i = 1; i <= N; i++) {
            int check = queue.poll();
            ansArray[i] = check;
            for (int next : list[check]) {
                lineCount[next]--; // 진입 차수 감소
                if (lineCount[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
