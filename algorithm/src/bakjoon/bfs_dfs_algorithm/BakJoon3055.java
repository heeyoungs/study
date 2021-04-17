package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BakJoon3055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        char[][] area = new char[width][height];
        boolean[][] visit = new boolean[width][height];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Point end = null; // 도착 지점!!
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < height; i++) { // 땅 초기화
            String input = br.readLine();
            for (int j = 0; j < width; j++) {
                area[j][i] = input.charAt(j);
                if (input.charAt(j) == 'D') { // 도착 지점 설정
                    end = new Point(j, i, 0, 'D');
                } else if (input.charAt(j) == '*') { // 물
                    queue.add(new Point(j, i, 0, '*')); // 물 먼저 인큐
                }
            }
        }

        Out:
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (area[j][i] == 'S') { // 고슴도치
                    queue.add(new Point(j, i, 0, 'S')); // 고슴도치 인큐
                    visit[j][i] = true;
                    break Out;
                }
            }
        }

        // bfs
        int ans = 0;
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            if (check.who == 'S' && check.x == end.x && check.y == end.y) { // 고숨도치가 도착했을 때
                ans = check.count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < width && ny < height && !visit[nx][ny]) {
                    if (check.who == 'S') { // 고슴 도치
                        if (area[nx][ny] == '.' || area[nx][ny] == 'D' && !visit[nx][ny]) {
                            queue.add(new Point(nx, ny, check.count + 1, 'S'));
                            visit[nx][ny] = true;
                        }
                    } else if (check.who == '*' && area[nx][ny] == '.') { // 물
                        if (area[nx][ny] == '.') {
                            area[nx][ny] = '*';
                            queue.add(new Point(nx, ny, 0, '*'));
                        }
                    }
                }
            }
        }

        if (ans == 0) {
            bw.write("KAKTUS");
        } else {
            bw.write(ans + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int x;
        int y;
        int count;
        char who;

        Point(int x, int y, int count, char who) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.who = who;
        }
    }
}
