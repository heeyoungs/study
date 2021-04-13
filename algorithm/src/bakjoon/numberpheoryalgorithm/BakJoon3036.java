package bakjoon.numberpheoryalgorithm;

import java.io.*;

public class BakJoon3036 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ringCount = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arrayLength = new int[ringCount];
        for (int i = 0; i < ringCount; i++) {
            arrayLength[i] = Integer.parseInt(input[i]);
        }

        int startRing = arrayLength[0];
        for (int i = 1; i < ringCount; i++) { // 두 번째 링부터의 검사
            int checkPoint = 0; // 최대 공약수

            int min;
            if (startRing > arrayLength[i]) {
                min = arrayLength[i];
            } else {
                min = startRing;
            }

            for (int k = min; k > 0; k--) {
                if (startRing % k == 0 && arrayLength[i] % k == 0){
                    checkPoint = k;
                    break;
                }
            }

            bw.write(startRing/checkPoint + "/" + arrayLength[i]/checkPoint + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}