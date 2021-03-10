package ch8;

import java.util.Scanner;

public class Sol4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(addsum(num));
    }

    static int addsum(int n){
        int ret = 0;
        if(n == 0){
            return ret;
        }
        ret = n + addsum(n-1);
        return ret;
    }
}
