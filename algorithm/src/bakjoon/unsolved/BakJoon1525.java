package bakjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퍼즐
public class BakJoon1525 {
    static int[][] area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        area = new int[3][3];
        for (int h = 0; h < 3; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < 3; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
