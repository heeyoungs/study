package bakjoon.backtrackingalgorithm;

import java.awt.*;
import java.io.*;

public class BakJoon15649 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int inputN = Integer.parseInt(input[0]);
        int inputM = Integer.parseInt(input[1]);

        int[] array = new int[inputN];
        for (int i = 0; i < inputN; i++) {
            array[i] = i + 1;
        } // 1부터 N 까지의 배열


    }
}
