package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 구슬 탈출 3
public class BakJoon15644 {
    static int height, width;
    static Point end;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int Ans = Integer.MAX_VALUE;
    static StringBuilder sb;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        Point red = null, blue = null;
        char[][] area = new char[width][height];
        for (int h = 0; h < height; h++) {
            String input = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = input.charAt(w);
                if (area[w][h] == 'B') {
                    blue = new Point(w, h);
                } else if (area[w][h] == 'R') {
                    red = new Point(w, h);
                } else if (area[w][h] == 'O') {
                    end = new Point(w, h);
                }
            }
        }
        StringBuilder ansArray = new StringBuilder();
        // 맵, red, blue 위치 현재 깊이
        combine(area, red, blue, 0,ansArray);
        if (Ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Ans);
            System.out.println(sb);
        }
    }

    static void combine(char[][] area, Point red, Point blue, int depth,StringBuilder ansArray) {
        if (depth == 10 || depth >= Ans ) {
            return;
        }

        Out:
        for (int force = 0; force < 4; force++) {
            char[][] copyArea = new char[width][height];
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    copyArea[w][h] = area[w][h];
                }
            }
            Point copyRed = new Point(red.x, red.y);
            Point copyBlue = new Point(blue.x, blue.y);
            StringBuilder copyArray = new StringBuilder();
            copyArray.append(ansArray);
            if (force == 0){
                copyArray.append("R");
            }else if (force == 1){
                copyArray.append("U");
            }else if (force == 2){
                copyArray.append("L");
            }else {
                copyArray.append("D");
            }
            boolean goal = false;
            // 여기까지 복사
            // 이동처리! 3번해주면 끝까지 가겟쬬?
            Stack<Point> stack = new Stack<>();
            // 먼저 빨강 이동
            stack.push(new Point(copyRed.x, copyRed.y));
            copyArea[copyRed.x][copyRed.y] = '.';
            while (!stack.isEmpty()) {
                Point check = stack.pop();
                int nx = check.x + dx[force];
                int ny = check.y + dy[force];
                if (copyArea[nx][ny] == 'B' || copyArea[nx][ny] == '#') {
                    copyArea[check.x][check.y] = 'R';
                    copyRed = new Point(check.x, check.y);
                } else if (copyArea[nx][ny] == 'O') {
                    goal = true;
                } else if (copyArea[nx][ny] == '.') {
                    stack.push(new Point(nx, ny));
                }
            }

            // 파랑 이동
            stack.push(new Point(copyBlue.x, copyBlue.y));
            copyArea[copyBlue.x][copyBlue.y] = '.';
            while (!stack.isEmpty()) {
                Point check = stack.pop();
                int nx = check.x + dx[force];
                int ny = check.y + dy[force];
                if (copyArea[nx][ny] == 'R' || copyArea[nx][ny] == '#') {
                    copyArea[check.x][check.y] = 'B';
                    copyBlue = new Point(check.x, check.y);
                } else if (copyArea[nx][ny] == 'O') {
                    continue Out;
                } else if (copyArea[nx][ny] == '.') {
                    stack.push(new Point(nx, ny));
                }
            }

            // 빨강 이동
            stack.push(new Point(copyRed.x, copyRed.y));
            copyArea[copyRed.x][copyRed.y] = '.';
            while (!stack.isEmpty()) {
                Point check = stack.pop();
                int nx = check.x + dx[force];
                int ny = check.y + dy[force];
                if (copyArea[nx][ny] == 'B' || copyArea[nx][ny] == '#') {
                    copyArea[check.x][check.y] = 'R';
                    copyRed = new Point(check.x, check.y);
                } else if (copyArea[nx][ny] == '.') {
                    stack.push(new Point(nx, ny));
                }
            }

            if (goal) {
                Ans = Math.min(Ans, depth + 1);
                sb = copyArray;
            }
            if ((copyRed.x == red.x && copyRed.y == red.y) && (copyBlue.x == blue.x && copyBlue.y == blue.y)) { // 가만히 있는 경우
                continue;
            }
            // 재귀
            combine(copyArea, copyRed, copyBlue, depth + 1,copyArray);
        }
    }
}
