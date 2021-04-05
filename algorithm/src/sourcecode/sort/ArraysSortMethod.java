package sourcecode.sort;

import java.util.Arrays;
import java.util.Collections;

public class ArraysSortMethod {
    static int[] data = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};

    public static void main(String[] args) {
        Arrays.sort(data); // 매개값 두개를 더 넣어 일부만 정리도 가능
        //Arrays.sort(data, Collections.reverseOrder()); // 기본타입은 사용 불가 int -> Integer
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
