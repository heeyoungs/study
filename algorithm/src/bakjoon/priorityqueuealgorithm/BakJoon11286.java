package bakjoon.priorityqueuealgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
// 절대값 힙
public class BakJoon11286 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() { // 새로운 정렬 기준 만들기
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) > Math.abs(o2)){
                    return 1;
                }else if (Math.abs(o2) > Math.abs(o1)){
                    return -1;
                }else {
                    if (o2 > o1){
                        return -1;
                    }else {
                        return 1;
                    }
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(br.readLine());
        for(int i=0;i<inputCount;i++){
            int input = Integer.parseInt(br.readLine());
            if (input == 0){
                if (heap.isEmpty()){
                    sb.append("0\n");
                }else{
                    sb.append(heap.poll() + "\n");
                }
            }else {
                heap.add(input);
            }
        }
        System.out.println(sb);
    }
}
