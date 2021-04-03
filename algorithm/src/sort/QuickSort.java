package sort;

public class QuickSort {
    static int[] data = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};

    public static void main(String[] args) {
        quickSort(data, 0, 9);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    static void quickSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int key = start;
        int i = start + 1;
        int j = end;
        int temp;

        while (i <= j) { // 엇갈릴때까지 반복
            while (data[i] < data[key] && i <= end) { // 키 값보다 큰 값을 만날 떄까지 오른쪽으로 이동
                i++;
            }
            while (data[j] >= data[key] && j > start) { // 키 값보다 작은 값을 만날 때까지 왼쪽으로 이동
                j--;
            }
            if (i > j) { // 엇갈렸다면
                temp = data[j];
                data[j] = data[key];
                data[key] = temp;
            } else { // 엇갈리지 않았다면
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
            quickSort(data, start, j - 1);
            quickSort(data, j + 1, end);
        }
    }
}
