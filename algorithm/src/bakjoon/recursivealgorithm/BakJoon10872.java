package bakjoon.recursivealgorithm;

import java.util.Scanner;

public class BakJoon10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();

        System.out.println(factorial(inputNum));
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return n * factorial(n - 1);
    }
}
