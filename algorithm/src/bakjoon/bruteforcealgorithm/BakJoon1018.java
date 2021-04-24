package bakjoon.bruteforcealgorithm;

import java.io.*;
// 체스판 다시 칠하기
public class BakJoon1018 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int height = Integer.parseInt(input[0]);
        int width = Integer.parseInt(input[1]);
        char[][] area = new char[width][height];

        for (int h = 0; h < height; h++) { // 판 색칠하기
            String lineInput = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = lineInput.charAt(w);
            }
        }


        int minCount = 64;
        for (int h = 0; h < height - 7; h++) {
            for (int w = 0; w < width - 7; w++) { // 왼쪽 위 꼭지점을 찾는다.
                int colorPoint1 = 0;
                int colorPoint2 = 0;
                // 여기서 좌~8 우~8 색칠할 개수를 찾기
                // 왼쪽 위 꼭지점 색깔이 B
                if (area[w][h] == 'B') {
                    for (int i = h; i < h + 8; i++) { // 체스판 색깔 탐색
                        for (int j = w; j < w + 8; j++) {
                            // 홀수라인
                            if ((j - w) % 2 == 1) {
                                // 홀수칸 -> B
                                if ((i - h) % 2 == 1) {
                                    if (area[j][i] == 'W') {
                                        colorPoint1++;
                                    }
                                    else{
                                        colorPoint2++;
                                    }
                                }
                                // 짝수칸 -> W
                                else {
                                    if (area[j][i] == 'B') {
                                        colorPoint1++;
                                    }else{
                                        colorPoint2++;
                                    }
                                }
                            }
                            // 짝수 라인
                            else {
                                // 홀수칸 -> W
                                if ((i - h) % 2 == 1) {
                                    if (area[j][i] == 'B') {
                                        colorPoint1++;
                                    }else{
                                        colorPoint2++;
                                    }
                                }
                                // 짝수칸 -> B
                                else {
                                    if (area[j][i] == 'W') {
                                        colorPoint1++;
                                    }else{
                                        colorPoint2++;
                                    }
                                }
                            }
                        }
                    }
                }
                // 왼쪽 위 꼭지점 색깔이 W
                else if (area[w][h] == 'W') {
                    for (int i = h; i < h + 8; i++) { // 체스판 색깔 탐색
                        for (int j = w; j < w + 8; j++) {
                            // 홀수라인
                            if ((j - w) % 2 == 1) {
                                // 홀수칸 -> W
                                if ((i - h) % 2 == 1) {
                                    if (area[j][i] == 'B') {
                                        colorPoint1++;
                                    }else{
                                        colorPoint2++;
                                    }
                                }
                                // 짝수칸 -> B
                                else {
                                    if (area[j][i] == 'W') {
                                        colorPoint1++;
                                    }else{
                                        colorPoint2++;
                                    }
                                }
                            }
                            // 짝수 라인
                            else {
                                // 홀수칸 -> B
                                if ((i - h) % 2 == 1) {
                                    if (area[j][i] == 'W') {
                                        colorPoint1++;
                                    }else{
                                        colorPoint2++;
                                    }
                                }
                                // 짝수칸 -> W
                                else {
                                    if (area[j][i] == 'B') {
                                        colorPoint1++;
                                    }else{
                                        colorPoint2++;
                                    }
                                }
                            }
                        }
                    }
                }
                int min;
                if (colorPoint1 > colorPoint2){
                    min = colorPoint2;
                } else{
                    min = colorPoint1;
                }

                if (minCount > min){
                    minCount = min;
                }
            }
        }
        bw.write(minCount + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
