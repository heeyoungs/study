package bakjoon.greedyalgorithm;

import java.util.Scanner;

public class BakJoon13305 { // 입력값의 범위를 잘 확인하자!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputN = sc.nextInt();

        int[] roadInfo = new int[inputN-1];
        for (int i = 0; i < inputN - 1; i++) {
            int road = sc.nextInt();
            roadInfo[i] = road;
        }

        int[] literInfo = new int[inputN]; // 사실 마지막 도시 정보는 필요없다
        for (int i = 0; i < inputN; i++) {
            int liter = sc.nextInt();
            literInfo[i] = liter;
        }

        long Cost = 0;
        int start = literInfo[0];
        for(int i=0;i<inputN-1;i++){
            if(start >= literInfo[i]){
                start = literInfo[i];
            }
            Cost = Cost + (long)start * (long)roadInfo[i];
        }

        System.out.println(Cost);
    }
}
