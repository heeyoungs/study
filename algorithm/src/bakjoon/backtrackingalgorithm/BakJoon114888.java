package bakjoon.backtrackingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연산자 끼워넣기
public class BakJoon114888 {
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;
    static int[] array;
    static int[] operator;
    static int N;
    static int[] oper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];
        oper = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        // + - x /
        operator = new int[4];
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    static void dfs(int at, int depth) {
        if (depth == N - 1) {
            int result = array[0];
            for (int i = 1; i < N; i++) {
                if (oper[i - 1] == 0) {
                    result += array[i];
                } else if (oper[i - 1] == 1) {
                    result -= array[i];
                } else if (oper[i - 1] == 2) {
                    result *= array[i];
                } else {
                    result /= array[i];
                }
            }
            maxValue = Math.max(maxValue, result);
            minValue = Math.min(minValue, result);
            return;
        }

        for (int k = 0; k < 4; k++) {
            if (operator[k] == 0) continue;
            operator[k] = operator[k] - 1;
            oper[at] = k;
            dfs(at + 1, depth + 1);
            operator[k] = operator[k] + 1;
        }
    }
}
