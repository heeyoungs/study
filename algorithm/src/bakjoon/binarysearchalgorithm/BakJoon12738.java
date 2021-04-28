package bakjoon.binarysearchalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 3
public class BakJoon12738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] saveArray = new int[1000001];
        int savePoint = 0;
        saveArray[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input > saveArray[savePoint]) {
                savePoint++;
                saveArray[savePoint] = input;
            } else {
                int low = 0;
                int high = savePoint;
                while (low <= high) {
                    int mid = (low + high) / 2;

                    if (input > saveArray[mid]){
                        low = mid + 1;
                    }else{
                        high = mid - 1;
                    }
                }
                saveArray[low] = input;
            }
        }
        System.out.println(savePoint + 1);
    }
}
