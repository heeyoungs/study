package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 뿌요 뿌요
public class BakJoon11559 {
    static char[][] area;
    static int[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int totalCount = -1;
    static boolean isPuyo = true;
    static int areaNum;
    static Stack<Integer> check = new Stack<>();
    static Stack<Character>[] line = new Stack[6];

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
        area = new char[6][12];
        for (int h = 0; h < 12; h++) {
            String input = br.readLine();
            for (int w = 0; w < 6; w++) {
                area[w][h] = input.charAt(w);
            }
        }

        for (int i = 0; i < 6; i++) {
            line[i] = new Stack<>();
        }

        while (isPuyo) {
            visit = new int[6][12];
            areaNum = 1;
            isPuyo = false;

            // 지울 곳 위치확인
            for (int h = 0; h < 12; h++) {
                for (int w = 0; w < 6; w++) {
                    if (area[w][h] != '.' && visit[w][h] == 0) {
                        bfs(w, h, area[w][h]);
                    }
                }
            }

            // 터뜨리기
            while (!check.isEmpty()) {
                int delNum = check.pop();
                for (int h = 0; h < 12; h++) {
                    for (int w = 0; w < 6; w++) {
                        if (visit[w][h] == delNum) {
                            area[w][h] = '.';
                        }
                    }
                }
            }

            // 맵 초기화
            for(int h=0;h<12;h++){
                for(int w=0;w<6;w++){
                    if (area[w][h] != '.') {
                        line[w].push(area[w][h]);
                    }
                }
            }

            // 아래칸 메꾸기
            for (int h = 11; h >= 0; h--) {
                for (int w = 0; w < 6; w++) {
                    char k = '.';
                    if (!line[w].isEmpty()){
                        k = line[w].pop();
                    }
                    area[w][h] = k;
                }
            }

            totalCount++;
        }
        System.out.println(totalCount);
    }

    static void bfs(int x, int y, char k) {
        Queue<Point> queue = new LinkedList<>();
        visit[x][y] = areaNum;
        queue.add(new Point(x, y));
        int count = 0;
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= 6 || ny >= 12 || visit[nx][ny] != 0) continue;

                if (area[nx][ny] == k) {
                    visit[nx][ny] = areaNum;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        if (count >= 4) {
            check.push(areaNum);
            isPuyo = true;
        }
        areaNum++;
    }
}
