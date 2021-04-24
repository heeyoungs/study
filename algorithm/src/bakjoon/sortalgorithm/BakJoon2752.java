package bakjoon.sortalgorithm;

import java.util.Scanner;
// 세수정렬
public class BakJoon2752 {
    public static void main(String[] args) {
        int array[] = new int[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int input = sc.nextInt();
            array[i] = input;
        }

        bubbleSort(array, 3);
        for (int i = 0; i < 3; i++) {
            System.out.print(array[i] + " ");
        }
    }

    static void bubbleSort(int[] data, int length) {
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}
