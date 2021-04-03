package sort;

public class HeapSort {
    static int[] data = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};

    public static void main(String[] args) {
        heapSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    static void heapSort(int[] data) {
        // 힙을 구성
        for (int i = 0; i < data.length - 1; i++) {
            int c = i;
            do {
                int root = (c - 1) / 2;
                if (data[root] < data[c]) {
                    int temp = data[root];
                    data[root] = data[c];
                    data[c] = temp;
                }
                c = root;
            } while (c != 0);
        }
        // 크기를 줄여가며 반복적으로 힙을 구성 -> 가장 큰 값을 맨 뒤로 보낸다.
        for (int i = data.length - 1; i >= 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            int root = 0;
            int c = 1;
            do {
                c = 2 * root + 1;
                // 자식 중에 더 큰 값을 찾기
                if (c < i - 1 && data[c] < data[c + 1]) {
                    c++;
                }
                // 루트보다 자식이 더 크다면 교환
                if (c < i && data[root] < data[c]) {
                    temp = data[root];
                    data[root] = data[c];
                    data[c] = temp;
                }
                root = c;
            } while (c < i);
        }
    }
}
