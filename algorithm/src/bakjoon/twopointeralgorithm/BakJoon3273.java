package bakjoon.twopointeralgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 두 수의 합
public class BakJoon3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1line
        int NodeNum = Integer.parseInt(br.readLine());
        // 2line
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[NodeNum];
        for (int i = 0; i < NodeNum; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        // 3line
        int X = Integer.parseInt(br.readLine());
        // code
        int totalCount = 0;
        int start = 0;
        int end = NodeNum - 1;
        while (start < end) {
            int k = array[start] + array[end];
            if (k == X) {
                totalCount++;
                end--;
                start++;
            } else if (k < X) {
                //end++;
                start++;
            } else if (k > X){
                end--;
            }
        }


        System.out.println(totalCount);
    }
}
