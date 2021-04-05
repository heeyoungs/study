package bakjoon.queuealgorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BakJoon3078 {
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        int inputN = sc.nextInt();
        int inputK = sc.nextInt();
        int answer = 0;

        Queue<Integer>[] queue = new LinkedList[19];
        for (int i = 0; i < 19; i++) {
            queue[i] = new LinkedList<>();
        }

        for (int i = 0; i < inputN; i++) {
            String studentName = sc.next();
            int studentNameLength = studentName.length();
            while(!queue[studentNameLength-2].isEmpty()){
                int checkPoint = queue[studentNameLength - 2].peek();
                if (( i- checkPoint) > inputK) {
                    queue[studentNameLength-2].poll();
                    if(queue[studentNameLength-2].isEmpty()){
                        break;
                    }
                } else{
                    answer = answer + queue[studentNameLength-2].size();
                    break;
                }
            }
            queue[studentNameLength - 2].add(i);
        }

        System.out.println(answer);
    }
}