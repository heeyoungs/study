package bakjoon.backtrackingalgorithm;

import java.util.Scanner;

public class BakJoon9663 {
    static boolean[] visit;
    static int N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            nQueen(i, 0);
        }
        System.out.println(count);
    }

    static void nQueen(int n, int depth) {
        if (depth == N) {
            return;
        }

        for (int i = 0; i < N; i++) {

        }
    }
}
