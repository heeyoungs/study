package bakjoon.sortalgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
// 시리얼 번호

public class BakJoon1431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();

        String array[] = new String[inputNum];
        for (int i = 0; i < inputNum; i++) {
            String inputString = sc.next();
            array[i] = inputString;
        }

        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) { // 1단계 길이 비교
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else { // 길이가 같다면!-> 2 단계 모든 자리수 합 비교
                    int o1Sum = 0;
                    int o2Sum = 0;
                    int temp;
                    // 합 구하기
                    for (int i = 0; i < o1.length(); i++) {
                        if (Character.isDigit(o1.charAt(i))) {
                            o1Sum = o1Sum + (int) (o1.charAt(i) - 48);
                        }
                    }
                    for (int i = 0; i < o1.length(); i++) {
                        if (Character.isDigit(o2.charAt(i))) {
                            o2Sum = o2Sum + (int) (o2.charAt(i) - 48);
                        }
                    }
                    // 2단계 시작 자리수 합 비교
                    if (o1Sum > o2Sum) {
                        return 1;
                    } else if (o1Sum < o2Sum) {
                        return -1;
                    } else { // 3단계 사전순 비교
                        return o1.compareTo(o2);
                    }
                }
            }
        });

        for (int i = 0; i < inputNum; i++) {
            System.out.println(array[i]);
        }
    }
}
