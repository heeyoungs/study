package bakjoon.numberpheoryalgorithm;

import java.util.Scanner;

public class BakJoon1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int k = 0; k < testCase; k++) {
            int inputA = sc.nextInt();
            int inputB = sc.nextInt();

            int multi = inputA * inputB;
            int checkPoint = 0;

            int min;
            if (inputA > inputB) {
                min = inputB;
            } else {
                min = inputA;
            }

            for (int i = min; i > 0; i--) {
                if (inputA % i == 0 && inputB % i == 0) {
                    checkPoint = i;
                    break;
                }
            }

            int maxPoint = multi / checkPoint;

            System.out.println(maxPoint);
        }
    }
}