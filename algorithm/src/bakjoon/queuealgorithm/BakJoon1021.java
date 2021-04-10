package bakjoon.queuealgorithm;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class BakJoon1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new LinkedList<>();

        String[] input = br.readLine().split(" ");
        int inputQueueNodeCount = Integer.parseInt(input[0]);
        int popCount = Integer.parseInt(input[1]);

        String[] whereNumInput = br.readLine().split(" ");
        int[] array = new int[popCount];
        for (int i = 0; i < popCount; i++) {
            array[i] = Integer.parseInt(whereNumInput[i]);
        }

        for (int i = 0; i < inputQueueNodeCount; i++) {
            deque.add(i + 1);
        }

        int index = 0;
        int count = 0;
        int answer = 0;

        while (index != popCount) {
            int check = deque.pop();
            if (check == array[index]) {
                if (deque.size() + 1 - count < count) {
                    count = deque.size() + 1 - count;
                }
                answer = answer + count;
                index++;
                count = 0;
                continue;
            } else {
                deque.add(check);
                count++;
            }
        }

        bw.write(answer + "");bw.flush();bw.close();br.close();
    }
}