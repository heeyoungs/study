package bakjoon.bruteforcealgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BakJoon2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[9];
        for (int i = 0; i < 9; i++) {
            int input = Integer.parseInt(br.readLine());
            array[i] = input;
        }
        Arrays.sort(array);
        Outter:
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                for (int t = j + 1; t < 5; t++) {
                    for (int k = t + 1; k < 6; k++) {
                        for (int q = k + 1; q < 7; q++) {
                            for (int p = q + 1; p < 8; p++) {
                                for (int m = p + 1; m < 9; m++) {
                                    int sum = array[i] + array[j] + array[t] + array[k] + array[q] + array[p] + array[m];
                                    if (sum == 100) {
                                        System.out.println(array[i]);
                                        System.out.println(array[j]);
                                        System.out.println(array[t]);
                                        System.out.println(array[k]);
                                        System.out.println(array[q]);
                                        System.out.println(array[p]);
                                        System.out.println(array[m]);
                                        break Outter;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
