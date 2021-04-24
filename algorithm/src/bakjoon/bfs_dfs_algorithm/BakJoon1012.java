package bakjoon.bfs_dfs_algorithm;

import java.io.*;
// 유기농 배추
public class BakJoon1012 {
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1}; // x좌표
    static int[] dy = {1, 0, -1, 0}; // y좌표 -> 북,동,남,서 순서
    static int width;
    static int height;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int run = 0; run < testCase; run++) {

            String[] input = br.readLine().split(" ");
            width = Integer.parseInt(input[0]); // 가로
            height = Integer.parseInt(input[1]); // 세로
            int number = Integer.parseInt(input[2]); // 배추의 개수

            arr = new int[width][height];
            for (int i = 0; i < number; i++) { // 배추 심기
                input = br.readLine().split(" ");
                int xPoint = Integer.parseInt(input[0]);
                int yPoint = Integer.parseInt(input[1]);
                arr[xPoint][yPoint] = 1;
            }

            bw.write(insectCount() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int insectCount() {
        int count = 0;
        for (int i = 0; i < width; i++) { // 밭을 돌면서 배추 제거
            for (int j = 0; j < height; j++) {
                if (arr[i][j] == 1) { // 만약 제거가 시작됐다면
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int x, int y) { // 깊이 탐색
        arr[x][y] = 0; // 방문한 곳의 배추 삭제
        for (int i = 0; i < 4; i++) { // 동서남북
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < width && ny < height) { // nx와 ny의 체크
                if (arr[nx][ny] == 1) { // 배추가 심어져 있으면 -> 재귀
                    dfs(nx, ny);
                }
            }
        }
    }
}
