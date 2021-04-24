package bakjoon.queuealgorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
// 요시푸스 문제 0
public class BakJoon11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int inputN = Integer.parseInt(input[0]);
        int inputK = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();

        bw.write("<");
        for (int i = 0; i < inputN; i++) {
            queue.add(i + 1);
        }

        while(queue.size() != 1){
            for(int i=0;i<inputK -1 ;i++){
                int k = queue.poll();
                queue.add(k);
            }
            bw.write(queue.poll() + ", ");
        }

        bw.write(queue.poll() + "");
        bw.write(">");
        bw.flush();
        bw.close();
        br.close();
    }
}