package bakjoon.floydwarshallalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 플로이드 2
public class BakJoon11780 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] area = new int[N + 1][N + 1];
        mem = new int[N + 1][N + 1];
        for (int h = 1; h <= N; h++) {
            for (int w = 1; w <= N; w++) {
                area[w][h] = Integer.MAX_VALUE / 2;
                if (w == h) {
                    area[w][h] = 0;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            area[start][end] = Math.min(weight, area[start][end]);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i == k) continue;
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k) continue;
                    if (area[i][j] > area[i][k] + area[k][j]) {
                        area[i][j] = area[i][k] + area[k][j];
                        mem[i][j] = k;
                    }
                }
            }
        }
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(mem[i][j] + " ");
//            }
//            System.out.println();
//        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (area[i][j] == Integer.MAX_VALUE / 2) {
                    sb.append(0 + " ");
                } else {
                    sb.append(area[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j || area[i][j] == Integer.MAX_VALUE / 2) {
                    sb.append(0).append("\n");
                    continue;
                }
                queue.add(i); // 끝점
                Path(i,j);
                queue.add(j); // 시작점
                sb.append(queue.size() +" ");
                while(!queue.isEmpty()){
                    sb.append(queue.poll() + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    static Queue<Integer> queue = new LinkedList<>();
    static int[][] mem;
    static void Path(int start,int end){
        if (mem[start][end] == 0){
            return;
        }
        int path = mem[start][end];
        Path(start,path);
        queue.add(path);
        Path(path,end);
    }
}
