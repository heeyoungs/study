package bakjoon.dijkstraalgorithm;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 엔터프라이즈호 탈출
public class BakJoon9505 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] alpha = new int[26];
    static int[][] area;
    static int W,H;
    static Point start;
    static long ans;
    static StringBuilder sb = new StringBuilder();

    static class Point implements Comparable<Point> {
        int x;
        int y;
        long weight;

        Point(int x, int y, long weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return (int) (weight - o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            ans = Long.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                char Alpha = st.nextToken().charAt(0);
                int Num = Integer.parseInt(st.nextToken());
                alpha[Alpha - 'A'] = Num;
            }
            area = new int[W][H];
            for (int h = 0; h < H; h++) {
                String input = br.readLine();
                for (int w = 0; w < W; w++) {
                    area[w][h] = alpha[input.charAt(w) - 'A'];
                    if (input.charAt(w) - 'E' == 0) {
                        start = new Point(w, h, 0);
                    }
                }
            }

            dijkstra();

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(start);
        boolean[][] visit = new boolean[W][H];
        visit[start.x][start.y] = true;
        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= W || ny >= H) {
                    ans = Math.min(ans,now.weight);
                    continue;
                }
                if (visit[nx][ny]) continue;
                PQ.add(new Point(nx,ny,now.weight + area[nx][ny]));
                visit[nx][ny] = true;
            }
        }
    }
}
