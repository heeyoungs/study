package bakjoon.greedyalgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BakJoon2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();

        int[] array = new int[inputNum];
        for(int i=0;i<inputNum;i++){
            int input = sc.nextInt();
            array[i] = input;
        }

        Arrays.sort(array);

        int maxPoint = inputNum * array[0];

        for(int i=1;i<inputNum;i++){
            if (maxPoint < array[i]* (inputNum-i)){
                maxPoint = array[i]* (inputNum-i);
            }
        }
        System.out.println(maxPoint);
    }
}
