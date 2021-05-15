package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열
public class BakJoon2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        int[] arrayReverse = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            arrayReverse[i] = array[N - i -1];
        }

        // 가장 긴? 가장 작은? 비교
        int ans = 1;
        int count = 1;

        for (int i = 0; i < N-1; i++) {
            if (array[i]<=array[i +1])count++;
            else count = 1;
            ans = Math.max(count,ans);
        }
        count = 1;
        for (int i = 0; i < N-1; i++) {
            if (arrayReverse[i]<=arrayReverse[i +1])count++;
            else count = 1;
            ans = Math.max(count,ans);
        }
        System.out.println(ans);
    }
}
