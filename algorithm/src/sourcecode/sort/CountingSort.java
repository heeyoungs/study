package sourcecode.sort;

import java.util.Random;
import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int n = sc.nextInt(); // 자연수의 개수
        int k = sc.nextInt(); // 자연수의 최대 크기

        System.out.print("정렬 전: ");
        int[] array = new int[n]; // n크기 만큼의 배열을 생성해 줍니다.
        for (int i = 0; i < n; i++) { // 난수를 입력받고 초기화 해줍니다.
            array[i] = random.nextInt(k) + 1;
            System.out.print(array[i] + " "); // 입력받은 난수를 출력합니다.
        }

        countingSort(array, n, k); // 계수 정렬을 실행합니다.

        System.out.print("\n정렬 후: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " "); // 정렬된 숫자들을 출력합니다.
        }
    }

    static void countingSort(int[] data, int number, int maxInt) { //
        int[] count = new int[maxInt]; // 1부터 최대 크기까지의 값을 누적시킬 배열을 생성합니다.
        int index = 0; // 매개값으로 받은 data 배열을 초기화할때 사용할 변수입니다.

        for (int i = 0; i < number; i++) { // 매가값으로 받은 배열의 값들을 검사해서
            count[data[i] - 1]++; // count 배열에 값을 누적합니다.
        }

        for (int i = 0; i < maxInt; i++) { // 1~maxInt 까지의 배열을 하나씩 검사합니다.
            for (int j = 0; j < count[i]; j++) { // count 배열에 누적된 값들을 하나씩 불러옵니다.
                data[index++] = i + 1; // 불러온 값들을 data 배열의 인덱스 0 부터 초기화 시켜줍니다.
            }
        }
    }
}
