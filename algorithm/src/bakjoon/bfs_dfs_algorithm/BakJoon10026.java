package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
// 적록 색약
public class BakJoon10026 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int lineCount;
    static int[][] area;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
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

        lineCount = Integer.parseInt(br.readLine());
        area = new int[lineCount][lineCount];
        visit = new boolean[lineCount][lineCount];

        for (int h = 0; h < lineCount; h++) {
            String input = br.readLine();
            for (int w = 0; w < lineCount; w++) { // r-1,g-0,b-(-1)
                if (input.charAt(w) == 'R') {
                    area[w][h] = -1;
                } else if (input.charAt(w) == 'G') {
                    area[w][h] = 0;
                } else if (input.charAt(w) == 'B') {
                    area[w][h] = 1;
                }
            }
        }
        int normalCount = 0;
        int stupidCount = 0;
        for(int i=0;i<lineCount;i++){
            for(int j=0;j<lineCount;j++){
                if (visit[j][i] == false){
                    if (area[j][i] == 0) {
                        bfsG(new Point(j, i));
                    } else if (area[j][i] == -1){
                        bfsR(new Point(j,i));
                    } else if (area[j][i] == 1){
                        bfsB(new Point(j,i));
                    }
                    normalCount++;
                }
            }
        }
        visit = new boolean[lineCount][lineCount];
        for(int i=0;i<lineCount;i++){
            for(int j=0;j<lineCount;j++){
                if(visit[j][i] == false){
                    if (area[j][i] == 0 || area[j][i] == -1){
                        bfsRG(new Point(j,i));
                    } else if (area[j][i] == 1){
                        bfsB(new Point(j,i));
                    }
                    stupidCount++;
                }
            }
        }
        bw.write(normalCount + " " + stupidCount + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfsG(Point k){
        Queue<Point> queue = new LinkedList<>();
        queue.add(k);
        visit[k.x][k.y] = true;

        while(!queue.isEmpty()){
            Point check = queue.poll();
            for(int force = 0;force<4;force++){
                int nx = check.x +dx[force];
                int ny = check.y + dy[force];
                if (nx<0 || ny <0 || nx>=lineCount || ny>= lineCount) continue;

                if (!visit[nx][ny] && area[nx][ny] == 0){
                    queue.add(new Point(nx,ny));
                    visit[nx][ny] = true;
                }
            }
        }
    }

    static void bfsR(Point k){
        Queue<Point> queue = new LinkedList<>();
        queue.add(k);
        visit[k.x][k.y] = true;

        while(!queue.isEmpty()){
            Point check = queue.poll();
            for(int force = 0;force<4;force++){
                int nx = check.x +dx[force];
                int ny = check.y + dy[force];
                if (nx<0 || ny <0 || nx>=lineCount || ny>= lineCount) continue;

                if (!visit[nx][ny] && area[nx][ny] == -1){
                    queue.add(new Point(nx,ny));
                    visit[nx][ny] = true;
                }
            }
        }
    }

    static void bfsB(Point k) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(k);
        visit[k.x][k.y] = true;

        while (!queue.isEmpty()) {
            Point check = queue.poll();
            for (int force = 0; force < 4; force++) {
                int nx = check.x + dx[force];
                int ny = check.y + dy[force];
                if (nx < 0 || ny < 0 || nx >= lineCount || ny >= lineCount) continue;

                if (!visit[nx][ny] && area[nx][ny] == 1) {
                    queue.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
    }

    static void bfsRG(Point k){
        Queue<Point> queue = new LinkedList<>();
        queue.add(k);
        visit[k.x][k.y] = true;

        while(!queue.isEmpty()){
            Point check = queue.poll();
            for(int force = 0;force<4;force++){
                int nx = check.x +dx[force];
                int ny = check.y + dy[force];
                if (nx<0 || ny <0 || nx>=lineCount || ny>= lineCount) continue;

                if (!visit[nx][ny] && (area[nx][ny] == 0 || area[nx][ny] == -1)){
                    queue.add(new Point(nx,ny));
                    visit[nx][ny] = true;
                }
            }
        }
    }
}
