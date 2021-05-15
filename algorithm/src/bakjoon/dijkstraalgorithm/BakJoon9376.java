package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 탈옥
public class BakJoon9376 {
    static char[][] area;
    static int[][] visitP1;
    static int[][] visitP2;
    static int[][] visitP0;
    static int height, width;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int totalOpenDoor = Integer.MAX_VALUE;

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int doorCount;
        int personNum;

        Point(int x, int y, int doorCount, int personNum) {
            this.x = x;
            this.y = y;
            this.doorCount = doorCount;
            this.personNum = personNum;
        }

        @Override
        public int compareTo(Point o) {
            return doorCount - o.doorCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            totalOpenDoor = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            height = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            area = new char[width + 2][height + 2];
            visitP1 = new int[width + 2][height + 2];
            visitP2 = new int[width + 2][height + 2];
            visitP0 = new int[width + 2][height + 2];
            for (int h = 0; h < height + 2; h++) {
                for (int w = 0; w < width + 2; w++) {
                    visitP0[w][h] = -1;
                    visitP1[w][h] = -1;
                    visitP2[w][h] = -1;
                }
            }

            int count = 1;
            PriorityQueue<Point> PQ = new PriorityQueue<>();
            visitP0[0][0] = 0;
            PQ.add(new Point(0, 0, 0, 0));
            for (int h = 1; h < height + 1; h++) {
                String input = br.readLine();
                for (int w = 0; w < width; w++) {
                    area[w + 1][h] = input.charAt(w);
                    if (area[w + 1][h] == '$' && count == 1) {
                        visitP1[w + 1][h] = 0;
                        PQ.add(new Point(w + 1, h, 0, count));
                        area[w + 1][h] = '.';
                        count++;
                    } else if (area[w + 1][h] == '$' && count == 2) {
                        visitP2[w + 1][h] = 0;
                        PQ.add(new Point(w + 1, h, 0, count));
                        area[w + 1][h] = '.';
                    }
                }
            }
            dijkstra(PQ);
//            for (int h = 0; h < height + 2; h++) {
//                for (int w = 0; w < width + 2; w++) {
//                    System.out.print(area[w][h]);
//                }
//                System.out.println();
//            }
            sb.append(totalOpenDoor).append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(PriorityQueue<Point> PQ) {
        while (!PQ.isEmpty()) {
            Point check = PQ.poll();
            //System.out.println(area[check.x][check.y] + " " + check.x + " " + check.y + check.doorCount);

            if (visitP0[check.x][check.y] != -1 && visitP1[check.x][check.y] != -1 && visitP2[check.x][check.y] != -1) {
                //System.out.println(area[check.x][check.y] + " " + check.x + " " + check.y);
                if (area[check.x][check.y] == '#') {
                    totalOpenDoor = Math.min(totalOpenDoor,visitP1[check.x][check.y] + visitP2[check.x][check.y] + visitP0[check.x][check.y] - 2);
                } else {
                    totalOpenDoor = Math.min(totalOpenDoor,visitP1[check.x][check.y] + visitP2[check.x][check.y] + visitP0[check.x][check.y]);
                }
            }


            for (int i = 0; i < 4; i++) {
                int num = check.personNum;
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx > width + 1 || ny > height + 1) continue;
                if (area[nx][ny] == '*') continue;

                if (num == 0) {
                    if (visitP0[nx][ny] != -1) continue;
                    if (area[nx][ny] == '#') {
                        PQ.add(new Point(nx, ny, check.doorCount + 1, check.personNum));
                        visitP0[nx][ny] = check.doorCount + 1;
                    } else {
                        PQ.add(new Point(nx, ny, check.doorCount, check.personNum));
                        visitP0[nx][ny] = check.doorCount;
                    }
                } else if (num == 1) {
                    if (visitP1[nx][ny] != -1) continue;
                    if (area[nx][ny] == '#') {
                        PQ.add(new Point(nx, ny, check.doorCount + 1, check.personNum));
                        visitP1[nx][ny] = check.doorCount + 1;
                    } else {
                        PQ.add(new Point(nx, ny, check.doorCount, check.personNum));
                        visitP1[nx][ny] = check.doorCount;
                    }
                } else if (num == 2) {
                    if (visitP2[nx][ny] != -1) continue;
                    if (area[nx][ny] == '#') {
                        PQ.add(new Point(nx, ny, check.doorCount + 1, check.personNum));
                        visitP2[nx][ny] = check.doorCount + 1;
                    } else {
                        PQ.add(new Point(nx, ny, check.doorCount, check.personNum));
                        visitP2[nx][ny] = check.doorCount;
                    }
                }
            }
        }
    }
}
