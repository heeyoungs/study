package bakjoon.sortalgorithm;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class BakJoon18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputNum = Integer.parseInt(br.readLine());

        String[] inputLine = br.readLine().split(" ");

        XPointToIndex[] array = new XPointToIndex[inputNum];

        for (int i = 0; i < inputNum; i++) {
            array[i] = new XPointToIndex(Integer.parseInt(inputLine[i]), i);
        }

        Arrays.sort(array, new Comparator<XPointToIndex>() {
            @Override
            public int compare(XPointToIndex o1, XPointToIndex o2) {
                if (o1.XPoint > o2.XPoint) {
                    return 1;
                } else if (o1.XPoint < o2.XPoint) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int startPoint = 0;
        int minPoint = array[0].XPoint;
        array[0].XPoint = startPoint;

        for(int i=1;i<inputNum;i++){
            if(array[i].XPoint == minPoint){
                array[i].XPoint = startPoint;
            } else {
                startPoint++;
                minPoint = array[i].XPoint;
                array[i].XPoint = startPoint;
            }
        }

        Arrays.sort(array, new Comparator<XPointToIndex>() {
            @Override
            public int compare(XPointToIndex o1, XPointToIndex o2) {
                if ( o1.index > o2.index) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for(int i=0;i<inputNum;i++){
            bw.write(array[i].XPoint + " ");
        }
        bw.flush();bw.close();br.close();
    }

    public static class XPointToIndex {
        int XPoint;
        int index;

        XPointToIndex(int XPoint, int index) {
            this.XPoint = XPoint;
            this.index = index;
        }
    }
}
