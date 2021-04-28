package bakjoon.binarysearchalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 2
public class BakJoon12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[1000002];
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int[] savePoint = new int[1000002];
        savePoint[1] = array[1];
        int savePointLastIndex = 1;
        for (int i = 2; i <= N; i++) {
            if (array[i] > savePoint[savePointLastIndex]) {
                savePointLastIndex++;
                savePoint[savePointLastIndex] = array[i];
            } else {
                // 이분 탐색
                int low = 1;
                int high = savePointLastIndex;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    //System.out.println(mid);

                    if (array[i] > savePoint[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                savePoint[low] = array[i];
            }
        }
        System.out.println(savePointLastIndex);
    }
}

