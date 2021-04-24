package bakjoon.priorityqueuealgorithm;

import java.util.Scanner;
// 최소 힙
public class BakJoon1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCase = sc.nextInt();
        int[] array = new int[100001];
        int length = 1;
        for (int i = 0; i < testCase; i++) {
            int input = sc.nextInt();
            // 제거 및 출력 부분
            if (input == 0) {
                // 길이가 0일 때 출력하려하면
                if (length == 1){
                    sb.append(0 + "\n");
                    continue;
                }

                sb.append(array[1] + "\n");
                array[1] = array[length - 1]; // 일단 마지막 자리의 값을 맨 앞으로 가져옴
                length--;
                int k = length;
                int temp = array[length];
                int parent = 1, child = 2;
                while (child <= k) {
                    if (child < k && array[child] > array[child+1]){
                        child++;
                    }
                    if (temp <= array[child]){
                        break;
                    }
                    array[parent] = array[child];
                    parent = child;
                    child = child * 2;
                }
                array[parent] = temp;
                // 추가 부분
            } else {
                length++;
                int k = length-1;
                while ((k != 1) && (input < array[k / 2])) { // input 이 부모보다 클 때
                    array[k] = array[k / 2];
                    k = k / 2;
                }
                array[k] = input;
            }
        }
        System.out.println(sb);
    }
}