package sourcecode.dynamicprogramming;

import java.util.Scanner;

public class fibonaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(fibo(input));
    }

    public static int[] d = new int[100];

    public static int fibo(int num) {
        if (num == 1) return 1;
        if (num == 2) return 1;
        if (d[num] != 0) return d[num];
        return d[num] = fibo(num -1 ) + fibo(num-2);
    }
}
