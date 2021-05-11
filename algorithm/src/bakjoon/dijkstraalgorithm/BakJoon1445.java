package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 일요일 아침의 데이트
public class BakJoon1445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        char[][] area = new char[width][height];
        for(int h=0;h<height;h++){
            String input = br.readLine();
            for(int w=0;w<width;w++){
                area[w][h] = input.charAt(w);
                if (area[w][h] == 'S'){
                    start = new Point(w,h,0,0);
                }
                if (area[w][h] == 'F'){
                    end = new Point(w,h);
                }
            }
        }
        dijkstra(height,width,area);
        System.out.print(ans1 + " " + ans2);
    }
    static int ans1 = Integer.MAX_VALUE;
    static int ans2 = Integer.MAX_VALUE;

    static void dijkstra(int height,int width,char[][] area){
        boolean[][] visit = new boolean[width][height];
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(start);
        visit[start.x][start.y] = true;
        while(!queue.isEmpty()){
            Point check = queue.poll();
            //System.out.println(check.x + " " + check.y);
            if (check.x == end.x && check.y == end.y){
                ans1 = check.trashThroughCount;
                ans2 = check.trashAroundCount;
                return;
            }

            for(int i=0;i<4;i++){
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (visit[nx][ny]) continue;
                if (area[nx][ny] == 'g'){
                    queue.add(new Point(nx,ny,check.trashThroughCount + 1,check.trashAroundCount));
                    visit[nx][ny] = true;
                }else if (area[nx][ny] == '.'){
                    int istrashAround = 0;
                    for(int j=0;j<4;j++){
                        int nnx = nx + dx[j];
                        int nny = ny + dy[j];
                        if (nnx < 0 || nny < 0 || nnx >= width || nny >= height)continue;
                        if (area[nnx][nny] == 'g') {
                            istrashAround = 1;
                        }
                    }
                    queue.add(new Point(nx,ny,check.trashThroughCount,check.trashAroundCount + istrashAround));
                    visit[nx][ny] = true;
                }else if (area[nx][ny] == 'F'){
                    queue.add(new Point(nx,ny, check.trashThroughCount, check.trashAroundCount));
                }
            }
        }
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int trashThroughCount;
        int trashAroundCount;

        Point(int x,int y,int trashThroughCount,int trashAroundCount){
            this.x = x;
            this.y = y;
            this.trashThroughCount = trashThroughCount;
            this.trashAroundCount = trashAroundCount;
        }

        Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o){
            if (trashThroughCount > o.trashThroughCount){
                return 1;
            }else if (trashThroughCount < o.trashThroughCount){
                return -1;
            }else{
                if (trashAroundCount > o.trashAroundCount){
                    return 1;
                }else {
                    return -1;
                }
            }
        }
    }

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static Point start;
    static Point end;
}