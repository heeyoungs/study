package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class programmers {
    public static void main(String[] args) throws IOException {
        int[][] input = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};

        System.out.println(solution(input));
    }

    public static int solution(int[][] board) throws IOException {
        class PointXY {
            int x;
            int y;
            int count;

            PointXY(int x, int y, int count) {
                this.x = x;
                this.y = y;
                this.count = count;
            }
        }
        int width = board[0].length;
        int height = board.length;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1}; // 3-> 남 4-> 북
        boolean[][] visit = new boolean[width][height];

        Queue<PointXY> queue1 = new LinkedList<>();
        queue1.add(new PointXY(0, 0, -1));
        visit[0][0] = true;
        int answer = 0;
        int nx, ny, checkX, checkY;
        while (!queue1.isEmpty()) {
            PointXY check = queue1.poll();
            if (check.x == width - 1 && check.y == height - 1) {
                answer = check.count;
                break;
            }

            for (int force = 0; force < 4; force++) { // 동서남북방문 체크
                nx = check.x + dx[force];
                ny = check.y + dy[force];
                if (force == 2) {
                    checkX = check.x - 1; // 왼쪽아래
                    checkY = check.y - 1;
                } else if (force == 3) {
                    checkX = check.x - 1; // 오른쪽 아래
                    checkY = check.y + 1;
                }
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;

                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    queue1.add(new PointXY(nx, ny, check.count + 1));
                }
            }
        }
        return answer;
    }
}
