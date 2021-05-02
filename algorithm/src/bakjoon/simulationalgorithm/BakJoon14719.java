package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빗물
public class BakJoon14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken()); // 높이
        int width = Integer.parseInt(st.nextToken()); // 길이
        int[] array = new int[width];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < width; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 1; i < width - 1; i++) {
            int nowPoint = array[i];
            int leftPoint = array[0]; // 왼쪽의 최대값
            int startLeftFirst = 0;
            int startLeftLast = i - 1;
            // 왼쪽 탐색
            for (int k = startLeftFirst; k <= startLeftLast; k++) {
                leftPoint = Math.max(leftPoint, array[k]);
            }

            int rightPoint = array[i + 1]; // 오른쪽의 최대값
            int startRightFirst = i + 1;
            int startRightLast = width - 1;
            // 오른쪽 탐색
            for (int k = startRightFirst; k <= startRightLast; k++) {
                rightPoint = Math.max(rightPoint, array[k]);
            }
            if (nowPoint < leftPoint && nowPoint < rightPoint){
                sum += Math.min(leftPoint,rightPoint) - nowPoint;
            }
        }
        System.out.println(sum);
    }
}
