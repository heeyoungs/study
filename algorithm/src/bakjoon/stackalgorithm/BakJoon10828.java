package bakjoon.stackalgorithm;

import java.io.*;

public class BakJoon10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack stack = new Stack();

        int inputNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputNum; i++) {
            String[] inputString = br.readLine().split(" ");
            if (inputString[0].equals("push")) {
                int input = Integer.parseInt(inputString[1]);
                stack.push(input);
            } else if (inputString[0].equals("pop")) {
                bw.write(stack.pop() + "\n");
            } else if (inputString[0].equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (inputString[0].equals("empty")) {
                bw.write(stack.empty() + "\n");
            } else if (inputString[0].equals("top")) {
                bw.write(stack.top() + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static public class StackNode {
        int data;
        StackNode link;

        StackNode(int data) {
            this.data = data;
        }
    }

    static public class Stack {
        StackNode top;
        int currentCount;

        Stack() {
            top = null;
            currentCount = 0;
        }

        void push(int data) {
            StackNode newNode = new StackNode(data);
            if (empty() == 1) {
                top = newNode;
            } else {
                newNode.link = top;
                top = newNode;
            }
            currentCount++;
        }

        int pop() {
            if (empty() == 1) {
                return -1;
            } else {
                int ret = top.data;
                top = top.link;
                currentCount--;
                return ret;
            }
        }

        int size() {
            return currentCount;
        }

        int empty() {
            if (currentCount == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int top() {
            if(empty()==1){
                return -1;
            }
            return top.data;
        }
    }
}