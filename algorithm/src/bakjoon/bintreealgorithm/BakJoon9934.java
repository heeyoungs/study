package bakjoon.bintreealgorithm;

import java.util.Scanner;

public class BakJoon9934 {
    static StringBuilder[] sb = new StringBuilder[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputLevel = sc.nextInt();
        int length = (int) (Math.pow(2, inputLevel) - 1);

        int[] arr = new int[length]; // 배열 할당
        for (int i = 0; i < length; i++) { // 배열에 값 저장
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < inputLevel; i++) { // 레벨 할당
            sb[i] = new StringBuilder();
        }

        recursive(arr, 0, length - 1, 0);

        for (int i = 0; i < inputLevel; i++) { // 레벨별로 출력
            System.out.println(sb[i]);
        }

        sc.close();
    }

    static void recursive(int[] arr, int start, int end, int level) {
        if (start > end) return; // 종료조건
        int middle = (start + end) / 2;
        sb[level].append(arr[middle] + " "); // 레벨마다 문자를 추가로 붙여줌
        recursive(arr, start, middle - 1, level + 1); // 왼쪽으로
        recursive(arr, middle + 1, end, level + 1); // 오른쪽으로
    }
}
