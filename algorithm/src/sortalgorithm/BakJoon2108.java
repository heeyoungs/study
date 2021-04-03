package sortalgorithm;

import java.util.Scanner;

public class BakJoon2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        int[] array = new int[inputNum];

        for (int i = 0; i < inputNum; i++) {
            int input = sc.nextInt();
            array[i] = input;
        }

        mergeSort(array, 0, inputNum - 1);

        int sum = 0;
        int[] lotArray = new int[8001]; // -4000~4000 사이의 개수를 담는 배열

        for (int i = 0; i < inputNum; i++) {
            sum = sum + array[i];
            lotArray[array[i] + 4000]++;
        }

        int max = 0;
        int k = 0;
        int[] ans = new int[8001];
        for (int i = 0; i <= 8000; i++) {
            if (lotArray[max] == lotArray[i]) {
                ans[k] = i;
                k++;
            } else if (lotArray[max] < lotArray[i]) {
                k = 0;
                max = i;
                ans[k] = i;
                k++;
            } else {
                continue;
            }
        }

        double avg;
        if (sum < 0) {
            sum = -sum;
            avg = Math.round((double) sum / inputNum);
            avg = -avg;
        } else {
            avg = Math.round((double)sum / inputNum);
        }
        System.out.println((int) avg);


        int middle = array[inputNum / 2];
        System.out.println(middle);


        if(lotArray[ans[0]] > lotArray[ans[1]]){
            System.out.println(ans[0] - 4000);
        } else {
            System.out.println(ans[1] - 4000);
        }

        int range = array[inputNum - 1] - array[0];
        System.out.println(range);
    }

    static int[] copyArray = new int[500000];

    static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    static void merge(int[] array, int start, int middle, int end) {
        int i = start; // 분할 배열의 앞
        int j = middle + 1; // 분할 배열의 뒤
        int k = start; // 저장할 배열의 인덱스
        while (i <= middle && j <= end) {
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
            while (j <= end) {
                copyArray[k] = array[j];
                j++;
                k++;
            }
        } else {
            while (i <= middle) {
                copyArray[k] = array[i];
                i++;
                k++;
            }
        }

        for (int t = start; t <= end; t++) {
            array[t] = copyArray[t];
        }
    }
}
