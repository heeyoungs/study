package sortalgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BakJoon1427 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next(); // 문자열 입력 받기
        char[] array = input.toCharArray(); // char배열로 변환

        Arrays.sort(array); // char배열 정렬
        input = String.valueOf(array); // char배열 String으로 변환

        StringBuffer sb = new StringBuffer(input);
        String reversedStr = sb.reverse().toString(); // String 역순으로 변환

        System.out.println(reversedStr); // 출력
        System.out.println();
    }
}
