package bakjoon.backtrackingalgorithm;

import java.util.Scanner;

// 신기한 소수
public class BakJoon2023 {
    static int[] array;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dfs(0, "");

        System.out.println(sb);
    }

    static void dfs(int depth, String k) {
        if (depth == N) {
            sb.append(k).append("\n");
            return;
        }

        if (depth == 0) {
            for (int i = 2; i <= 9; i++) {
                int copyK = Integer.parseInt(k + i);
                boolean check = true;
                for (int t = 2; t < copyK; t++) {
                    if (copyK % t == 0) {
                        check = false;
                        break;
                    }
                }
                if (check) dfs(depth + 1, Integer.toString(copyK));
            }
        } else {
            for (int i = 0; i <= 9; i++) {
                int copyK = Integer.parseInt(k + i);
                boolean check = true;
                for (int t = 2; t < copyK; t++) {
                    if (copyK % t == 0) {
                        check = false;
                        break;
                    }
                }
                if (check) dfs(depth + 1, Integer.toString(copyK));
            }
        }
    }
}
