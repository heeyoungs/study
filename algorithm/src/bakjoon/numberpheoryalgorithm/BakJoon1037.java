package bakjoon.numberpheoryalgorithm;

import java.util.Scanner;
// 약수
public class BakJoon1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();
        int ans = 0;

        if (inputNum == 1) {
            int input = sc.nextInt();
            ans = input * input;
        } else {
            int input = sc.nextInt();
            int max = input;
            int min = input;
            for (int i = 1; i < inputNum; i++) {
                input = sc.nextInt();
                if(input > max){
                    max = input;
                }
                if (input < min) {
                    min = input;
                }
                ans = max * min;
            }
        }

        System.out.println(ans);
    }
}
