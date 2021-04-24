package bakjoon.sortalgorithm;

import java.util.Scanner;
// 수 정렬하기
public class BakJoon2750 {
    public static void main(String[] args) {
        int[] array = new int[1000];
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        for (int i = 0; i < inputNum; i++) {
            int input = sc.nextInt();
            array[i] = input;
        }
        SelectionSort(array, inputNum);
        for (int i = 0; i < inputNum; i++) {
            System.out.println(array[i]);
        }
    }

    static void SelectionSort(int[] data, int arrayCount) {
        int maxIndex = 0;
        int temp;
        for (int i = arrayCount - 1; i >= 0; i--) {
            maxIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (data[maxIndex] < data[j]) {
                    maxIndex = j;
                }
            }
            temp = data[maxIndex];
            data[maxIndex] = data[i];
            data[i] = temp;
        }
    }
}
