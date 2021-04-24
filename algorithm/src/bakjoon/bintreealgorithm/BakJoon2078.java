package bakjoon.bintreealgorithm;

import java.util.Scanner;
// 무한 이진 트리
public class BakJoon2078 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long inputA = sc.nextInt();
        long inputB = sc.nextInt();
        ans(inputA, inputB);
        System.out.print(countL + " " + countR);

    }

    static long countL = 0;
    static long countR = 0;

    static void ans(long a, long b) {
        if (a == 1 && b == 1) { // 종료 조건
            return;
        }
        // 트리를 거꾸로 타고 올라간다.
        if (a == 1) {
            countR = countR + (b - a);
            return;
        } else if (b == 1) {
            countL = countL + (a - b);
            return;
        } else if (a > b) {
            countL = countL + a / b;
            ans(a % b, b);
        } else if (a < b) {
            countR = countR + b / a;
            ans(a, b % a);
        }
    }
}
