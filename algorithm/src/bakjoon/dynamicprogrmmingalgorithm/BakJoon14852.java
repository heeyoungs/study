package bakjoon.dynamicprogrmmingalgorithm;

import java.util.Scanner;

public class BakJoon14852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();

        System.out.println(tileCount(inputNum));
    }

    public static long[][] d = new long[1000001][2];

    public static long tileCount(int num) {
        d[0][0] = 0;
        d[1][0] = 2;
        d[2][0] = 7;
        d[2][1] = 1;

        for (int i = 3; i <= num; i++) {
            d[i][1] = (d[i - 1][1] + d[i - 3][0]) % 1000000007;
            d[i][0] = (2 * d[i-1][0] + 3 * d[i-2][0] + 2 * d[i][1]) % 1000000007;
        }
        return d[num][0];
    }
}

//public static void main(String[] args) { // 시간 초과
//    Scanner sc = new Scanner(System.in);
//
//    int inputNum = sc.nextInt();
//
//    System.out.println(tileCount(inputNum));
//}
//
//public static int[] d = new int[1000001];
//
//public static int tileCount(int num) {
//    if (num == 0) return 1;
//    if (num == 1) return 2;
//    if (num == 2) return 7;
//    if (d[num] != 0) return d[num];
//    int result = 2 * tileCount(num - 1) + 3 * tileCount(num - 2);
//
//    for (int i = 3; i <= num; i++) {
//        result = (result + 2 * tileCount(num - i)) % 100000007 ;
//    }
//    return d[num] = result;
//}