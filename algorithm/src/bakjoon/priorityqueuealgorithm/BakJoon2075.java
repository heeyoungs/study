package bakjoon.priorityqueuealgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// N번째 큰 수
public class BakJoon2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (queue.isEmpty()) { // 맨 첨에
                    queue.add(k);
                }else if (k >queue.peek()){
                    queue.add(k);
                }
                if (queue.size() > N) {
                    queue.poll();
                }
            }
        }
        System.out.println(queue.poll());
    }
}
/*
=> 최소힙생성!
1. 맨 첨에 만난 원소를 인큐
2. 두번째부턴 원소와 큐의 맨 꼭대기 값을 비교
    => 지금 원소가 맨 꼭대기 값보다 크면 인큐
3. 큐의 크기가 N보다 크면 팝
결과적으로 큐의 맨 꼭대기 값은 N번째 큰 수가 됨.
 */

