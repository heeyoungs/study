package bakjoon.greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BakJoon1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();
        int startTime;
        int endTime;
        Meeting[] array = new Meeting[inputNum];

        for (int i = 0; i < inputNum; i++) {
            startTime = sc.nextInt();
            endTime = sc.nextInt();
            array[i] = new Meeting(startTime, endTime);
        }

        Arrays.sort(array, new Comparator<>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.startTime > o2.startTime) {
                    return 1;
                } else if (o1.startTime < o2.startTime) {
                    return -1;
                } else {
                    if (o1.endTime > o2.endTime) {
                        return 1;
                    } else if (o1.endTime < o2.endTime) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
//        Arrays.sort(array, new Comparator<Meeting>() {
//            @Override
//            public int compare(Meeting o1, Meeting o2) {
//                if(o1.endTime - o1.startTime > o2.endTime - o2.startTime){
//                    return 1;
//                } else if(o1.endTime - o1.startTime < o2.endTime - o2.startTime){
//                    return -1;
//                } else {
//                    if (o1.startTime > o2.startTime) {
//                        return 1;
//                    } else if (o1.startTime < o2.startTime) {
//                        return -1;
//                    } else{
//                        if (o1.endTime > o2.endTime) {
//                            return 1;
//                        } else if (o1.endTime < o2.endTime) {
//                            return -1;
//                        } else {
//                            return 0;
//                        }
//                    }
//                }
//            }
//        });

        for (int i = 0; i < inputNum; i++) {
            System.out.println(array[i].startTime + " " + array[i].endTime);
        }
    }

    static public class Meeting {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
