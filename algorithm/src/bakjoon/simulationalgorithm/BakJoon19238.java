package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 스타트 택시
public class BakJoon19238 {
    static int N, M, Gas;
    static Point flagPoint;
    static int[][] area;
    static boolean[][] visit;
    static boolean fail = false;
    static int customNum = -1;
    static HashMap<Integer, Point> hashMap = new HashMap<>();
    static Point texi;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static class Point {
        int x;
        int y;
        int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 넓이
        M = Integer.parseInt(st.nextToken()); // 태울 승객의 수
        Gas = Integer.parseInt(st.nextToken()); // 가스
        area = new int[N + 1][N + 1];
        for (int h = 1; h <= N; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 1; w <= N; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int texiY = Integer.parseInt(st.nextToken());
        int texiX = Integer.parseInt(st.nextToken());
        texi = new Point(texiX, texiY);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int customY = Integer.parseInt(st.nextToken());
            int customX = Integer.parseInt(st.nextToken());
            area[customX][customY] = customNum;
            int flagY = Integer.parseInt(st.nextToken());
            int flagX = Integer.parseInt(st.nextToken());
            hashMap.put(customNum, new Point(flagX, flagY));
            customNum--;
        }

        while (hashMap.size() != 0) {
            bfs1(texi.x, texi.y); // 손님 찾기 bfs
            if (fail) {
                System.out.println(-1);
                return;
            }
            bfs2(texi.x, texi.y); // 목적지 찾기 bfs
            if (fail) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(Gas);
    }

    // 여기서 오류
    static void bfs1(int x, int y) {
        Point checkPoint = null;
        int dist = -1;
        boolean distCheck = false;

        Queue<Point> queue = new LinkedList<>();
        visit = new boolean[N + 1][N + 1];
        visit[x][y] = true;
        queue.add(new Point(x, y, 0));
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            if (area[check.x][check.y] != 0 && dist == check.count && distCheck) { // 그 이후로 만났을 때
                if (check.y < checkPoint.y) {
                    checkPoint = new Point(check.x, check.y);
                } else if (check.y == checkPoint.y){
                    if (check.x < checkPoint.x) {
                        checkPoint = new Point(check.x, check.y);
                    }
                }
                //System.out.println(checkPoint.x + " " + checkPoint.y);
            }

            if (area[check.x][check.y] != 0 && !distCheck) { // 처음 만났을 때
                dist = check.count;
                distCheck = true;
                checkPoint = new Point(check.x, check.y);
            }

            if (distCheck && dist < check.count ) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if (area[nx][ny] != 1 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    queue.add(new Point(nx, ny, check.count + 1));
                }
            }
        }
        if (distCheck) {
            Gas = Gas - dist;
            if (Gas <= 0) {
                fail = true;
                return;
            }
            Point flag = hashMap.get(area[checkPoint.x][checkPoint.y]);
            flagPoint = new Point(flag.x, flag.y); // 목적지
            hashMap.remove(area[checkPoint.x][checkPoint.y]);
            area[checkPoint.x][checkPoint.y] = 0;
            // 택시 위치 재설정
            texi = new Point(checkPoint.x, checkPoint.y);
            return;
        }
        // 손님에게 못가면
        fail = true;
    }

    static void bfs2(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        visit = new boolean[N + 1][N + 1];
        visit[x][y] = true;
        queue.add(new Point(x, y, 0));

        while (!queue.isEmpty()) {
            Point check = queue.poll();
            if (check.x == flagPoint.x && check.y == flagPoint.y) {
                Gas = Gas - check.count;
                // 연료 바닥났을 시
                if (Gas < 0) {
                    fail = true;
                    return;
                }
                Gas = Gas + check.count * 2;
                // 택시 위치 재설정
                texi = new Point(check.x, check.y);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if (!visit[nx][ny] && area[nx][ny] != 1) {
                    visit[nx][ny] = true;
                    queue.add(new Point(nx, ny, check.count + 1));
                }
            }
        }
        // 목적지에 못가면
        fail = true;
    }
}
