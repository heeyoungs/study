package bakjoon.greedyalgorithm;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class BakJoon1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int count = 0;
            int personNum = Integer.parseInt(br.readLine());
            PersonDegree[] array = new PersonDegree[personNum];

            for (int j = 0; j < personNum; j++) {
                String[] input = br.readLine().split(" ");
                array[j] = new PersonDegree(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }
            Arrays.sort(array, new Comparator<PersonDegree>() {
                @Override
                public int compare(PersonDegree o1, PersonDegree o2) {
                    if (o1.testA > o2.testA) {
                        return 1;
                    } else if (o1.testA < o2.testA) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });

            int minPoint = personNum + 1;

            for(int j=0;j<personNum;j++){
                if(array[j].testB < minPoint){
                    minPoint = array[j].testB;
                    count ++;
                }
            }


            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static class PersonDegree {
        int testA;
        int testB;

        PersonDegree(int testA, int testB) {
            this.testA = testA;
            this.testB = testB;
        }
    }
}
