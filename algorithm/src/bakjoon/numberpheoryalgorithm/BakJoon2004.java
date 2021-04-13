package bakjoon.numberpheoryalgorithm;

import java.io.*;

public class BakJoon2004 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        long n = Integer.parseInt(input[0]);
        long m = Integer.parseInt(input[1]);

        if (m == 0 || n == m) {
            System.out.println(0);
            return;
        }

        long countOfTwo = 0;
        long countOfFive = 0;

        for (long i = 2; i <= n; i = i * 2) {
            countOfTwo = countOfTwo + n / i;
        }
        for (long i = 5; i <= n; i = i * 5) {
            countOfFive = countOfFive + n / i;
        }
        for (long i = 2; i <= m; i = i * 2) {
            countOfTwo = countOfTwo - m / i;
        }
        for (long i = 5; i <= m; i = i * 5) {
            countOfFive = countOfFive - m / i;
        }
        for (long i = 2; i <= n - m; i = i * 2) {
            countOfTwo = countOfTwo - (n-m) / i;
        }
        for (long i = 5; i <= n - m; i = i * 5) {
            countOfFive = countOfFive - (n-m) / i;
        }

        long answer;
        if (countOfTwo > countOfFive) {
            answer = countOfFive;
        } else {
            answer = countOfTwo;
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

