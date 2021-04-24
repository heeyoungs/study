package bakjoon.greedyalgorithm;

import java.io.*;
// 설탕 배달
public class BakJoon2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputNum = Integer.parseInt(br.readLine());

        int ans = 0;
        int count = inputNum / 5;
        ans = ans + count;
        inputNum = inputNum % 5;

        if (inputNum == 0) {
            bw.write(ans + "");
        }

        else if (inputNum == 1) {
            if (count > 0) {
                ans = ans + 1;
                bw.write(ans + "");
            } else {
                bw.write("-1\n");
            }
        }

        else if (inputNum == 2) {
            if (count > 1) {
                ans = ans + 2;
                bw.write(ans + "");
            } else {
                bw.write("-1\n");
            }

        } else if (inputNum == 3) {
            ans = ans + 1;
            bw.write(ans + "");
        }

        else if (inputNum == 4) {
            if (count > 0) {
                ans = ans + 2;
                bw.write(ans + "");
            } else {
                bw.write("-1\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
