package bakjoon.dynamicprogrmmingalgorithm;

import java.io.*;
// 파도반 수열
public class BakJoon9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int input = Integer.parseInt(br.readLine());
            long ans = circle(input);
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static long[] d = new long[101];

    static long circle(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 1;
        }
        if (d[n] != 0) {
            return d[n];
        }
        return d[n] = circle(n - 2) + circle(n - 3);
    }
}
