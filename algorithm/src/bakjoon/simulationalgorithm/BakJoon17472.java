package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다리 만들기 2
public class BakJoon17472 {
    static int height, width;
    static int[][] area;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int mapCount = 1;
    static int[] parent;
    static PriorityQueue<DistOfIsland> distPQ = new PriorityQueue<>();

    static int getParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

    static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }

    static boolean findParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) return true;
        else return false;
    }

    static class DistOfIsland implements Comparable<DistOfIsland> {
        int x;
        int y;
        int dist;

        DistOfIsland(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(DistOfIsland o) {
            return dist - o.dist;
        }
    }

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
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new int[width][height];
        for (int h = 0; h < height; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < width; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }
        // 1단계 섬의 번호를 체크해 주자
        visit = new boolean[width][height];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (visit[w][h]) continue;
                if (area[w][h] == 1) {
                    bfs(w, h);
                }
            }
        }
        // 유니온파인드 1단계 부모 설정
        parent = new int[mapCount];
        for (int i = 1; i < mapCount; i++) {
            parent[i] = i;
        }
        // 각 섬들끼리의 직선상 최단 거리 구해주기
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (area[w][h] != 0) {
                    dfs1(w, h); // 동
                    dfs2(w, h); // 북
                    dfs3(w, h); // 서
                    dfs4(w, h); // 남
                }
            }
        }

        // 최소신장트리
        int ans = 0;
        while (!distPQ.isEmpty()) {
            DistOfIsland check = distPQ.poll();
            int x = check.x;
            int y = check.y;
            int dist = check.dist;
            if (dist < 2) continue;
            //System.out.println(x + " " +  y + " " + dist);
            if (!findParent(x, y)) {
                unionParent(x, y);
                ans += dist;
            }
        }

        // 간선이 다 안이어져있으면면
       for (int i = 1; i < mapCount; i++) {
            if (getParent(i) != 1)
                ans = -1;
        }

        System.out.println(ans);
    }

    static void dfs1(int x, int y) { // 동 서 남 북 나누자 -> 동 dfs
        Stack<Point> stack = new Stack<>();
        int startIsland = area[x][y];
        int endIsland = -1;
        int dist = 0;
        if (x + dx[0] < 0 || y + dy[0] < 0 || x + dx[0] >= width || y + dy[0] >= height) return;
        stack.push(new Point(x + dx[0], y + dy[0]));
        while (!stack.isEmpty()) {
            Point check = stack.pop();
            if (area[check.x][check.y] == startIsland) {
                return;
            }
            if (area[check.x][check.y] != 0) {
                endIsland = area[check.x][check.y];
                break;
            }

            int nx = check.x + dx[0];
            int ny = check.y + dy[0];
            if (nx < 0 || ny < 0 || nx >= width || ny >= height) {
                return;
            }
            stack.push(new Point(nx, ny));
            dist++;
        }
        distPQ.add(new DistOfIsland(startIsland, endIsland, dist));
    }

    static void dfs2(int x, int y) { // 동 서 남 북 나누자 -> 북 dfs
        Stack<Point> stack = new Stack<>();
        int startIsland = area[x][y];
        int endIsland = -1;
        int dist = 0;
        if (x + dx[1] < 0 || y + dy[1] < 0 || x + dx[1] >= width || y + dy[1] >= height) return;
        stack.push(new Point(x + dx[1], y + dy[1]));
        while (!stack.isEmpty()) {
            Point check = stack.pop();
            if (area[check.x][check.y] == startIsland) {
                return;
            }
            if (area[check.x][check.y] != 0) {
                endIsland = area[check.x][check.y];
                break;
            }

            int nx = check.x + dx[1];
            int ny = check.y + dy[1];
            if (nx < 0 || ny < 0 || nx >= width || ny >= height) {
                return;
            }
            stack.push(new Point(nx, ny));
            dist++;
        }
        distPQ.add(new DistOfIsland(startIsland, endIsland, dist));
    }

    static void dfs3(int x, int y) { // 동 서 남 북 나누자 -> 서 dfs
        Stack<Point> stack = new Stack<>();
        int startIsland = area[x][y];
        int endIsland = -1;
        int dist = 0;
        if (x + dx[2] < 0 || y + dy[2] < 0 || x + dx[2] >= width || y + dy[2] >= height) return;
        stack.push(new Point(x + dx[2], y + dy[2]));
        while (!stack.isEmpty()) {
            Point check = stack.pop();
            if (area[check.x][check.y] == startIsland) {
                return;
            }
            if (area[check.x][check.y] != 0) {
                endIsland = area[check.x][check.y];
                break;
            }

            int nx = check.x + dx[2];
            int ny = check.y + dy[2];
            if (nx < 0 || ny < 0 || nx >= width || ny >= height) {
                return;
            }
            stack.push(new Point(nx, ny));
            dist++;
        }
        distPQ.add(new DistOfIsland(startIsland, endIsland, dist));
    }

    static void dfs4(int x, int y) { // 동 서 남 북 나누자 -> 남 dfs
        Stack<Point> stack = new Stack<>();
        int startIsland = area[x][y];
        int endIsland = -1;
        int dist = 0;
        if (x + dx[3] < 0 || y + dy[3] < 0 || x + dx[3] >= width || y + dy[3] >= height) return;
        stack.push(new Point(x + dx[3], y + dy[3]));
        while (!stack.isEmpty()) {
            Point check = stack.pop();
            if (area[check.x][check.y] == startIsland) {
                return;
            }
            if (area[check.x][check.y] != 0) {
                endIsland = area[check.x][check.y];
                break;
            }

            int nx = check.x + dx[3];
            int ny = check.y + dy[3];
            if (nx < 0 || ny < 0 || nx >= width || ny >= height) {
                return;
            }
            stack.push(new Point(nx, ny));
            dist++;
        }
        distPQ.add(new DistOfIsland(startIsland, endIsland, dist));
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        area[x][y] = mapCount;
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (visit[nx][ny]) continue;
                if (area[nx][ny] == 1) {
                    area[nx][ny] = mapCount;
                    visit[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        mapCount++;
    }
}
