package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

public class BakJoon11726 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();

        System.out.println(tileCount(inputNum));
    }
    public static int[] d = new int[1001];
    public static int tileCount(int num){
        if(num==1) return 1;
        if(num==2) return 2;
        if(d[num] != 0) return d[num];
        return d[num] = (tileCount(num-1)+tileCount(num-2))%10007;
    }
}
