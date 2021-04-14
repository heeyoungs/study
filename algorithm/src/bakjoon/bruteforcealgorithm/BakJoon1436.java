package bakjoon.bruteforcealgorithm;

import java.util.Scanner;

public class BakJoon1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int stop = 0;
        int startPoint = 666;
        while (true) {
            String check = Integer.toString(startPoint);
            for (int i = 0; i < check.length() - 2; i++) {
                if (check.charAt(i) == '6' && check.charAt(i + 1) == '6' && check.charAt(i + 2) == '6') {
                    stop++;
                    break;
                }
            }
            if (stop == count) {
                break;
            }
            startPoint++; // 666부터 하나씩 증가시켜보면서 검사
        }
        System.out.println(startPoint);
    }
}
