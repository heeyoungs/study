package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BakJoon16236 {
    static int N;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static final int FORCE = 4;
    static int[][] area;
    static boolean[][] visit;
    static int moveCount = 0; // 총 이동 횟수
    static int eatCount = 0; // 먹은 물고기 수
    static boolean findFish = true; // 물고기를 찾았나?
    static Point nowSharkPoint = null; // 상어의 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 좌우 크기
        area = new int[N][N];
        for (int h = 0; h < N; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < N; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
                if (area[w][h] == 9) {
                    nowSharkPoint = new Point(w, h, 2, 0);
                    area[w][h] = 0;
                }
            }
        }
        // 공간 할당 -> 1,2,3,4,5,6 물고기 / 0 빈칸 / 9 아기 상어!! -> 아기 상어의 디폴트 크기 2
        while (findFish) {
            bfs(nowSharkPoint);
        }
        System.out.print(moveCount);
    }

    // 가장 가까운 물고기를 먹는다! -> 그 위치를 시작 지점으로 설정한다. -> 거기서 또 아기 상어가 먹이를 찾는다 반복!
    static void bfs(Point start) {
        findFish = false;
        Queue<Point> queue = new LinkedList<>();
        visit = new boolean[N][N]; // 방문체크 배열
        visit[start.x][start.y] = true; // 현재 위치 체크
        queue.add(start); // 현재 아기 상어의 위치를 넣음
        int distance = Integer.MAX_VALUE;
        boolean findDistance = false;
        boolean[][] findPoint = new boolean[N][N];
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            int nowX = check.x;
            int nowY = check.y;
            int sharkBig = check.shark; // 상어의 현재 크기

            if (!findDistance && area[nowX][nowY] < sharkBig && area[nowX][nowY] != 0) { // 처음 먹이를 만났을 때
                distance = check.count;
                findDistance = true;
                findPoint[nowX][nowY] = true;
            }

            if (distance == check.count && area[nowX][nowY] < sharkBig && area[nowX][nowY] != 0) { // 그 후 먹이를 만날때마다 위치 체크
                findPoint[nowX][nowY] = true;
            }
            if (distance < check.count){
                break;
            }

            for (int force = 0; force < FORCE; force++) {
                int nx = nowX + dx[force];
                int ny = nowY + dy[force]; // 탐색
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) { // 범위 안에 있을 경우
                    if (area[nx][ny] <= sharkBig && area[nx][ny] >= 0 && !visit[nx][ny]) { // 상어의 크기와 같거나 작고 방문 안한 곳
                        visit[nx][ny] = true;
                        queue.add(new Point(nx, ny, check.shark, check.count + 1));
                    }
                }
            }
        }
        for (int h = 0; h < N; h++) {
            for (int w = 0; w < N; w++) {
                if (findPoint[w][h]){
                    moveCount = moveCount + distance; // 전체 이동횟수에 더해준다.
                    findFish = true; // 물고기를 찾았다!
                    area[w][h] = 0; // 물고기를 먹었다!
                    eatCount++; // 먹은 횟수 증가!
                    if (eatCount == start.shark) {
                        nowSharkPoint = new Point(w, h, start.shark + 1, 0); // 상어 크기를 증가시켜서 저장
                        eatCount = 0;
                    } else if (eatCount < start.shark) {
                        nowSharkPoint = new Point(w, h, start.shark, 0); // 먹이를 찾은 위치 저장
                    }
                    return;
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int shark;
        int count;

        Point(int x, int y, int shark, int count) {
            this.x = x;
            this.y = y;
            this.shark = shark;
            this.count = count;
        }
    }
}
