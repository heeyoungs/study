package bakjoon.backtrackingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스도쿠
public class BakJoon2580 {
    static int[][] ansArea = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[][] area = new int[9][9];
        for (int h = 0; h < 9; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < 9; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0,area);
        for(int h=0;h<9;h++){
            for(int w=0;w<9;w++){
                sb.append(ansArea[w][h] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int row, int col, int[][] area) {
        if (col == 9) {
            dfs(row + 1, 0, area);
            return;
        }

        if (row == 9) {
            for(int h=0;h<9;h++){
                for(int w=0;w<9;w++){
                    ansArea[w][h] = area[w][h];
                }
            }
            return;
        }

        if (area[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isNum(row, col, i, area)) {
                    area[row][col] = i;
                    dfs(row, col + 1, area);
                }
            }
            area[row][col] = 0;
        } else {
            dfs(row, col + 1, area);
        }
    }

    static boolean isNum(int row, int col, int value, int[][] area) {
        int h = (row / 3) * 3;
        int w = (col / 3) * 3;
        for (int i = 0; i < 9; i++) {
            if (value == area[row][i]) return false;
            if (value == area[i][col]) return false;
        }
        for (int i = h; i < h + 3; i++) {
            for (int j = w; j < w + 3; j++) {
                if (value == area[i][j]) return false;
            }
        }
        return true;
    }
}
