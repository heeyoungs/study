package bakjoon.recursivealgorithm;

import java.io.*;
// 별 찍기 10
public class BakJoon2447 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int inputNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < inputNum; i++) {
            for (int j = 0; j < inputNum; j++) {
                print(i, j, inputNum);
            }
            bw.write("\n");
        }
        bw.flush();bw.close();br.close();
    }

    static void print(int i, int j, int num) throws IOException {
        if ((i / num) % 3 == 1 && (j / num) % 3 == 1) {
            bw.write(" " );
        } else {
            if (num / 3 == 0) {
                bw.write("*");
            } else {
                print(i,j,num/3);
            }
        }
    }
}
