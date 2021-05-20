package bakjoon.simulationalgorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미친 아두이노
public class BakJoon8972 {
    static int height, width;
    static char[][] area;
    static int[][] visit;
    static int[] dx = {1000, -1, 0, 1, -1, 0, 1, -1, 0, 1};
    static int[] dy = {1000, 1, 1, 1, 0, 0, 0, -1, -1, -1};

    static Queue<Point> madArduino = new LinkedList<>();
    static Point arduino;

    static class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (Math.abs(x - arduino.x) + Math.abs(y - arduino.y) < Math.abs(o.x - arduino.x) + Math.abs(o.y - arduino.y)) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new char[width][height];
        for (int h = 0; h < height; h++) {
            String line = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = line.charAt(w);
                if (area[w][h] == 'I') {
                    arduino = new Point(w, h);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        String move = br.readLine();
        for (int i = 0; i < move.length(); i++) {
            visit = new int[width][height];
            boolean saveArduino;
            // 아두이노 위치 이동
            int moveArduinoPoint = move.charAt(i);
            saveArduino = moveArduino(moveArduinoPoint - '0');
            if (!saveArduino) {
                System.out.println("kraj " + (i+1));
                return;
            }
            // 미친 아두이노 위치 이동
            // 1. 미친 아두이노 전부 큐에 넣기
            whereMadArduino();
            // 2. 미친 아두이노 움직이기
            saveArduino = moveMadArduino();
            if (!saveArduino) {
                System.out.println("kraj " + (i+1));
                return;
            }

            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    if (visit[w][h] == 1){
                        area[w][h] = 'R';
                    }else if (w == arduino.x && h == arduino.y){
                        area[w][h] = 'I';
                    }
                }
            }
        }

        //아두이노가 살아남았으면 출력
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                sb.append(area[w][h]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean moveArduino(int moveArduinoPoint) {
        area[arduino.x][arduino.y] = '.';
        if (area[arduino.x + dx[moveArduinoPoint]][arduino.y + dy[moveArduinoPoint]] == 'R')
            return false;
        area[arduino.x + dx[moveArduinoPoint]][arduino.y + dy[moveArduinoPoint]] = 'I';
        arduino = new Point(arduino.x + dx[moveArduinoPoint], arduino.y + dy[moveArduinoPoint]);
        return true;
    }

    static void whereMadArduino() {
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (area[w][h] == 'R') {
                    madArduino.add(new Point(w, h));
                } else if (area[w][h] == 'r') {
                    area[w][h] = '.';
                }
            }
        }
    }

    static boolean moveMadArduino() {
        while (!madArduino.isEmpty()) {
            Point check = madArduino.poll();

            Point force = getForce(check.x, check.y);
            area[check.x][check.y] = '.';
            if (area[check.x + force.x][check.y + force.y] == 'I')
                return false;
            visit[check.x + force.x][check.y + force.y]++;
        }
        return true;
    }

    static Point getForce(int x, int y) {
        Point force = new Point(1000, 1000);
        if (x > arduino.x) {
            force.x = -1;
        } else if (x < arduino.x) {
            force.x = 1;
        } else {
            force.x = 0;
        }

        if (y > arduino.y) {
            force.y = -1;
        } else if (y < arduino.y) {
            force.y = 1;
        } else {
            force.y = 0;
        }
        return force;
    }
}
