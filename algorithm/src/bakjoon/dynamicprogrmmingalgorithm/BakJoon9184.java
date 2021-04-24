package bakjoon.dynamicprogrmmingalgorithm;

import java.io.*;
import java.util.StringTokenizer;
// 신나는 함수 실행
public class BakJoon9184 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            int ans;
            if (a <= 0 || b <= 0 || c <= 0) {
                ans = 1;
            }else if (a > 20 || b > 20 || c > 20){
                ans = w(20,20,20);
            }else {
                ans = w(a,b,c);
            }
            bw.write("w(" + a + ", " + b + ", " + c + ") = " + ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int[][][] d = new int[21][21][21];

    static int w(int a, int b, int c) {
        if (d[a][b][c] != 0){
            return d[a][b][c];
        }
        if (a <= 0 || b <= 0 || c <= 0) { // 종료조건
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return d[20][20][20] = w(20,20,20);
        }
        if (a < b && b < c) {
            d[a][b][c] = w(a,b,c-1) + w(a,b - 1,c - 1) - w(a,b - 1,c);
            return d[a][b][c];
        }
        d[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
        return d[a][b][c];
    }
}