package bakjoon.dynamicprogrmmingalgorithm;

import java.io.*;
// 피보나치 함수
public class BakJoon1003 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] array = new int[41];

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;
        for (int i = 0; i < testCase; i++) {
            int input = Integer.parseInt(br.readLine());
            fibonacci(input);
            if (input == 0) {
                bw.write(1 + " " + 0 + "\n");
            } else if (input == 1) {
                bw.write(0 + " " + 1 + "\n");
            } else {
                bw.write(array[input - 1] + " " + array[input] + "\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static int fibonacci(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (array[n] != 0) {
            return array[n];
        }
        return array[n] = fibonacci(n - 1) + fibonacci(n - 2);


    }
}
