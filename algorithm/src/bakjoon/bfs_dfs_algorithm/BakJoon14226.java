package bakjoon.bfs_dfs_algorithm;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

// 이모티콘
public class BakJoon14226 {
    static class Point {
        int count;
        int pt;
        int clipBoard;

        Point(int count, int pt, int clipBoard) {
            this.count = count;
            this.pt = pt;
            this.clipBoard = clipBoard;
        }
    }

    static boolean[][] visit;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visit = new boolean[10000][10000];
        bfs();
    }

    static void bfs() {
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(0, 1, 0));
        while (!Q.isEmpty()) {
            Point check = Q.poll();
            if (check.pt == N) {
                System.out.println(check.count);
                return;
            }

            for (int i = 0; i < 3; i++) {
                // 1 클립보드에 저장
                if (i == 0) {
                    if (visit[check.pt][check.pt]) continue;
                    visit[check.pt][check.pt] = true;
                    Q.add(new Point(check.count + 1, check.pt, check.pt));
                }
                // 2 붙여넣기
                else if (i == 1) {
                    if (check.pt + check.clipBoard > 1001 || visit[check.pt + check.clipBoard][check.clipBoard])
                        continue;
                    visit[check.pt + check.clipBoard][check.clipBoard] = true;
                    Q.add(new Point(check.count + 1, check.pt + check.clipBoard, check.clipBoard));
                }
                // 3 삭제
                else {
                    if (check.pt -1 < 0 || visit[check.pt - 1][check.clipBoard]) continue;
                    visit[check.pt - 1][check.clipBoard] = true;
                    Q.add(new Point(check.count + 1, check.pt - 1, check.clipBoard));
                }
            }
        }
    }
}
