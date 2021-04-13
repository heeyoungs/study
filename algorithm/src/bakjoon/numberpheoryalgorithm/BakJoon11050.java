package bakjoon.numberpheoryalgorithm;

import java.util.Scanner;

public class BakJoon11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputA = sc.nextInt();
        int inputB = sc.nextInt();

        System.out.println(Combine(inputA,inputB));
    }
    public static int Combine(int a,int b){
        if (a==b || b==0){
            return 1;
        }
        return Combine(a-1,b-1) + Combine(a-1,b);
    }
}