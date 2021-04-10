package bakjoon.queuealgorithm;

import java.io.*;
import java.util.*;

public class BakJoon1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputNum = Integer.parseInt(br.readLine());


        for (int i = 0; i < inputNum; i++) {
            Queue<HeavyToIndex> queue = new LinkedList<>();
            int count = 0;

            String[] input = br.readLine().split(" ");
            int noteCount = Integer.parseInt(input[0]);
            int whereCount = Integer.parseInt(input[1]);

            String[] inputHeavy = br.readLine().split(" ");
            int[] heavyArray = new int[noteCount];

            for (int j = 0; j < noteCount; j++) {
                heavyArray[j] = Integer.parseInt(inputHeavy[j]);
            }

            for(int j=0;j<noteCount;j++){
                queue.add(new HeavyToIndex(heavyArray[j],j));
            }

            Arrays.sort(heavyArray);
            int index = heavyArray.length-1;

            do{
                HeavyToIndex kk = queue.poll();
                if(kk.heavy == heavyArray[index]){
                    count++;
                    if(kk.index == whereCount){
                        bw.write(count + "\n");
                        break;
                    }
                    index--;
                    continue;
                }
                queue.add(kk);
            }while(!queue.isEmpty());


        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static class HeavyToIndex {
        int heavy;
        int index;

        HeavyToIndex(int heavy, int index) {
            this.heavy = heavy;
            this.index = index;
        }
    }
}
