package kakao;

import java.util.LinkedList;
import java.util.Queue;

public class programmers {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        solution(board);
        System.out.println(ans);
    }

    static class Point {
        int x;
        int y;
        int lastDirect;
        int count;

        Point(int x, int y, int lastDirect, int count) {
            this.x = x;
            this.y = y;
            this.lastDirect = lastDirect;
            this.count = count;
        }
    }

    static int N, ans = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] area;
    static boolean[][][] visit;

    static public int solution(int[][] board) {
        N = board.length;
        area = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1][4];
        for (int h = 1; h <= N; h++) {
            for (int w = 1; w <= N; w++) {
                area[w][h] = board[h - 1][w - 1];
            }
        }

        bfs();
        return ans;
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(2, 1, 0, 0));
        visit[2][1][0] = true;
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            System.out.println(check.x + " " + check.y + ":D-" + check.lastDirect + ":C-" + check.count);
            int nowDirect = check.lastDirect; // 마지막으로 온 방향
            // 종료조건
            if (check.x == N && check.y == N) {
                ans = check.count;
                return;
            }

            // 마지막으로 보고 있던 방향을 기준으로 분기를 나눔
            if (nowDirect == 0) { // 동
                for (int force = 0; force < 4; force++) {
                    if (force == 2) continue;
                    int nextX = check.x + dx[force];
                    int nextY = check.y + dy[force];
                    int nextCount = check.count + 1;

                    if (nextX < 1 || nextY < 1 || nextX > N || nextY > N || area[nextX][nextY] == 1)
                        continue; // 외곽또는 벽이면
                    if (visit[nextX][nextY][force]) continue; // 방문했었으면
                    visit[nextX][nextY][force] = true;

                    if (force == 1) { // 대각선 왼쪽 위 확인
                        if (check.x - 1 < 1 || check.y - 1 < 1) continue;
                        if (area[check.x - 1][check.y - 1] == 1) continue;
                    } else if (force == 3) { // 대각선 왼쪽 아래 확인
                        if (check.x - 1 < 1 && check.y + 1 > N) continue;
                        if (area[check.x - 1][check.y + 1] == 1) continue;
                    }
                    queue.add(new Point(nextX, nextY, force, nextCount));

                }
            } else if (nowDirect == 1) { // 북
                for (int force = 0; force < 4; force++) {
                    if (force == 3)continue;
                    int nextX = check.x + dx[force];
                    int nextY = check.y + dy[force];
                    int nextCount = check.count + 1;

                    if (nextX < 1 || nextY < 1 || nextX > N || nextY > N || area[nextX][nextY] == 1)
                        continue; // 외곽또는 벽이면
                    if (visit[nextX][nextY][force]) continue; // 방문했었으면
                    visit[nextX][nextY][force] = true;

                    if (force == 0) { // 오른쪽 아래
                        if (check.x + 1 > N || check.y + 1 > N) continue;
                        if (area[check.x + 1][check.y + 1] == 1) continue;
                    }
                    else if (force == 2) { // 왼쪽 아래
                        if (check.x - 1 < 1 || check.y + 1 > N) continue;
                        if (area[check.x - 1][check.y + 1] == 1) continue;
                    }
                    queue.add(new Point(nextX, nextY, force, nextCount));
                }
            } else if (nowDirect == 2) { // 서
                for (int force = 0; force < 4; force++) {
                    if (force == 0) continue;
                    int nextX = check.x + dx[force];
                    int nextY = check.y + dy[force];
                    int nextCount = check.count + 1;

                    if (nextX < 1 || nextY < 1 || nextX > N || nextY > N || area[nextX][nextY] == 1)
                        continue; // 외곽또는 벽이면
                    if (visit[nextX][nextY][force]) continue; // 방문했었으면
                    visit[nextX][nextY][force] = true;

                    if (force == 1) { // 대각선 오른쪽 위 확인
                        if (check.x + 1 > N || check.y - 1 < 1) continue;
                        if (area[check.x + 1][check.y - 1] == 1) continue;
                    }
                    else if (force == 3) { // 대각선 오른쪽 아래 확인
                        if (check.x + 1 > N || check.y - 1 < 1) continue;
                        if (area[check.x + 1][check.y - 1] == 1) continue;
                    }
                    queue.add(new Point(nextX, nextY, force, nextCount));
                }
            } else if (nowDirect == 3) { // 남
                for (int force = 0; force < 4; force++) {
                    if (force == 1)continue;
                    int nextX = check.x + dx[force];
                    int nextY = check.y + dy[force];
                    int nextCount = check.count + 1;

                    if (nextX < 1 || nextY < 1 || nextX > N || nextY > N || area[nextX][nextY] == 1)
                        continue; // 외곽또는 벽이면
                    if (visit[nextX][nextY][force]) continue; // 방문했었으면
                    visit[nextX][nextY][force] = true;

                    if (force == 0) { // 대각선 오른쪽 위 확인
                        if (check.x + 1 > N || check.y - 1 < 1) continue;
                        if (area[check.x + 1][check.y - 1] == 1) continue;
                    }
                    else if (force == 2) { // 대각선 왼쪽 위 확인
                        if (check.x - 1 < 1 || check.y - 1 < 1) continue;
                        if (area[check.x - 1][check.y - 1] == 1) continue;
                    }
                    queue.add(new Point(nextX, nextY, force, nextCount));
                }
            }
        }
    }
}
