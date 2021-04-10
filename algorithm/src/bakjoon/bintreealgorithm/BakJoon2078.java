package bakjoon.bintreealgorithm;

import bakjoon.sortalgorithm.BakJoon10814;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BakJoon2078 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int[] b = new int[1023];

        n = sc.nextInt();
        int num = (1<<n) -1;
        for(int i=0;i<num;i++){
            b[i] = sc.nextInt();
        }
        while(true){
            n--;
            int cnt = (1<<n+1);
            for(int i=(cnt-1)/2;i<num;i+=cnt) System.out.print(b[i] + " ");
            System.out.println();
            if (n==0){
                break;
            }
        }
    }
}
