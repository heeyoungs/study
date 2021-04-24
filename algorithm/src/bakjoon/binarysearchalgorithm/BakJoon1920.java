package bakjoon.binarysearchalgorithm;

import java.io.*;
import java.util.Arrays;
// 수 찾기
public class BakJoon1920 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int searchNum = Integer.parseInt(br.readLine());

        String[] inputLine = br.readLine().split(" ");
        int[] array = new int[inputLine.length];

        for (int i = 0; i < inputLine.length; i++) {
            array[i] = Integer.parseInt(inputLine[i]);
        }

        Arrays.sort(array);

        int checkNum = Integer.parseInt(br.readLine());
        String[] checkLine = br.readLine().split(" ");
        int[] checkLineArray = new int[checkLine.length];

        for(int i=0;i<checkLine.length;i++){
            checkLineArray[i] = Integer.parseInt(checkLine[i]);
        }

        for(int i=0;i<checkLine.length;i++){
            search(array,0, inputLine.length-1,checkLineArray[i] );
            bw.write(k + "\n");
            k = 0;
        }

        bw.flush();
        bw.close();
        br.close();

    }
    static int k = 0;
    public static void search(int[] array, int start, int end, int check) {
        if (start < end) {
            int middle = (start + end) / 2;
            if (check == array[middle] || check == array[start] || check == array[end]) {
                k = 1;
                return;
            } else if (check < array[middle]) {
                search(array,start,middle,check);
            } else if (check > array[middle]){
                search(array,middle+1,end,check);
            }
        }
    }
}
