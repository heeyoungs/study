package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

// 돌게임 2
public class BakJoon9656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N%2==0){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}
