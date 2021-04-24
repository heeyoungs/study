package bakjoon.bintreealgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 상근이의 여행
public class BakJoon9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for (int test = 0; test < testCase; test++) {

            st = new StringTokenizer(br.readLine());
            int countryNum = Integer.parseInt(st.nextToken()); // 노드 개수
            int planeNum = Integer.parseInt(st.nextToken());
            for (int i = 0; i < planeNum; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
            } // 필요 없음

            sb.append((countryNum - 1) + "\n");
        }
        System.out.print(sb);
    }
}
