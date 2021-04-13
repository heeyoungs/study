package bakjoon.numberpheoryalgorithm;
/*
1) 유클리드 호제법
두 정수 a, b의 최대공약수를 G(a, b)라고 하자.

정수 a, b, q r (b ≠ 0)에 대하여 a = bq + r,이면 G(a, b) = G(b, r)가 성립한다

2) 유클리드 호제법의 사용
유클리드 호제법은 큰 수들의 최대공약수를 구할 때 사용할 수 있다.

a = bq + r 에서 r = a - bq 이므로 G(a, b) = G(a, a - bq)이다. 이제 직접 적용을 해보자.
(예) G(180, 200) = G(180, 200 - 180) = G(180, 20) = G(180 - 20 × 8, 20) = G(20, 20) = 20
*/

import java.io.*;
import java.util.Arrays;

public class BakJoon2981 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int NumberCount = Integer.parseInt(br.readLine());
        int[] arr = new int[NumberCount];
        for (int num = 0; num < NumberCount; num++) { // 정수 입력 받기
            arr[num] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // 오름차순 정렬

        int check = arr[1] - arr[0]; // 차이
        for (int num = 2; num < NumberCount; num++) {
            int point = arr[num] - arr[num - 1]; // 차이
            check = UH(check, point); // 차이끼리의 최대공약수,-> 구한값과 차이의 최대공약수..
        }

        for (int i = 2; i <= check; i++) {
            if (check % i == 0) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int UH(int x, int y) { // 유클리드 호제법
        if (x % y == 0) {
            return y; // 최대 공약수
        } else { // 무조건 x가 더 크다는 가정
            int k = x / y;
            x = x - (y * k);
            return UH(y, x);
        }
    }
}
