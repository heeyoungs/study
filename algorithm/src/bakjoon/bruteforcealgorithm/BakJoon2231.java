package bakjoon.bruteforcealgorithm;

import java.util.Scanner;

public class BakJoon2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();

        int ans;
        for (ans = 1; ans < inputNum; ans++) {
            int dividePoint = 0;
            int check = ans;
            while (true) {
                dividePoint = dividePoint + check % 10;
                check = check / 10;
                if (check == 0){
                    break;
                }
            }
            if(ans + dividePoint == inputNum){
                break;
            }
        }
        if(inputNum == ans){
            ans = 0;
        }
        System.out.println(ans);
    }
}
