package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
// 미로 만들기
public class BakJoon2665 {
    static int N;
    static boolean[][] visit;
    static int[][] miro;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int Ans = 0;

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int breakCount;

        Point(int x, int y, int breakCount) {
            this.x = x;
            this.y = y;
            this.breakCount = breakCount;
        }


        @Override
        public int compareTo(Point o) {
            return breakCount- o.breakCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        miro = new int[N][N];
        for (int h = 0; h < N; h++) {
            String input = br.readLine();
            for (int w = 0; w < N; w++) {
                miro[w][h] = input.charAt(w) - '0';
            }
        } // 0벽 1길

        dijkstra(0,0);

        System.out.println(Ans);
    }

    static void dijkstra(int x,int y){
        visit = new boolean[N][N];
        visit[0][0] = true;
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(0,0,0));
        while(!PQ.isEmpty()){
            Point check = PQ.poll();
            int nowX = check.x;
            int nowY = check.y;
            int nowBreak = check.breakCount;

            if (nowX == N-1 && nowY == N-1){
                Ans = nowBreak;
                break;
            }

            for(int i=0;i<4;i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || visit[nextX][nextY]) continue;

                if (miro[nextX][nextY] == 1){
                    visit[nextX][nextY] = true;
                    PQ.add(new Point(nextX,nextY,nowBreak));
                }else if (miro[nextX][nextY] == 0){
                    visit[nextX][nextY] = true;
                    PQ.add(new Point(nextX,nextY,nowBreak+1));
                }
            }
        }
    }
}
