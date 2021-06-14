package bakjoon.simulationalgorithm;

import java.util.Scanner;

// 반복 수열
public class BakJoon2331 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int P = sc.nextInt();

        int[] array = new int[236197];
        array[A] = 1;
        int countA = 1;
        int countB = 0;
        while (true) {
            int nextNum = 0;

            while (true) {
                nextNum += (int) Math.pow(A % 10, P);
                A = A / 10;
                if (A == 0) break;
            }

            if (array[nextNum] == 2) break;
            else if (array[nextNum] == 1) {
                countB++;
            }
            array[nextNum]++;
            A = nextNum;
            countA++;
            //System.out.println(array[nextNum]);
        }
        System.out.println(countA - countB * 2);
    }
}
