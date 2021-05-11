package bakjoon.dynamicprogrmmingalgorithm;

import java.math.BigInteger;
import java.util.Scanner;

// Generations of Tribbles
public class BakJoon9507 {
    static BigInteger[] fibonacci = new BigInteger[68];

    public static void main(String[] args) {
        for(int i=0;i<=67;i++){
            fibonacci[i] = new BigInteger(String.valueOf(0));
        }
        fibonacci[0] = new BigInteger(String.valueOf(1));
        fibonacci[1] = new BigInteger(String.valueOf(1));
        fibonacci[2] = new BigInteger(String.valueOf(2));
        fibonacci[3] = new BigInteger(String.valueOf(4));
        fibo(67);
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCase = sc.nextInt();
        for(int i=0;i<testCase;i++){
            int n = sc.nextInt();
            sb.append(fibonacci[n]).append("\n");
        }
        System.out.println(sb);
    }

    static BigInteger fibo(int N){
        if (!fibonacci[N].equals(BigInteger.valueOf(0))){
            return fibonacci[N];
        }
        return fibonacci[N] = fibo(N-1).add(fibo(N-2)).add(fibo(N-3)).add(fibo(N-4));
    }
}
