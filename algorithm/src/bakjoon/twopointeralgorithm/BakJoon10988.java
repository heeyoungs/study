package bakjoon.twopointeralgorithm;

import java.util.Scanner;

// 팰린드롬인지 확인하기 -> 팰린드롬이란? 좌우 대칭!
public class BakJoon10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        boolean check = true;
        int start = 0;
        int end = input.length() - 1;
        for (int i=0;i<input.length()/2;i++){
            if (input.charAt(start) != input.charAt(end)){
                check = false;
            }
            start++;
            end--;
        }
        if (check){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
