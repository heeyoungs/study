package bakjoon.binarysearchalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 랜선 자르기
public class BakJoon1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
        int[] array = new int[K];
        long low = 1;
        long high = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());
            array[i] = input;
            high = Math.max(high, array[i]);
        }
        long ans = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            long count = 0;
            for (int i = 0; i < K; i++) {
                count += array[i] / mid;
            }
            //System.out.println(mid + " " + count);
            if (count >= N) {
                low = mid + 1;
                ans = mid;
            } else if (count < N) {
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
