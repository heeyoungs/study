package bakjoon.stackalgorithm;

import java.io.*;
import java.util.Stack;
// 쇠막대기
public class BakJoon10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        int answer = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' && input.charAt(i + 1) == ')') {
                answer = answer + stack.size();
                i = i + 1;
                continue;
            }

            if (input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                answer = answer + 1;
                stack.pop();
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
