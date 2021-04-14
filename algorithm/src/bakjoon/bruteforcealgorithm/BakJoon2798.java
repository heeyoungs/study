package bakjoon.bruteforcealgorithm;

import java.io.*;
import java.util.StringTokenizer;

public class BakJoon2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cardCount = Integer.parseInt(st.nextToken());
        int maxNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] array = new int[cardCount];

        for (int i = 0; i < cardCount; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int maxPoint = 0;
        for (int i = 0; i < cardCount; i++) {
            for (int j = i + 1; j < cardCount; j++) {
                for (int k = j + 1; k < cardCount; k++) {
                    if(array[i] + array[j] + array[k] > maxPoint && array[i] + array[j] + array[k] <= maxNum){
                        maxPoint = array[i] + array[j] + array[k];
                    }
                }
            }
        }
        bw.write(maxPoint + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
