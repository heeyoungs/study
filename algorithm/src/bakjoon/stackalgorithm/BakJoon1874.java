package bakjoon.stackalgorithm;

import java.io.*;
import java.util.Stack;
// 스택 수열
public class BakJoon1874 { // BufferedWriter을 쓸 경우 버퍼에 일정이상 채워지면 비정기적으로 flush -> 오류
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int inputNum = Integer.parseInt(br.readLine());

        int[] array = new int[inputNum];
        for (int i = 0; i < inputNum; i++) {
            int input = Integer.parseInt(br.readLine());
            array[i] = input;
        }

        int index = 0;
        int checkPoint = array[0];

        for (int i = 1; i <= inputNum; i++) {
            if (!stack.isEmpty() && stack.peek() == checkPoint ) {
                stack.pop();
                //bw.write("-\n");
                sb.append("-\n");
                index++;
                checkPoint = array[index];
                i=i-1;
                continue;
            }
            stack.push(i);
            //bw.write("+\n");
            sb.append("+\n");
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == checkPoint) {
                stack.pop();
                //bw.write("-\n");
                sb.append("-\n");
                index++;
                if(index < inputNum) {
                    checkPoint = array[index];
                }
            } else {
                System.out.println("NO");
                return;
            }
        }

//        bw.flush();
//        bw.close();
        System.out.println(sb);
        br.close();
    }
}
