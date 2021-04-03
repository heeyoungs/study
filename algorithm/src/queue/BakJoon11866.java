package queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BakJoon11866 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        int inputN = sc.nextInt();
        int inputK = sc.nextInt();

        for (int i = 0; i < inputN; i++) {
            queue.add(i + 1);
        }

        int arrayCount = 0;
        int queueKresult;
        int[] array = new int[inputN];
        while(!queue.isEmpty()){
            for(int i=0;i<inputK-1;i++) {
                queueKresult = queue.poll();
                queue.add(queueKresult);
            }
            queueKresult = queue.poll();
            array[arrayCount] = queueKresult;
            arrayCount++;
        }

        System.out.print("<");
        for(int i=0;i<inputN-1;i++){
                System.out.print(array[i] + ", ");
        }
        System.out.print(array[inputN-1] + ">");
    }
}
