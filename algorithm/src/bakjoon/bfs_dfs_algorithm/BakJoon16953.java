package bakjoon.bfs_dfs_algorithm;

import java.util.Scanner;

// A->B
public class BakJoon16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = 1;
        while (a < b) {
            if (b % 2 == 0) {
                b = b / 2;
            } else if (b % 10 == 1) {
                b = b / 10;
            } else {
                break;
            }
            c++;
        }
        if (a==b)
        System.out.println(c);
        else System.out.println(-1);
    }
}
