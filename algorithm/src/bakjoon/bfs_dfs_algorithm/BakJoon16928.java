package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 뱀과 사다리 게임
public class BakJoon16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());
        int[] boardGame = new int[101];
        boolean[] visit = new boolean[101];
        for (int i = 0; i < ladder; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            boardGame[start] = end;
        }
        for (int i = 0; i < snake; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            boardGame[start] = end;
        }
        Queue<Dice> queue = new LinkedList<>();
        queue.add(new Dice(1, 0));
        visit[1] = true;

        int ans = 0;
        while (!queue.isEmpty()) {
            Dice check = queue.poll();
            // 위치 업데이트
            if (boardGame[check.point] != 0){
                check.point = boardGame[check.point];
            }

            if (check.point == 100) {
                System.out.println(check.count);
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int nx  = check.point + i;
                if (nx > 100) continue;
                if (!visit[nx] ){
                    visit[nx] = true;
                    queue.add(new Dice(nx, check.count + 1));
                }
            }
        }

    }

    static class Dice {
        int point;
        int count;

        Dice(int point, int count) {
            this.point = point;
            this.count = count;
        }
    }
}
