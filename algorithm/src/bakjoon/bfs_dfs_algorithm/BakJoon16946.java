package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.*;
// 벽 부수고 이동하기 4
public class BakJoon16946 {
    static boolean[][] visit;
    static int[][] area;
    static int[][] areaNumCheck;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int height;
    static int width;
    static int areaNumCount = 2;

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
        StringBuilder sb = new StringBuilder();
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        areaNumCheck = new int[width][height];
        visit = new boolean[width][height];
        area = new int[width][height];
        for (int h = 0; h < height; h++) {
            String input = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = input.charAt(w) - '0';
            }
        } // 땅 초기화

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (area[w][h] == 0 && !visit[w][h]) {
                    bfs(w, h);
                }
            }
        } // bfs

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (area[w][h] == 1) { // 벽이였을 경우 -> 4방향의 0을 중첩안되게 더해준다.
                    int sum = 1;
                    HashSet<Integer> check = new HashSet<>();
                    for (int i = 0; i < 4; i++) {
                        int nx = w + dx[i];
                        int ny = h + dy[i];

                        if (nx >= 0 && ny >= 0 && nx < width && ny < height && !check.contains(area[nx][ny]) && area[nx][ny] != 1) {
                            sum += map.get(area[nx][ny]);
                            check.add(area[nx][ny]);
                        }
                    }
                    sb.append(sum % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
    static int countZero;
    static HashMap<Integer,Integer> map = new HashMap<>();
    static void bfs(int x, int y) { // 0의 개수를 세어주면서 영역 번호를 세겨주자
        // 0의 갯수 세어주기
        visit[x][y] = true;
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));
        countZero = 0;
        while (!Q.isEmpty()) {
            Point check = Q.poll();
            countZero++;
            area[check.x][check.y] = areaNumCount;

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < width && ny < height && !visit[nx][ny] && area[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    Q.add(new Point(nx, ny));
                }
            }
        }
        map.put(areaNumCount,countZero);
        areaNumCount++;
    }
}

/*
1. 0이 시작하는 부분에서 bfs 로 인접한 0의 개수를 세어준다.
2. 1을 기준으로 사방에 위치한 0의 개수를 영역이 중복되지 않게 더해준다.
 */
