package bakjoon.queuealgorithm;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
// AC
public class BakJoon5430 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            Deque<Integer> deque = new LinkedList<>();

            String hamsu = br.readLine();
            int arrayCount = Integer.parseInt(br.readLine());
            String[] inputNum = br.readLine().split("\\[|,|]");

            for (int j = 1; j < arrayCount + 1; j++) {
                deque.add(Integer.parseInt(inputNum[j]));
            }
            int stop = 0;
            int startPoint = 0; // 0은 front, 1은 rear
            Outter:for (int j = 0; j < hamsu.length(); j++) {
                if (hamsu.charAt(j) == 'R') {
                    if (startPoint == 0) {
                        startPoint = 1;
                    } else if (startPoint == 1) {
                        startPoint = 0;
                    }
                } else if (hamsu.charAt(j) == 'D') {
                    if(deque.isEmpty()){
                        bw.write("error\n");
                        stop = 1;
                        break Outter;
                    } else if(startPoint == 0){ // front제거
                        deque.pollFirst();
                    } else if (startPoint == 1){ // rear제거
                        deque.pollLast();
                    }
                }
            }
            if(stop == 1){
                continue;
            }

            bw.write("[");
            if(!deque.isEmpty()) {
                if (startPoint == 0) {
                    while (deque.size() != 1) {
                        bw.write(deque.pollFirst() + ",");
                    }
                } else if (startPoint == 1) {
                    while (deque.size() != 1) {
                        bw.write(deque.pollLast() + ",");
                    }
                }
                bw.write(deque.poll() + "");
            }
            bw.write("]\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
