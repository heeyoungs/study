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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BakJoon9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int k = 0; k < testCase; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numCount = Integer.parseInt(st.nextToken()); // 정수의 개수
            int[] array = new int[numCount];
            for (int i = 0; i < numCount; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            } // 입력받은 숫자들로 정수 배열 생성
            long sumOfGCD = 0;
            for (int i = 0; i < numCount; i++) {
                for (int j = i + 1; j < numCount; j++) {
                    if (array[i] > array[j]) {
                        sumOfGCD += UH(array[i], array[j]);
                    }else{
                        sumOfGCD += UH(array[j],array[i]);
                    }
                }
            }
            sb.append(sumOfGCD + "\n");
        }
        System.out.print(sb);
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
