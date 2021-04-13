package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BakJoon2667 {
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0}; // dx와 dy로 동서남북 표현
    static int inputNum;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        inputNum = Integer.parseInt(br.readLine());

        arr = new int[inputNum][inputNum];

        for (int t = 0; t < inputNum; t++) {
            String input = br.readLine();
            for (int i = 0; i < inputNum; i++) {
                arr[t][i] = input.charAt(i) - '0';
            }
        }

        bw.write(countApart() + "\n");
        Arrays.sort(ans);
        for (int i = 0; i < ans.length; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int countApart() {
        int ret = 0;
        int[] countArray = new int[5000];
        for (int i = 0; i < inputNum; i++) {
            for (int j = 0; j < inputNum; j++) {
                if (arr[i][j] == 1) {
                    countArray[ret] = dfs(i, j);
                    ret++;
                }
            }
        }
        ans = new int[ret];
        for (int i = 0; i < ret; i++) {
            ans[i] = countArray[i];
        }
        return ret;
    }

    static int dfs(int x, int y) {
        Stack<PointXY> stack = new Stack<>();
        int count = 0;

        arr[x][y] = 0;
        stack.push(new PointXY(x, y));

        while (!stack.isEmpty()) {
            PointXY check = stack.pop();
            count++;
            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < inputNum && ny < inputNum) {
                    if (arr[nx][ny] == 1) {
                        arr[nx][ny] = 0;
                        stack.push(new PointXY(nx, ny));
                    }
                }
            }
        }
        return count;
    }

    static class PointXY {
        int x;
        int y;

        PointXY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
