package bakjoon.simulationalgorithm;

import java.util.Scanner;

// 전자레인지
public class BakJoon14470 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int sum = 0;
        if (start < 0) {
            sum += Math.abs(start) * c;
            start = 0;
        }
        if (start == 0) {
            sum += d;
        }
        sum += (end - start) * e;
        System.out.println(sum);
    }
}
