package sourcecode.sort;

public class InsertionSort {
    static int[] data = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};

    public static void main(String[] args) {
        insertionSort(data, data.length);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    static void insertionSort(int[] data, int length) {
        int j;
        int key;
        for (int i = 1; i < length; i++) {
            key = data[i];
            for (j = i - 1; j >= 0; j--) {
                if (key > data[j]) {
                    break;
                } else {
                    data[j + 1] = data[j];
                }
            }
            data[j + 1] = key; // j는 key보다 작은값이 있는 자리의 시작부분 -> j + 1 에 key값을 삽입
        }
    }
}
