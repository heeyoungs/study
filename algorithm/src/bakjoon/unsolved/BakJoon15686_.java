package bakjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 치킨 배달
public class BakJoon15686_ {
    static int[][] area;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int ans = 0;
    static int N;
    static int[][] chickenPoint;

    static class Point {
        int x;
        int y;
        int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 크기
        int M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 치킨집의 최대 수 -> 도시에 M개의 치킨 집 존재
        int chickenHouseCount = 0; // 도시의 총 치킨집의 수
        area = new int[N][N]; // 지도 할당
        chickenPoint = new int[N][N]; // 치킨 집의 위치를 찍어줄 배열

        for (int h = 0; h < N; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < N; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
                if (area[w][h] == 2) {
                    chickenHouseCount++;
                    chickenPoint[w][h] = chickenHouseCount;
                    area[w][h] = 0;
                }
            }
        } // 지도 설정

//        for(int i = 0;i<N;i++){
//            for(int j=0;j<N;j++) {
//                System.out.print(chickenPoint[j][i] + " ");
//            }
//            System.out.println();
//        }

        int tt = Combine(chickenHouseCount, M);

        for (int t = 0; t < tt; t++) { // 경우의 수만큼 반복
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    //if ()
                    for (int h = 0; h < N; h++) {
                        for (int w = 0; w < N; w++) {
                            if (area[w][h] == 1) { // 집일 경우 bfs -> 최소 거리의 치킨집을 찾아
                                bfs(w, h);
                            }
                        }
                    } // 각 집들의 치킨 거리
                }
            }
        }
        System.out.print(ans);
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));
        visit = new boolean[N][N];
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            if (area[check.x][check.y] == 2) { // 최단 거리의 치킨집을 찾음
                ans = ans + check.count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    queue.add(new Point(nx, ny, check.count + 1));
                }
            }
        }
    } // 집에서 가장 가까운 치킨집을 찾는 함수

    static int Combine(int x, int y) {
        int ret = 1;
        for (int i = 1; i <= x; i++) {
            ret = ret * i;
        }
        for (int i = 1; i <= y; i++) {
            ret = ret / i;
        }
        for (int i = 1; i <= x - y; i++) {
            ret = ret / i;
        }
        return ret;
    }
}
// 접근 방식 -> 현재 치킨집 개수 C 최대 치킨집 개수 -> 조합 만큼 치킨 집을 세우고 지우고 반복