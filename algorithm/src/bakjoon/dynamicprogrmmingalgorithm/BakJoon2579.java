package bakjoon.dynamicprogrmmingalgorithm;

import java.io.*;
// 계단 오르기
public class BakJoon2579 {
    static int[][] d = new int[301][3];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 1; i <= count; i++) {
            int score = Integer.parseInt(br.readLine());
            d[i][0] = Math.max(d[i - 1][1], d[i - 1][2]);
            d[i][1] = d[i-1][0] + score;
            d[i][2] = d[i-1][1] + score;
        }
        System.out.println(Math.max(d[count][1],d[count][2]));
    }
}
