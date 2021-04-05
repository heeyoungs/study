package sourcecode.sort;

public class BubbleSort {
    static int[] data = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};

    public static void main(String[] args) {
        bubbleSort(data, data.length);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    static void bubbleSort(int[] data, int length) {
        int temp;
        int check = 0;
        for (int i = 0; i < length; i++) {
            check = 0;
            for (int j = 0; j < length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    check = 1;
                }
                if (check == 0) {
                    break;
                }
            }
        }
    }
}
