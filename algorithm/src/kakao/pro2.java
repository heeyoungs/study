package kakao;

import java.util.LinkedList;
import java.util.Queue;

public class pro2 {
    public static void main(String[] args) {
        String[][] places =
                {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(solution(places));
    }

    static int AnsCheck = 1;
    static int[][] area;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Point {
        int x;
        int y;
        int count;

        Point(int x, int y,int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static public int[] solution(String[][] places) {
        int[] ans = new int[5];
        for (int i = 0; i < 5; i++) {
            AnsCheck = 1;
            area = new int[5][5];
            for (int h = 0; h < 5; h++) {
                for (int w = 0; w < 5; w++) {
                    area[w][h] = places[i][h].charAt(w);
                    if (area[w][h] == 'P') {
                        area[w][h] = 1;
                    } else if (area[w][h] == 'O') {
                        area[w][h] = 0;
                    } else if (area[w][h] == 'X') {
                        area[w][h] = -1;
                    }
                }
            }
            // 변환 -> 파티션 -1, 앉아있는 곳 1, 빈칸 0
            // 자리별 dfs -> 두칸 넘어가는데 사람이 있으면 check -> 0
            Out:
            for (int h = 0; h < 5; h++) {
                for (int w = 0; w < 5; w++) {
                    if (area[w][h] == 1) {
                        visit = new boolean[5][5];
                        dfs(w, h);
                        if (AnsCheck == 0){
                            break Out;
                        }
                    }
                }
            }
            ans[i] = AnsCheck;
        }
        return ans;
    }

    static void dfs(int w, int h) {
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(w,h,0));
        visit[w][h] = true;
        while(!Q.isEmpty()){
            Point check = Q.poll();
            if (check.count == 2){
                continue;
            }

            for(int i=0;i<4;i++){
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx <0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (visit[nx][ny]) continue;
                if (area[nx][ny] == -1) continue;
                else if (area[nx][ny] == 1) {
                    AnsCheck = 0;
                    return;
                }else if (area[nx][ny] == 0) {
                    Q.add(new Point(nx, ny, check.count + 1));
                    visit[nx][ny] = true;
                }
            }
        }
    }
}
