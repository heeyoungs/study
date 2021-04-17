package bakjoon.backtrackingalgorithm;

import java.io.*;

public class BakJoon15649 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int inputN = Integer.parseInt(input[0]);
        int inputM = Integer.parseInt(input[1]);

        hi(inputN,inputM);
        bw.flush();
        bw.close();
        br.close();
    }
    static void hi(int n, int m){
        if (m == 0) return;

        for(int k =0;k<m;k++){
            hi(n,m-1);
        }


    }

}
