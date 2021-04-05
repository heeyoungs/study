package sourcecode.sort;

public class CountingSort {
    static int[] data = {1, 2, 3, 1, 2, 1, 4, 5, 3, 2, 5, 4, 2, 4};

    public static void main(String[] args) {
        countingSort(data);
    }

    static void countingSort(int[] data) {
        int[] count = new int[5];
        for (int i = 0; i < data.length; i++) {
            count[data[i] - 1]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < count[i]; j++) {
                    System.out.print(i + 1 + " ");
                }
            }
        }
    }
}
