package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 숫자 고르기
public class BakJoon2668 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N + 1];
        boolean[] check = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(br.readLine());
            array[i] = input;
            if (array[i] == i) check[i] = true; // 자기 자신
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (check[i]) continue;

            boolean[] visit = new boolean[N + 1];
            int start = i;
            while (true) {
                visit[start] = true;
                start = array[start];
                if (i == start) { // 원점으로 돌아왔을때
                    for (int j = 1; j <= N; j++) {
                        if (visit[j]) {
                            check[j] = true;
                        }
                    }
                }
                if (visit[start]) break; // 그 외 상황
            }
        }
        for (int i = 1; i <= N; i++) {
            if (check[i]) {
                queue.add(i);
            }
        }
        System.out.println(queue.size());
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
