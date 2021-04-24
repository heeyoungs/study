package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;
// 2xN 타일링 2
public class BakJoon11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();

        System.out.println(tileCount(inputNum));
    }
    public static int[] d = new int[1001];
    public static int tileCount(int num){
        if(num==1) return 1;
        if(num==2) return 3;
        if(d[num] != 0) return d[num];
        return d[num] = (tileCount(num-1)+2*tileCount(num-2))%10007;
    }
}
