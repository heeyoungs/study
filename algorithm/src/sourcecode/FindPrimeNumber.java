package sourcecode;

import java.util.Scanner;

public class FindPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();

        int[] array = new int[inputNum + 1]; // 배열 생성

        for (int i = 0; i <= inputNum; i++) {
            array[i] = i;
        } // 숫자가 저장된 배열에 1~input값 저장

        for(int i=2;i<=inputNum;i++){
            if( array[i] == 0 ){
                continue;
            }
            for(int j=i+i;j<=inputNum;j=j+i){
                array[j] = 0;
            }
        } // 에라토스테네스의 체

        for (int i = 2; i <= inputNum; i++) {
            if(array[i] == 0){
                continue;
            }
            System.out.print(array[i] + " ");
        } // 출력
    }
}
