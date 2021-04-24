package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;
// 01 타일
public class BakJoon1904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(tile(N));
    }
    static int[] d = new int[1000001];

    static int tile(int n){
        if (d[n]!=0){
            return d[n];
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        return d[n] = (tile(n-1) + tile(n-2))%15746;
    }
}
