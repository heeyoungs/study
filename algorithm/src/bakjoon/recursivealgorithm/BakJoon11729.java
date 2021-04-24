package bakjoon.recursivealgorithm;

import java.io.*;
// 하노이 탑 이동 순서
public class BakJoon11729 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int inputNum = Integer.parseInt(br.readLine());

        int ans = (int)Math.pow(2,inputNum)-1;
        bw.write(ans + "\n");
        hanoi(inputNum, '1', '2', '3');
        bw.flush();bw.close();br.close();
    }

    static int move = 0;

    static void hanoi(int n, char from, char temp, char to) throws IOException {
        if (n == 1) {
            bw.write(from + " " + to + "\n");
        } else {
            hanoi(n - 1, from, to, temp);
            bw.write(from + " " + to + "\n");
            hanoi(n - 1, temp, from, to);
        }
    }
}
