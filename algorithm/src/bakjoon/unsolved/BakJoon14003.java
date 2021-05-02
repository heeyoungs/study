package bakjoon.unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 5 -> 모르겠음
public class BakJoon14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[1000002];
        int[] save = new int[1000002];
        int[] mem = new int[1000002];

        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        save[1] = array[1];
        int maxIndex = 0;
        int savePoint = 1;
        for (int i = 1; i <= N; i++) {
            if (array[i] > save[savePoint]) {
                savePoint++;
                save[savePoint] = array[i];
                mem[savePoint] = array[i];
            } else {
                int low = 1;
                int high = savePoint;
                while (low <= high) {
                    int mid = (low + high) / 2;

                    if (array[i] > save[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                save[low] = array[i];
            }
        }
        for (int i=1;i<5;i++){
            System.out.println(mem[i]);
        }
//
//        sb.append(savePoint).append("\n");
//        Stack<Integer> stack = new Stack<>();
//        while (maxIndex != 0) {
//            stack.push(array[maxIndex]);
//            maxIndex = mem[maxIndex];
//        }
//        while (!stack.isEmpty()) {
//            sb.append(stack.pop()).append(" ");
//        }
//        System.out.println(sb);
    }
}
