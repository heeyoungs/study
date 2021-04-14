package bakjoon.binarysearchalgorithm;

import java.io.*;
import java.util.Arrays;

public class BakJoon2805 { // 나무 자르기 - 이분 탐색
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int treeCount = Integer.parseInt(input[0]);
        int needMeter = Integer.parseInt(input[1]);

        int[] array = new int[treeCount];
        input = br.readLine().split(" ");
        for (int i = 0; i < treeCount; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int ans;
        int sum = 0;
        int maxPoint = array[treeCount - 1];
        Arrays.sort(array);
        for (int i = treeCount - 2; i >= 0; i--) {
            sum = sum + (maxPoint - array[i]);
            if (sum == needMeter){
                ans = array[i];
                break;
            } else if ( sum > needMeter){

            }
        }
    }
}
