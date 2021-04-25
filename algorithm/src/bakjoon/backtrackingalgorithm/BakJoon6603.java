package bakjoon.backtrackingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로또 -> N과 M의 응용
public class BakJoon6603 {
    static int[] array;
    static int[] save;
    static int numCount;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            numCount = Integer.parseInt(st.nextToken());
            if (numCount == 0) {
                break;
            }
            array = new int[numCount];
            save = new int[6];
            for (int i = 0; i < numCount; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int at, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(save[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = at; i < numCount; i++) {
            save[depth] = array[i];
            dfs(i + 1, depth + 1);
        }
    }
}
