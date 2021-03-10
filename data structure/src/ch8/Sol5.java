package ch8;

import java.util.Scanner;

public class Sol5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(addsum(num));
    }

    static double addsum(int n){
        double ret = 0;
        double t = n;
        if(n == 0){
            return ret;
        }
        ret = 1/t + addsum(n-1);
        return ret;
    }
}
