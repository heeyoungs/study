package bakjoon.greedyalgorithm;

import java.util.Scanner;

public class BakJoon5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();

        inputNum = 1000 - inputNum;

        int count = 0;

        int[] array = {500,100,50,10,5,1};
        int index = 0;

        while(inputNum != 0){
            count = count + inputNum / array[index];
            inputNum = inputNum % array[index];
            index++;
        }


        System.out.println(count);
    }
}
