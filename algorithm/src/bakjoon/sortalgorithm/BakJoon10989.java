package bakjoon.sortalgorithm;

import java.io.*;
// 수 정렬하기 3
public class BakJoon10989 { // 버퍼 reader 와 버퍼 write 둘다 써야 시간 초과가 안뜬다.
    public static void main(String[] args) throws IOException {
        int[] arraySum = new int[10001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < inputNum; i++) {
            int input = Integer.parseInt(br.readLine());
            arraySum[input - 1]++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 10001; i++) {
            for (int j = 0; j < arraySum[i]; j++) {
                bw.write((i+1) + "\n");
            }
        }
        bw.flush();bw.close();
    }
}
