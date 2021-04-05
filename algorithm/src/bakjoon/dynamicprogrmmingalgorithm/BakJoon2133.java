package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

public class BakJoon2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();

        System.out.println(tileCount(inputNum));
    }

    public static int[] d = new int[31];

    public static int tileCount(int num) {
        if (num == 0) return 1;
        if (num == 1) return 0;
        if (num == 2) return 3;
        if (d[num] != 0) return d[num];
        int result = 3 * tileCount(num - 2);
        for(int i=3;i<=num;i++){
            if(i%2==0){
                result = result + 2 * tileCount(num-i);
            }
        }
        return d[num] = result;
    }
}
