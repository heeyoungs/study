package bakjoon.simulationalgorithm;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BakJoon14503_ {
    static int count = 0;
    static boolean[][] visit;
    static int[][] area;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, -1};
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

        visit = new boolean[width][height];
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
        Stack<Point> stack = new Stack<>();
        stack.push(start);
        visit[start.x][start.y] = true;
        count++;
        while (!stack.isEmpty()) {
            Point check = stack.pop();
            // 현재 청소기의 방향을 확인
            int nx = -1;
            int ny = -1;
            int i;
            for (i = 0; i < 4; i++) {
                nx = check.x + (dx[i] + check.force) % 4;
                ny = check.y + (dy[i] + check.force) % 4; // 보고 있는 방향을 기준으로 왼쪽부터 차례대로 확인
                if (nx>=0 && ny >=0 && nx < width && ny < height && !visit[nx][ny] && area[nx][ny] == 0) {
                    // 지도안이거나 방문했던 경우 제외 벽 제외
                    break;
                } else{
                    nx = -1;
                    ny = -1;
                }
            }
            if(nx == -1 && ny == -1) { // 사방이 다 청소되거나 벽인 경우
                if(area[nx - dx[check.force]][ny - dy[check.force]] == 1){
                    break;
                }
                stack.push(new Point(nx - dx[check.force],ny - dy[check.force], check.force + 2));
            }else{ // 청소할 구역이 있엇던 경우
                visit[nx][ny] = true;
                count++;
                stack.push(new Point(nx,ny,i));
            }

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
