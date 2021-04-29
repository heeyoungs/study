package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로봇 시뮬레이션
public class BakJoon2174 {
    static class Robot {
        int x;
        int y;
        int force;
        int robotNum;

        Robot(int x, int y, int force, int robotNum) {
            this.x = x;
            this.y = y;
            this.force = force;
            this.robotNum = robotNum;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1}; // 동북서남 -> 좌회전

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int[][] area = new int[width + 1][height + 1];

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 로봇의 개수
        int M = Integer.parseInt(st.nextToken()); // 로봇의 명령 순서
        Robot[] robots = new Robot[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char force = st.nextToken().charAt(0);
            if (force == 'E') {
                robots[i] = new Robot(x, y, 0, i);
            } else if (force == 'N') {
                robots[i] = new Robot(x, y, 3, i);
            } else if (force == 'W') {
                robots[i] = new Robot(x, y, 2, i);
            } else if (force == 'S') {
                robots[i] = new Robot(x, y, 1, i);
            }
            area[x][y] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int whatRobot = Integer.parseInt(st.nextToken());
            char whatDo = st.nextToken().charAt(0);
            int count = Integer.parseInt(st.nextToken());

            for (int j = 0; j < count; j++) {
                Robot nowRobot = robots[whatRobot];
                int nowX = nowRobot.x;
                int nowY = nowRobot.y;
                if (whatDo == 'L') {
                    nowRobot.force = (nowRobot.force + 3) % 4;
                } else if (whatDo == 'R') {
                    nowRobot.force = (nowRobot.force + 1) % 4;
                } else if (whatDo == 'F') {
                    int nextX = nowX + dx[nowRobot.force];
                    int nextY = nowY + dy[nowRobot.force];
                    // 벽에 충돌
                    if (nextX < 1 || nextY < 1 || nextX > width || nextY > height) {
                        System.out.println("Robot " + whatRobot + " crashes into the wall");
                        return;
                    }
                    // 다른 로봇에 충돌
                    if (area[nextX][nextY] != 0) {
                        System.out.println("Robot " + whatRobot + " crashes into robot " + area[nextX][nextY]);
                        return;
                    }
                    // 전진
                    else {
                        area[nextX][nextY] = whatRobot;
                        area[nowX][nowY] = 0;
                        nowRobot.x = nextX;
                        nowRobot.y = nextY;
                    }
                }
            }
        }
        System.out.println("OK");
    }
}
