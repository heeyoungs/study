package bakjoon.backtrackingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스타트와 링크
public class BakJoon14889 {
    static int N;
    static int[][] power;
    static boolean[] team;
    static int gap = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        power = new int[N][N];
        team = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                power[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(gap);
    }

    static void dfs(int at, int depth) {
        if (depth == N/2) {
            int teamA = 0;
            int teamB = 0;
            for (int i = 0; i < N; i++) {
                if (team[i]) { // 팀 A
                    for (int j = 0; j < N; j++) {
                        if (team[j]) {
                            teamA += power[j][i];
                        }
                    }
                } else { // 팀 B
                    for (int j = 0; j < N; j++) {
                        if (!team[j]) {
                            teamB += power[j][i];
                        }
                    }
                }
            }
            gap = Math.min(Math.abs(teamA - teamB), gap);
            return;
        }

        for (int i = at; i < N; i++) {
            team[i] = true;
            dfs(i + 1, depth + 1);
            team[i] = false;
        }
    }
}
