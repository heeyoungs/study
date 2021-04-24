package sourcecode.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AntSoldier {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int[] array = new int[count];
        int[] dp = new int[count];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        // 여기서푸터 문제 풀이 -> 각 dp에 최댓값
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < count; i++) {
            dp[i] = Math.max(dp[i - 2] + array[i], dp[i - 1]);
        }
        // 정답
        System.out.println(dp[count - 1]);
    }
}
/*
점화식
a->앞의 식량을 털었을 경우       : dp[n-1]
b->앞의 식량을 털지 않았을 경우   : dp[n-2] + array[n]
max(a,b)
 */
