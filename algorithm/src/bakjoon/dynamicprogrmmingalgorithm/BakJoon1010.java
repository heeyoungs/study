package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

public class BakJoon1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i=0;i<testCase;i++) {
            int westSite = sc.nextInt();
            int eastSite = sc.nextInt();
            System.out.println( combination(eastSite,westSite));
        }
    }
    public static int[][] array = new int[30][30];

    public static int combination(int n, int r) {
        if(n == r || r == 0)
            return 1;
        if(array[n][r]!=0){
            return array[n][r];
        }
        else {
            array[n-1][r-1] = combination(n-1,r-1);
            array[n-1][r] = combination(n-1,r);
            return array[n-1][r-1] + array[n-1][r];
        }
    }
}
