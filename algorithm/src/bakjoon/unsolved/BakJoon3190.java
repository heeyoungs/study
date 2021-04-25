package bakjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BakJoon3190 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1}; // 오른쪽 , 위쪽, 왼쪽, 아래쪽순서
    static int force = 0;// L-> i증가 R -> i감소
    static int totalMinute = 0;
    static int[][] area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 칸의 높넓이
        int K = Integer.parseInt(br.readLine()); // 사과의 개수
        area = new int[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            area[x - 1][y - 1] = 1;
        }
        // 사과의 위치 1 그냥 위치 0
        int L = Integer.parseInt(br.readLine()); // 뱀의의방향 변환 횟수
        for (int i = 0; i < L; i++) {
            String[] input = br.readLine().split(" ");
            int changeTime = Integer.parseInt(input[0]); // 몇 초후 종료
            String k = input[1];
            char force = k.charAt(0); // 방향
        }


    }
}
