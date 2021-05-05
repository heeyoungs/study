package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 청소년 상어
public class BakJoon19236 {
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1}; // 반시계 45
    static int Ans = 0;

    static class Shark {
        int x;
        int y;
        int force;
        int point;

        Shark(int x, int y, int force, int point) {
            this.x = x;
            this.y = y;
            this.force = force;
            this.point = point;
        }
    }

    static class NumForce {
        int num;
        int force;

        NumForce(int num, int force) {
            this.num = num;
            this.force = force;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NumForce area[][] = new NumForce[4][4];
        for (int h = 0; h < 4; h++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int w = 0; w < 4; w++) {
                int num = Integer.parseInt(st.nextToken());
                int force = Integer.parseInt(st.nextToken()) - 1;
                area[w][h] = new NumForce(num, force);
            }
        }
        Shark nowShark = new Shark(0, 0, 0, 0);
        nowShark.force = area[0][0].force;
        nowShark.point = area[0][0].num;
        boolean[] eatCheck = new boolean[17];
        eatCheck[0] = true;
        eatCheck[area[0][0].num] = true;
        // 상어의 시작 위치를 정해줌
        area[0][0] = new NumForce(-1, -1);
        movefish(area, eatCheck);
        dfs(nowShark, area, eatCheck);
        System.out.println(Ans);
    }

    static void dfs(Shark nowShark, NumForce[][] area, boolean[] eatCheck) {
        // 일단 먹기
        Ans = Math.max(Ans, nowShark.point);
        int x = nowShark.x;
        int y = nowShark.y;
        int force = nowShark.force;
        for (int i = 1; i < 4; i++) {
            NumForce[][] copyArea = new NumForce[4][4];
            for (int h = 0; h < 4; h++) {
                for (int w = 0; w < 4; w++) {
                    copyArea[w][h] = area[w][h];
                }
            }
            // 자기 방향 확인해보기
            int nx = x + dx[force] * i;
            int ny = y + dy[force] * i;
            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue; // 외곽인 경우
            if (copyArea[nx][ny].num != 0) {
                // 물고기가 있으면
                boolean[] copyEatCheck = new boolean[17];
                for (int t = 0; t < 17; t++) {
                    copyEatCheck[t] = eatCheck[t];
                }
                copyEatCheck[area[nx][ny].num] = true;

                Shark nextShark = new Shark(nx, ny, area[nx][ny].force, nowShark.point + area[nx][ny].num);
                copyArea[nx][ny] = new NumForce(-1, -1); // 먹기
                copyArea[x][y] = new NumForce(0, 0); // 자리 비우기

                movefish(copyArea, copyEatCheck); // 물고기의 이동

                dfs(nextShark, copyArea, copyEatCheck); // 재귀
            }
        }
    }

    static void movefish(NumForce[][] area, boolean[] eatCheck) {
        for (int i = 1; i <= 16; i++) {
            if (eatCheck[i]) continue;
            Out:
            for (int h = 0; h < 4; h++) {
                for (int w = 0; w < 4; w++) {
                    if (area[w][h].num == i) {
                        // 물고기의 이동
                        int force = area[w][h].force;
                        for (int f = 0; f < 8; f++) {

                            int nx = w + dx[(f + force) % 8];
                            int ny = h + dy[(f + force) % 8];

                            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue; // 외곽
                            if (area[nx][ny].num == -1) continue; // 상어

                            if (area[nx][ny].num == 0) { // 빈공간 -> 이동 후 끝
                                area[nx][ny] = new NumForce(i, (f + force) % 8);
                                area[w][h] = new NumForce(0, 0);
                            } else { // 물고기 -> 둘이 교환
                                NumForce temp = new NumForce(area[nx][ny].num, area[nx][ny].force);
                                area[nx][ny] = new NumForce(i, (f + force) % 8);
                                area[w][h] = temp;
                            }
                           // System.out.println(i + " " + (f + force));
                            break Out;
                        }
                    }
                }
            }
        }
    }
}
