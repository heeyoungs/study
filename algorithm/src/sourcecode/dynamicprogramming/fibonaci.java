package sourcecode.dynamicprogramming;

import java.util.Scanner;

public class fibonaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(fibonaci(input));
    }

    public static int[] d = new int[100];

    public static int fibonaci(int num) {
        if (num == 1) return 1;
        if (num == 2) return 1;
        if (d[num] != 0) return d[num];
        return d[num] = fibonaci(num -1 ) + fibonaci(num-2);
    }
}
