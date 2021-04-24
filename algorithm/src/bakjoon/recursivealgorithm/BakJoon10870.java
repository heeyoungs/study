package bakjoon.recursivealgorithm;

import java.util.Scanner;
// 피보나치 수 5
public class BakJoon10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();

        System.out.println(fibo(inputNum));
    }

    public static int fibo(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        if (num == 2) return 1;
        return fibo(num-1) + fibo(num - 2);
    }
}
