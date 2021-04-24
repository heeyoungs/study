package bakjoon.unsolved;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 로봇 청소기
public class BakJoon14503_ {
    static int count = 0;
    static int[][] area;
    static int[] dx = {-1, 0,1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int height;
    static int width;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken()); // 높이
        width = Integer.parseInt(st.nextToken()); // 가로

        st = new StringTokenizer(br.readLine());
        int cleanerY = Integer.parseInt(st.nextToken()); // 청소기 y좌표
        int cleanerX = Integer.parseInt(st.nextToken()); // 청소기 x좌표
        int force = Integer.parseInt(st.nextToken()); // 청소기 보고 잇는 방향 -> 0 북 1 동 2 남 3 서

        area = new int[width][height];
        for (int h = 0; h < height; h++) { // 초기화 확인
            String[] input = br.readLine().split(" ");
            for (int w = 0; w < width; w++) {
                area[w][h] = Integer.parseInt(input[w]);
            }
        }

        dfs(new Point(cleanerX, cleanerY, force));

        bw.write(count + ""); // 답 출력
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
       area[start.x][start.y] = -1;
        count++; // 자기위치 + 1

        Out:
        while (!q.isEmpty()) {
            Point check = q.poll();

            for(int h=0;h<height;h++){
                for(int w=0;w<width;w++){
                    System.out.print(area[w][h] + " ");
                }
                System.out.println();
            }
            System.out.println();
            // 현재 청소기의 방향을 확인
            int i; // 왼쪽,뒤쪽,으론쪽,앞쪽을 차례대로 탐색
            for (i = 0; i < 4; i++) {
                int nx = check.x + (dx[(i + check.force) % 4]);
                int ny = check.y + (dy[(i + check.force) % 4]); // 보고 있는 방향을 기준으로 왼쪽부터 차례대로 확인
                if (nx >= 0 && ny >= 0 && nx < width && ny < height && area[nx][ny] == 0) {
                    // 지도안이거나 방문했던 경우 제외 벽 제외 + 청소할 곳을 찾음
                    q.add(new Point(nx, ny, (i + check.force) % 4));
                    count++; // 그곳으로 가서 청소
                    area[nx][ny] = -1;
                    continue Out;
                }
            }
            // 청소할 곳을 못찾음!
            if (area[check.x - dx[(check.force + 3) % 4]][check.y - dy[(check.force + 3) % 4]] == 1) { // 뒤쪽이 벽
                break;
            } // 뒤쪽이 벽 아님 -> 후진
            q.add(new Point(check.x - dx[(check.force + 3) % 4], check.y - dy[(check.force + 3) % 4], check.force));

        }


    }

    static class Point {
        int x;
        int y;
        int force;

        Point(int x, int y, int force) {
            this.x = x;
            this.y = y;
            this.force = force;
        }
    }
}
