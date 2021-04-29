package bakjoon.bruteforcealgorithm;

import java.util.Scanner;

// 백설 공주와 일곱 난쟁이
public class BakJoon3040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[9];
        int totalSum = 0;
        for (int i = 0; i < 9; i++) {
            array[i] = sc.nextInt();
            totalSum += array[i];
        }
        int i,j=0;
        Out:
        for (i = 0; i < 9; i++) {
            for (j = i + 1; j < 9; j++) {
                if (totalSum - array[i] - array[j] == 100){
                    break Out;
                }
            }
        }
        for(int k=0;k<9;k++){
            if (k == i || k == j )continue;
            System.out.println(array[k]);
        }

    }
}
