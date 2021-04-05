package bakjoon.stackalgorithm;

import java.io.*;
import java.util.Stack;

public class BakJoon10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputNum = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int ans = 0;
        for (int i = 0; i < inputNum; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                stack.pop();
                continue;
            } else {
                stack.push(input);
            }
        }

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        System.out.println(ans);
        br.close();
    }
}
