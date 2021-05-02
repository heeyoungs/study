package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 상범 빌딩
public class BakJoon6593 {
    static int floor, height, width;
    static boolean[][][] visit;
    static char[][][] area;
    static int dx[] = {0, 0, 0, 0, 1, -1};
    static int dy[] = {0, 0, 1, -1, 0, 0};
    static int dz[] = {1, -1, 0, 0, 0, 0};
    static Point start = null;
    static Point end = null;
    static StringBuilder sb = new StringBuilder();

    static class Point {
        int x;
        int y;
        int z;
        int count;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        Point(int x, int y, int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            floor = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            if (floor == height && height == width && width == 0) break;
            area = new char[width][height][floor];
            visit = new boolean[width][height][floor];
            for (int f = 0; f < floor; f++) {
                for (int h = 0; h < height; h++) {
                    String line = br.readLine();
                    for (int w = 0; w < width; w++) {
                        area[w][h][f] = line.charAt(w);
                        if (area[w][h][f] == 'S') {
                            start = new Point(w, h, f);
                        } else if (area[w][h][f] == 'E') {
                            end = new Point(w, h, f);
                        }
                    }
                }String p = br.readLine();
            }
            bfs();
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start.x, start.y, start.z, 0));
        visit[start.x][start.y][start.z] = true;
        while (!queue.isEmpty()) {
            Point check = queue.poll();
            if (check.x == end.x && check.y == end.y && check.z == end.z) {
                sb.append("Escaped in ").append(check.count).append(" minute(s).").append("\n");
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                int nz = check.z + dz[i];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= width || ny >= height || nz >= floor) continue;

                if (!visit[nx][ny][nz] && area[nx][ny][nz] != '#') {
                    visit[nx][ny][nz] = true;
                    queue.add(new Point(nx, ny, nz, check.count + 1));
                }

            }
        }
        sb.append("Trapped!").append("\n");
    }
}
