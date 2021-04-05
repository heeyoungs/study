package bakjoon.greedyalgorithm;

import java.util.Scanner;
import java.util.Stack;

public class BakJoon11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputN = sc.nextInt(); // 동전의 개수
        int inputK = sc.nextInt(); // 목표 값

        int Count = 0; // 동전의 개수

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < inputN; i++) {
            int input = sc.nextInt(); // 동전 값 -> 오름차순
            stack.push(input);
        }

        while (true) {
            int Coin = stack.pop();
            Count = Count + inputK / Coin;
            inputK = inputK % Coin;
            if (inputK == 0) {
                break;
            }
        }

        System.out.println(Count);
    }
}
