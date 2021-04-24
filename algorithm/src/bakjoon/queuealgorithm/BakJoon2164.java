package bakjoon.queuealgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 카드 2
public class BakJoon2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();

        int inputN = sc.nextInt();

        for (int i = 0; i < inputN; i++) {
            queue.add(i+1);
        }

        while(queue.size() != 1){
            queue.poll();
            int num = queue.poll();
            queue.add(num);
        }

        System.out.println(queue.poll());
    }
}
