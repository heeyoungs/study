package sortalgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BakJoon1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        String[] array = new String[input];
        for (int i = 0; i < input; i++) {
            String inputString = sc.next();
            array[i] = inputString;
        }
        // 여기까지 입력부분


        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });


        // 여기부터 출력 부분
        for (int i = 0; i < input; i++) {
            if (i < input - 1 && array[i].equals(array[i + 1])) {
                continue;
            }
            System.out.println(array[i]);
        }
    }
}
