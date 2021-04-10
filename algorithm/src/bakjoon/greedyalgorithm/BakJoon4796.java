package bakjoon.greedyalgorithm;

import java.io.*;

public class BakJoon4796 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 1;
        while (true) {

            String[] input = br.readLine().split(" ");
            int L = Integer.parseInt(input[0]);
            int P = Integer.parseInt(input[1]);
            int V = Integer.parseInt(input[2]);
            if (L == 0 && P == 0 && V == 0) {
                break;
            } // 종료조건

            int count = (V / P) * L;
            V = V % P;
            if(V >= L) {
                count = count + L;
            } else {
                count = count + V;
            }
            bw.write("Case " + i++ + ": " + count +"\n");
        }
        bw.flush();bw.close();br.close();
    }
}
