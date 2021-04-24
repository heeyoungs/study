package bakjoon.numberpheoryalgorithm;

import java.io.*;
// 팩토리얼 0의 개수
public class BakJoon1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputNum = Integer.parseInt(br.readLine());

        int countOfTwo = 0;
        int countOfFive = 0;
        for (int i = 0; i <= inputNum; i++) {
            int t = i;
            while (true) {
                if (t % 2 == 0 && t != 0) {
                    countOfTwo++;
                    t = t / 2;
                } else if (t % 5 == 0 && t != 0) {
                    countOfFive++;
                    t = t / 5;
                } else {
                    break;
                }
            }
        }

        int count;
        if (countOfTwo > countOfFive){
            count = countOfFive;
        } else {
            count = countOfTwo;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}