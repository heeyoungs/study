package bakjoon.bruteforcealgorithm;

import java.io.*;
import java.util.StringTokenizer;
// 덩치
public class BakJoon7568 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalNum = Integer.parseInt(st.nextToken());

        WH[] array = new WH[totalNum]; // 저장 배열 생성

        for (int i = 0; i < totalNum; i++) {
            array[i] = new WH();
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            array[i].weight = weight;
            array[i].height = height;
            array[i].grade = 1;
        }

        for (int i = 0; i < totalNum; i++) { // i 현재 대상
            for (int j = 0; j < totalNum; j++) { // 비교 대상
                if (array[j].weight > array[i].weight && array[j].height > array[i].height) { // 등수 증가
                    array[i].grade++;
                }
            }
        }

        for (int i = 0; i < totalNum; i++) {
            bw.write(array[i].grade + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class WH {
        int weight;
        int height;
        int grade;
    }
}
