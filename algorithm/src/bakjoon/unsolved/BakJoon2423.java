package bakjoon.unsolved;

import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.*;

// 전구를 켜라
public class BakJoon2423 {
    static int width, height;
    static char[][] area;
    static boolean[][] visit;
    static int[] dx = {1, -1, 1, -1};
    static int[] dy = {1, -1, -1, 1};
    static int[] dx2 = {1, 0, -1, 0};
    static int[] dy2 = {0, -1, 0, 1};

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {
            return count - o.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new char[width][height];
        visit = new boolean[width][height];
        for (int h = 0; h < height; h++) {
            String line = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = line.charAt(w);
            }
        }

        dijkstra();

        System.out.println("NO SOLUTION");
    }

    static void dijkstra() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        if (area[0][0] == '/') {
            PQ.add(new Point(0, 0, 1));
            area[0][0] = '\\';
        } else if (area[0][0] == '\\') {
            PQ.add(new Point(0, 0, 0));
        }

        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (visit[now.x][now.y]) continue;
            visit[now.x][now.y] = true;

            if (now.x == width -1 && now.y == height-1) {
                if (area[now.x][now.y] == '/') System.out.println("NO SOLUTION");
                else System.out.println(now.count);
                System.exit(0);
            }

            if (area[now.x][now.y] == '/') {
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                    if (area[nx][ny] == '/') {
                        PQ.add(new Point(nx, ny, now.count));
                    } else if (area[nx][ny] == '\\') {
                        PQ.add(new Point(nx, ny, now.count + 1));
                        area[nx][ny] = '/';
                    }
                }
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx2[i];
                    int ny = now.y + dy2[i];
                    if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                    if (area[nx][ny] == '/') {
                        PQ.add(new Point(nx, ny, now.count + 1));
                        area[nx][ny] = '\\';
                    } else if (area[nx][ny] == '\\') {
                        PQ.add(new Point(nx, ny, now.count));
                    }
                }
            } else if (area[now.x][now.y] == '\\') {
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                    if (area[nx][ny] == '/') {
                        PQ.add(new Point(nx, ny, now.count + 1));
                        area[nx][ny] = '\\';
                    } else if (area[nx][ny] == '\\') {
                        PQ.add(new Point(nx, ny, now.count));
                    }
                }
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx2[i];
                    int ny = now.y + dy2[i];
                    if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                    if (area[nx][ny] == '/') {
                        PQ.add(new Point(nx, ny, now.count));
                    } else if (area[nx][ny] == '\\') {
                        PQ.add(new Point(nx, ny, now.count + 1));
                        area[nx][ny] = '/';
                    }
                }
            }
        }
    }
}
