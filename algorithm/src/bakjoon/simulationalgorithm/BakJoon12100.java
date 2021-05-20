package bakjoon.simulationalgorithm;

import java.io.*;
import java.util.StringTokenizer;

// 2048 (Easy)
public class BakJoon12100 {
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] area = new int[N][N];
        for (int h = 0; h < N; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < N; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, N, area);
        System.out.println(ans);
    }

    static void dfs(int depth, int N, int[][] area) {
        if (depth == 5) {
            for (int h = 0; h < N; h++) {
                for (int w = 0; w < N; w++) {
                    ans = Math.max(ans, area[w][h]);
                }
            }
            return;
        }


        for (int i = 0; i < 4; i++) {
            // 위 오른쪽 아래 왼쪽으로 밀어 붙이기
            int[][] copyArea = new int[N][N];
            for(int h=0;h<N;h++){
                for(int w=0;w<N;w++){
                    copyArea[w][h] = area[w][h];
                }
            }
            boolean[][] visit = new boolean[N][N];
            if (i == 0) {
                for (int w = 0; w < N; w++) {
                    for (int h = 1; h < N; h++) {
                        int nextCheck = h - 1;
                        int nowCheck = h;
                        while (nextCheck >= 0) {
                            if (visit[w][nextCheck]) break;
                            if (copyArea[w][nextCheck] == 0) {
                                copyArea[w][nextCheck] = copyArea[w][nowCheck];
                                copyArea[w][nowCheck] = 0;
                                nextCheck--;
                                nowCheck--;
                            }
                            // 같은 경우
                            else if (copyArea[w][nextCheck] == copyArea[w][nowCheck]) {
                                copyArea[w][nowCheck] = 0;
                                copyArea[w][nextCheck] *= 2;
                                visit[w][nextCheck] = true;
                                break;
                            }
                            // 다른 경우
                            else if (copyArea[w][nextCheck] != copyArea[w][nowCheck]) {
                                break;
                            }
                        }
                    }
                }
            } else if (i == 1) {
                for (int h = 0; h < N; h++) {
                    for (int w = 1; w < N; w++) {
                        int nextCheck = w - 1;
                        int nowCheck = w;
                        while (nextCheck >= 0) {
                            // 같은 경우
                            if (visit[nextCheck][h]) break;
                            // 0 인 경우
                            if (copyArea[nextCheck][h] == 0) {
                                copyArea[nextCheck][h] = copyArea[nowCheck][h];
                                copyArea[nowCheck][h] = 0;
                                nextCheck--;
                                nowCheck--;
                            } else if (copyArea[nextCheck][h] == copyArea[nowCheck][h]) {
                                copyArea[nowCheck][h] = 0;
                                copyArea[nextCheck][h] *= 2;
                                visit[nextCheck][h] = true;
                                break;
                            }

                            // 다른 경우
                            else if (copyArea[nextCheck][h] != copyArea[nowCheck][h]) {
                                break;
                            }
                        }
                    }
                }
            } else if (i == 2) {
                for (int w = 0; w < N; w++) {
                    for (int h = N - 2; h >= 0; h--) {
                        int nextCheck = h + 1;
                        int nowCheck = h;
                        while (nextCheck < N) {
                            if (visit[w][nextCheck]) break;
                            if (copyArea[w][nextCheck] == 0) {
                                copyArea[w][nextCheck] = copyArea[w][nowCheck];
                                copyArea[w][nowCheck] = 0;
                                nextCheck++;
                                nowCheck++;
                            } else if (copyArea[w][nextCheck] == copyArea[w][nowCheck]) {
                                copyArea[w][nowCheck] = 0;
                                copyArea[w][nextCheck] *= 2;
                                visit[w][nextCheck] = true;
                                break;
                            } else if (copyArea[w][nextCheck] != copyArea[w][nowCheck]) {
                                break;
                            }
                        }
                    }
                }
            } else if (i == 3){
                for (int h = 0; h < N; h++) {
                    for (int w = N - 2; w >= 0; w--) {
                        // 두 번째 줄부터 내려가면서 올려 치기
                        int nextCheck = w + 1;
                        int nowCheck = w;
                        while (nextCheck < N) {
                            // 같은 경우
                            if (visit[nextCheck][h]) break;// 0 인 경우
                            if (copyArea[nextCheck][h] == 0) {
                                copyArea[nextCheck][h] = copyArea[nowCheck][h];
                                copyArea[nowCheck][h] = 0;
                                nextCheck++;
                                nowCheck++;
                            } else if (copyArea[nextCheck][h] == copyArea[nowCheck][h]) {
                                copyArea[nowCheck][h] = 0;
                                copyArea[nextCheck][h] *= 2;
                                visit[nextCheck][h] = true;
                                break;
                            }
                            else if (copyArea[nextCheck][h] != copyArea[nowCheck][h]) {
                                break;
                            }
                        }
                    }
                }
            }
            dfs(depth + 1, N, copyArea);
        }
    }
}