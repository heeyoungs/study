package bakjoon.greedyalgorithm;

import java.io.*;

public class BakJoon1541 {
    public static void main(String[] args) throws IOException { // -를 만나면 다시 -를 만날때까지 다 더하자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("-");
        int length = input.length;

        String[] start = input[0].split("\\+");
        int sum = 0;
        for (int i = 0; i < start.length; i++) {
            sum = sum + Integer.parseInt(start[i]);
        }

        for (int i = 1; i < length; i++) {
            int minusSum = 0;
            String[] ttt = input[i].split("\\+");
            for (int j = 0; j < ttt.length; j++) {
                minusSum = minusSum + Integer.parseInt(ttt[j]);
            }
            sum = sum - minusSum;
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
