package bakjoon.topologysort;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 복제 로봇
public class BakJoon1944 {
    static int N, M;
    static char[][] area;
    static boolean[][] visit;
    static int[] parent;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static PriorityQueue<Point> PQ = new PriorityQueue<>();

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int weight;

        Point(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return weight - o.weight;
        }
    }

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new char[N][N];

        for (int h = 0; h < N; h++) {
            String input = br.readLine();
            for (int w = 0; w < N; w++) {
                area[w][h] = input.charAt(w);
                if (area[w][h] == '1') {
                    area[w][h] = '*';
                }
            }
        }

        Queue<Point> Q = new LinkedList<>();
        parent = new int[M + 2];
        for (int i = 1; i <= M + 1; i++) {
            parent[i] = i;
        }

        int count = 1;
        for (int h = 0; h < N; h++) {
            for (int w = 0; w < N; w++) {
                if (area[w][h] == 'S' || area[w][h] == 'K') {
                    area[w][h] = (char) (count + '0');
                    count++;
                    // 정점 다 Q에 넣기
                    Q.add(new Point(w, h, -1));
                }
            }
        }

        // 모든 거리 구해서 PQ에 넣기
        while (!Q.isEmpty()) {
            Point now = Q.poll();
            bfs(now.x, now.y);
        }

        int ans = 0;
        while(!PQ.isEmpty()){
            Point check = PQ.poll();

            if (!findParent(check.x,check.y)){
                unionParent(check.x,check.y);
                ans += check.weight;
            }
        }

        boolean isUnion = true;
        for(int i=1;i<=M+1;i++){
            if (getParent(i) != 1) isUnion = false;
        }
        if (isUnion)System.out.println(ans);
        else System.out.println(-1);
    }

    static void bfs(int x, int y) {
        visit = new boolean[N][N];
        int startPoint = area[x][y] - '0';
        visit[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));
        while (!queue.isEmpty()) {
            Point check = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (area[nx][ny] == '*') continue;
                if (visit[nx][ny]) continue;
                if (area[nx][ny] == '0'){
                    visit[nx][ny] = true;
                    queue.add(new Point(nx,ny,check.weight + 1));
                }else {
                    int endPoint = area[nx][ny] - '0';
                    PQ.add(new Point(startPoint,endPoint,check.weight + 1));
                    visit[nx][ny] = true;
                    queue.add(new Point(nx,ny,check.weight + 1));
                }
            }
        }

    }
}
