package bakjoon.dividealgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 색종이 만들기
public class BakJoon2630 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        area = new int[input][input];
        for (int h = 0; h < input; h++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int w = 0; w < input; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }

        // 4등분하고 안에 안겹치는게 있는지 확인하고 반복 ㄱ
        divide(0, input - 1, 0, input - 1);

        System.out.print(whiteCount + "\n" + blueCount);
    }

    static int[][] area;
    static int whiteCount = 0;
    static int blueCount = 0;

    static void divide(int startX, int endX, int startY, int endY) {
        boolean isBlue = true;
        boolean isWhite = true;
        // 색 검사
        for (int y = startY; y <= endY; y++) {
            for (int x = startX; x <= endX; x++) {
                if (area[x][y] != 0) {
                    isWhite = false;
                }
                if (area[x][y] != 1) {
                    isBlue = false;
                }
            }
        }

        int middleX = (startX + endX) / 2;
        int middleY = (startY + endY) / 2;
        if (isBlue) {
            blueCount++;
        } else if (isWhite) {
            whiteCount++;
        }
        // 거짓이 나올시 -> 4등분 재귀
        else {
            divide(startX, middleX, startY, middleY); // 좌 상
            divide(middleX + 1, endX, startY, middleY); // 우 상
            divide(startX, middleX, middleY + 1, endY); // 좌 하
            divide(middleX + 1, endX, middleY + 1, endY); // 우 하
        }
    }
}
