package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 알고스팟
public class BakJoon1261 {
    static int width;
    static int height;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] area;
    static boolean[][] visit;

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int breakWall;

        Point(int x, int y, int breakWall) {
            this.x = x;
            this.y = y;
            this.breakWall = breakWall;
        }


        @Override
        public int compareTo(Point o) {
            return breakWall - o.breakWall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        area = new int[width][height];
        visit = new boolean[width][height];
        for (int h = 0; h < height; h++) {
            String line = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = line.charAt(w) - '0';
            }
        }
        dijkstra_break();
    }
    static void dijkstra_break(){
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(0,0,0));
        visit[0][0] = true;
        while(!PQ.isEmpty()){
            Point check = PQ.poll();
            if (check.x == width-1 && check.y == height - 1){
                System.out.println(check.breakWall);
                return;
            }

            for(int i=0;i<4;i++){
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height || visit[nx][ny])continue;
                visit[nx][ny] = true;
                if (area[nx][ny] == 1){
                    PQ.add(new Point(nx,ny, check.breakWall +1));
                }else if (area[nx][ny] == 0){
                    PQ.add( new Point(nx,ny, check.breakWall));
                }
            }
        }
    }
}
