//package bakjoon.bfs_dfs_algorithm;
//
//import java.io.*;
//import java.util.StringTokenizer;
//
//public class BakJoon16946 {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static int[][] check;
//    static boolean[][] visit;
//    static String[] line;
//    static int[] dx = {0, 0, 1, -1};
//    static int[] dy = {1, -1, 0, 0};
//    static int height;
//    static int width;
//
//    public static void main(String[] args) throws IOException {
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        height = Integer.parseInt(st.nextToken());
//        width = Integer.parseInt(st.nextToken());
//
//        check = new int[width][height];
//        visit = new boolean[width][height];
//        line = new String[height];
//        for (int h = 0; h < height; h++) {
//            line[h] = br.readLine();
//        }
//
//        for (int h = 0; h < height; h++) {
//            for (int w = 0; w < width; w++) {
//                if (line[h].charAt(w) == '0' && check[w][h] == 0) {
//                    dfs(w, h);
//                }
//            }
//        }
//    }
//
//    static void dfs(int x, int y) {
//        int count = 0;
//        visit[x][y] = true;
//        for (int i = 0; i < 4; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//            if (nx >= 0 && ny >= 0 && nx < width && ny < height && !visit[x][y]) {
//                dfs(nx,ny);
//                count++;
//            }
//        }
//    }
//
//    static class Point {
//        int x;
//        int y;
//
//        Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//}
