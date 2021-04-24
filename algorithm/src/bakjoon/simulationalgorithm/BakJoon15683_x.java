package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 감시
public class BakJoon15683_x {
    static int[][] area;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int height;
    static int width;
    static CCTV[] cctvArray = new CCTV[9];
    static int cctvCount = 0;
    static int ansMin = Integer.MAX_VALUE;
    static String[][] ccForce = {
            {},
            {"0", "1", "2", "3"},
            {"02", "13"},
            {"01", "12", "23", "30"},
            {"012", "123", "230", "301"},
            {"0123"}
    };

    static class CCTV {
        int x;
        int y;
        int cctvNum;

        CCTV(int x, int y, int cctvNum) {
            this.x = x;
            this.y = y;
            this.cctvNum = cctvNum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new int[width][height];

        for (int h = 0; h < height; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < width; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
                if (area[w][h] >= 1 && area[w][h] <= 5) {
                    cctvArray[cctvCount] = new CCTV(w, h, area[w][h]);
                    cctvCount++;
                }
            }
        } // 배열 할당 및 cctv 의 종류 별 개수를 세어줌

        cc(0, area);

        System.out.println(ansMin);
    }

    static void cc(int cctv, int[][] temp) {
        if (cctv == cctvCount) {
            int ans = 0;
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    if (temp[w][h] == 0){
                        ans++;
                    }
                }
            }
            ansMin = Math.min(ansMin,ans);
            return;
        }

        CCTV check = cctvArray[cctv];

        for (int i = 0; i < ccForce[check.cctvNum].length; i++) { // 경우의 수
            int[][] tempArray = new int[width][height];

            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {
                    tempArray[k][j] = temp[k][j];
                }
            }

            for (int d = 0; d < ccForce[check.cctvNum][i].length(); d++) { // 바라보는 방향
                int nowSee = ccForce[check.cctvNum][i].charAt(d) - '0';
                int nextX = check.x + dx[nowSee];
                int nextY = check.y + dy[nowSee];

                while (true) {
                    if (nextX < 0 || nextY < 0 || nextX >= width || nextY >= height || temp[nextX][nextY] == 6)
                        break;

                    tempArray[nextX][nextY] = -1;
                    nextX += dx[nowSee];
                    nextY += dy[nowSee];
                }
            }
            cc(cctv + 1, tempArray);
        }
    }
}
