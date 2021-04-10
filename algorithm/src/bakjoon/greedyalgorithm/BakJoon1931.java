package bakjoon.greedyalgorithm;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class BakJoon1931 {
    public static void main(String[] args) throws IOException { // 거꾸로 생각하는 습관을 길러보자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputNum = Integer.parseInt(br.readLine());
        long startTime;
        long endTime;
        Meeting[] array = new Meeting[inputNum];

        for (int i = 0; i < inputNum; i++) {
            String[] input = br.readLine().split(" ");
            startTime = Long.parseLong(input[0]);
            endTime = Long.parseLong(input[1]);
            array[i] = new Meeting(startTime, endTime);
        }

        Arrays.sort(array, new Comparator<>() { // 종료시간을 기준으로 정렬한다 !! ㅜㅜ
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.endTime > o2.endTime) {
                    return 1;
                } else if (o1.endTime < o2.endTime) {
                    return -1;
                } else {
                    if (o1.startTime > o2.startTime) {
                        return 1;
                    } else if (o1.startTime < o2.startTime) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        int count = 1;
        long endTimePoint = array[0].endTime;

        for(int i=1;i<inputNum;i++){
            if(array[i].startTime >= endTimePoint ){
                endTimePoint = array[i].endTime;
                count++;
            }
        }

        bw.write(count + "");bw.flush();bw.close();br.close();
    }

    static public class Meeting {
        long startTime;
        long endTime;

        public Meeting(long startTime, long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
