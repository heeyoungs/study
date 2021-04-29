package bakjoon.binarysearchalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// K 번째 수
public class BakJoon1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int start = 1;
        int end = K;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0; // mid 보다 작거나 같은 수의 개수를 세준다.
            for (int i = 1; i <= N; i++) {
                count += Math.min(N, mid / i);
            }

            if (count < K) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
