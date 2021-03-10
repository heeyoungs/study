package ch8;

import java.util.Scanner;

public class Sol6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(sum(num));
    }
    static int sum(int n){
        int ret=0;
        for(int i=0;i<=n;i++){
            ret= ret+i;
        }
        return ret;
    }
}
