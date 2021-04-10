package bakjoon.stackalgorithm;

import java.io.*;
import java.util.Stack;

public class BakJoon2504_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputLine = br.readLine();

        int answer = 0;
        int count = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputLine.length(); i++) {
            if (inputLine.charAt(i) == ')') {
                stack.pop();
                if(count == 0){
                    count = count + 2;
                } else {
                    count = count * 2;
                }
            } else if (inputLine.charAt(i) == '(') {
                stack.push('(');
                answer = answer + count;
                count = 0;
            } else if (inputLine.charAt(i) == ']') {
                stack.pop();
                if(count == 0){
                    count = count + 3;
                } else {
                    count = count * 3;
                }
            } else if (inputLine.charAt(i) == '[') {
                stack.push('[');
                answer = answer + count;
                count = 0;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
