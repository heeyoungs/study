package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 4
public class BakJoon14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N+1];
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[1001];
        int[] mem = new int[1001];
        Arrays.fill(dp, 1);

        int max = 1; // 최장 증가 부분 수열의 길이
        int maxPoint = 1; // 최장 증가 부분 수열의 최대 원소의 인덱스

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (array[i] > array[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    mem[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxPoint = i;
            }
        }
        sb.append(max).append("\n");

        Stack<Integer> stack = new Stack<>();
        while (maxPoint != 0) {
            stack.push(array[maxPoint]);
            maxPoint = mem[maxPoint];
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
