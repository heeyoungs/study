package sort;

public class MergeSort {
    static int[] data = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};
    static int[] array = new int[data.length];

    public static void main(String[] args) {
        mergeSort(data, 0, array.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    static void merge(int[] data, int m, int middle, int n) {
        int i = m;
        int j = middle + 1;
        int k = m;
        // 작은 순서대로 배열에 삽입
        while (i <= middle && j <= n) {
            if (data[i] <= data[j]) {
                array[k] = data[i];
                i++;
            } else {
                array[k] = data[j];
                j++;
            }
            k++;
        }
        // 남은 데이터
        if (i > middle) {
            for (int t = j; t <= n; t++) {
                array[k] = data[t];
                k++;
            }
        } else {
            for (int t = i; t <= middle; t++) {
                array[k] = data[t];
                k++;
            }
        }
        // 전역 배열에 잇는 것을 합치기 -> 전역 배열의 m~n은 정렬된 상태
        for (int t = m; t <= n; t++) {
            data[t] = array[t];
        }
    }

    static void mergeSort(int[] data, int m, int n) {
        if (m < n) {
            int middle = (m + n) / 2;
            mergeSort(data, m, middle);
            mergeSort(data, middle + 1, n);
            merge(data, m, middle, n);
        }
    }
}
