package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// DSLR
public class BakJoon9019 {
    static String[] area;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int T = 0; T < TestCase; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            area = new String[10001];
            visit = new boolean[10001];
            bfs(start, end);
            sb.append(area[end]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        visit[start] = true;
        area[start] = "";
        queue.add(start);
        while (!queue.isEmpty()) {
            int check = queue.poll();
            if (check == end) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    int nextPoint = D(check);
                    if (!visit[nextPoint]) {
                        visit[nextPoint] = true;
                        area[nextPoint] = area[check] + 'D';
                        queue.add(nextPoint);
                    }
                } else if (i == 1) {
                    int nextPoint = S(check);
                    if (!visit[nextPoint]) {
                        visit[nextPoint] = true;
                        area[nextPoint] = area[check] + 'S';
                        queue.add(nextPoint);
                    }
                } else if (i == 2) {
                    int nextPoint = L(check);
                    if (!visit[nextPoint]) {
                        visit[nextPoint] = true;
                        area[nextPoint] = area[check] + 'L';
                        queue.add(nextPoint);
                    }
                } else {
                    int nextPoint = R(check);
                    if (!visit[nextPoint]) {
                        visit[nextPoint] = true;
                        area[nextPoint] = area[check] + 'R';
                        queue.add(nextPoint);
                    }
                }
            }
        }
    }

    static int registerN(int N) {
        int d4 = N % 10;
        N = N / 10;
        int d3 = N % 10;
        N = N / 10;
        int d2 = N % 10;
        N = N / 10;
        int d1 = N % 10;
        return (((d1 * 10) + d2) * 10 + d3) * 10 + d4;
    }

    static int D(int N) { // 2배 처리
        int n = registerN(N);
        n = (n * 2) % 10000;
        return n;
    }

    static int S(int N) {
        int n = registerN(N);
        if (n == 0) n = 10000;
        n = n - 1;
        return n;
    }

    static int L(int N) {
        int n = registerN(N);
        int d4 = n % 10;
        n = n / 10;
        int d3 = n % 10;
        n = n / 10;
        int d2 = n % 10;
        n = n / 10;
        int d1 = n % 10;
        int newN = d2 * 1000 + d3 * 100 + d4 * 10 + d1 * 1;
        return newN;
    }

    static int R(int N) {
        int n = registerN(N);
        int d4 = n % 10;
        n = n / 10;
        int d3 = n % 10;
        n = n / 10;
        int d2 = n % 10;
        n = n / 10;
        int d1 = n % 10;
        int newN = d4 * 1000 + d1 * 100 + d2 * 10 + d3 * 1;
        return newN;
    }
}
