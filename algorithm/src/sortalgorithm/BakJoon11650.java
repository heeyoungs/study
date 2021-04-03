package sortalgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BakJoon11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        int[][] array = new int[inputNum][2];
        int pointX;
        int pointY;
        for (int i = 0; i < inputNum; i++) {
            pointX = sc.nextInt();
            pointY = sc.nextInt();
            array[i][0] = pointX;
            array[i][1] = pointY;
        }

        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    if (o1[1] > o2[1]) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        for (int i = 0; i < inputNum; i++) {
            System.out.println(array[i][0] + " " + array[i][1]);
        }
    }
}
