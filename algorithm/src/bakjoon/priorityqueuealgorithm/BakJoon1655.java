package bakjoon.priorityqueuealgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
// 가운데를 말해요
public class BakJoon1655 {
    // 중앙값을 기준으로 작은것을 저장하는 최대 힙 + 중앙값을 기준으로 큰것을 저장하는 최소 힙
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int numberCount = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(); // 최소 힙
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder()); // 최대 힙
        for (int i = 0; i < numberCount; i++) {
            int input = Integer.parseInt(br.readLine());
            if (maxPQ.size() == minPQ.size()) {
                maxPQ.add(input);
            } else {
                minPQ.add(input);
            }

            if (maxPQ.size() > 0 && minPQ.size() > 0 && maxPQ.peek() > minPQ.peek()) { ;
                minPQ.add(maxPQ.poll());
                maxPQ.add(minPQ.poll());
            }
            sb.append(maxPQ.peek() + "\n");
        }
        System.out.print(sb);
    }
}
