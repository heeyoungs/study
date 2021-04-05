package bakjoon.sortalgorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BakJoon2751 {
    static int[] copyArray = new int[1000000];

    public static void main(String[] args) throws IOException {
        int[] array = new int[1000000];
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        for (int i = 0; i < inputNum; i++) {
            int input = sc.nextInt();
            array[i] = input;
        }
//        Arrays.sort(array);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        mergeSort(array, 0, inputNum-1);
        for (int i = 0; i < inputNum; i++) {
            bw.write(array[i] + "\n");
//            System.out.println(array[i]);
        }
        bw.flush(); bw.close();
    }
    static void merge(int[] array, int start, int middle, int end) { // 시간 초과
        int i = start;
        int j = middle + 1;
        int k = start;
        while (j <= end && i <= middle) {
            if (array[i] <= array[j]) {
                copyArray[k] = array[i];
                i++;
            } else {
                copyArray[k] = array[j];
                j++;
            }
            k++;
        }
        if (i > middle) {
            for (int t = j; t <= end; t++) {
                copyArray[k] = array[t];
                k++;
            }
        } else {
            for (int t = i; t <= middle; t++) {
                copyArray[k] = array[t];
                k++;
            }
        }
        for (int t = start; t <= end; t++) {
            array[t] = copyArray[t];
        }
    }

    static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }
}


//    static void quickSort(int[] data, int start, int end) { // 시간 초과
//        int key = start;
//        int i = start + 1;
//        int j = end;
//        int temp;
//
//        while (i <= j) {
//            while (i <= end && data[i] <= data[key]) {
//                i++;
//            }
//            while (j > start && data[j] >= data[key]) {
//                j--;
//            }
//            if (i > j) {
//                temp = data[j];
//                data[j] = data[key];
//                data[key] = temp;
//            } else {
//                temp = data[j];
//                data[j] = data[i];
//                data[i] = temp;
//            }
//            quickSort(data, start, j - 1);
//            quickSort(data, j + 1, end);
//
//        }
//    }