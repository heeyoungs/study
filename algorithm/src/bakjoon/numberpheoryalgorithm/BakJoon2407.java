package bakjoon.numberpheoryalgorithm;

import java.math.BigInteger;
import java.util.Scanner;

// 조합 nCr = n-1Cr-1 + n-1Cr
public class BakJoon2407 {
    static BigInteger dp[][] = new BigInteger[101][101];
    public static void main(String[] args) {
        for(int i=0;i<=100;i++){
            for(int j=0;j<=100;j++){
                dp[i][j] = new BigInteger(String.valueOf(0));
            }
        }
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.println(combine(N,M));
    }
    static BigInteger combine(int N,int M){
        if ( N == M || M <= 0 ){
            return BigInteger.valueOf(1);
        }
        if (!dp[N][M].equals(BigInteger.valueOf(0))){
            return dp[N][M];
        }

        return dp[N][M] = new BigInteger(String.valueOf(combine(N-1,M).add(combine(N-1,M-1))));
    }
}
