package bakjoon.binarysearchalgorithm;

import java.io.*;
import java.util.Arrays;

// 나무 자르기 - 이분 탐색 -> 최고 높이를 기준으로 이분 탐색 실행 (NlogN까지 허용하는 문제)
public class BakJoon2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int treeCount = Integer.parseInt(input[0]);
        int needMeter = Integer.parseInt(input[1]);

        int[] array = new int[treeCount];
        long highPoint = 0;
        input = br.readLine().split(" ");
        for (int i = 0; i < treeCount; i++) {
            array[i] = Integer.parseInt(input[i]);
            highPoint = Math.max(highPoint, array[i]);
        }

        long low = 0;
        long high = highPoint;
        long mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;

            long sum = 0;
            for (int i = 0; i < treeCount; i++) {
                if (array[i] > mid) {
                    sum += array[i] - mid;
                }
            }

            if (sum < needMeter) { // 총량이 더 작은 경우 -> 더 많이 잘라야 겠죠?
                high = mid - 1;
            } else if (sum > needMeter) {
                low = mid + 1;
            } else if (sum == needMeter) {
                System.out.println(mid);
                return;
            }
        }
        // 만약 sum == needMeter 을 성립하지 않고 종료시
        System.out.println(low - 1);
        // System.out.println(high);
    }
}
