package bakjoon.priorityqueuealgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BakJoon1655_ {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int inputCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < inputCount; i++) {
            int input = Integer.parseInt(br.readLine());
            pq.add(input);
            int k = i/2;
            int count = 0;
            while (true) {
                if(count == k){
                    sb.append(pq.peek() + "\n");
                    break;
                }
                list.add(pq.poll());
                count++;
            }
            while(!list.isEmpty()){
                pq.add(list.get(0));
                list.remove(0);
            }
        }
        System.out.println(sb);
    }
}
