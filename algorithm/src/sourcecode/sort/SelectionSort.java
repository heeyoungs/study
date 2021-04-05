package sourcecode.sort;

public class SelectionSort {
    static int[] data = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};

    public static void main(String[] args) {
        selectionSort(data, data.length);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    static void selectionSort(int[] data, int arrayCount) {
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
