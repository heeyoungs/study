package bakjoon.binarysearchalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 공유기 설치
public class BakJoon2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        int minPoint = Integer.MAX_VALUE;
        int maxPoint = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            array[i] = input;
            minPoint = Math.min(minPoint, input);
            maxPoint = Math.max(maxPoint, input);
        }
        Arrays.sort(array);
        int maxLength = maxPoint - minPoint;
        int minLength = 1;
        while (minLength <= maxLength) {
            int midLength = (minLength + maxLength) / 2;
            int count = 1;
            int startHouse = 0;
            for(int i=1;i<N;i++){
                if (array[i] - array[startHouse] >= midLength){
                    count++;
                    startHouse = i;
                }
            }

            if (count < C){
                maxLength = midLength - 1;
            }else{
                minLength = midLength + 1;
            }
        }
        System.out.println(maxLength);
    }
}
