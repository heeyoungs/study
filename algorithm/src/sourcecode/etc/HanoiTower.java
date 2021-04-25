package sourcecode.etc;

import java.math.BigInteger;
import java.util.Scanner;

public class HanoiTower {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BigInteger k = new BigInteger(String.valueOf(1));
        for(int i=0;i<N;i++){
            k = k.multiply(BigInteger.valueOf(2));
        }
        k = k.add(BigInteger.valueOf(-1));
        System.out.println(k);
        if (N > 20) {
            return;
        }
        hanoi('1', '2', '3', N);

        System.out.println(sb);
    }

    static void hanoi(char from, char temp, char to, int N) {
        if (N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(from,to,temp,N-1);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(temp,from,to,N-1);
    }
}
