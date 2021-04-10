package bakjoon.greedyalgorithm;

import java.io.*;

public class BakJoon10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputNum = Integer.parseInt(br.readLine());

        int countA = 0;
        int countB = 0;
        int countC = 0;

        countA = inputNum / 300;

        inputNum = inputNum % 300;

        countB = inputNum / 60;

        inputNum = inputNum % 60;

        countC = inputNum / 10;

        inputNum = inputNum % 10;

        if(inputNum != 0){
            System.out.println(-1);
        } else{
            System.out.println(countA + " " + countB + " " + countC);
        }
    }
}
