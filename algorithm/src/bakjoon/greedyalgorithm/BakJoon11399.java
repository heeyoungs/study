package bakjoon.greedyalgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BakJoon11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputN = sc.nextInt();
        int ansTime = 0;

        int[] array = new int[inputN];
        for(int i=0;i<inputN;i++){
            int timeToOut = sc.nextInt();
            array[i] = timeToOut;
        }
        Arrays.sort(array); // 오름 차순 정렬상태
        int personNum = inputN;
        for(int i=0;i<inputN;i++){
            ansTime = ansTime + (array[i] * personNum--);
        }

        System.out.println(ansTime);
    }
}
