package bakjoon.queuealgorithm;

import java.io.*;

public class BakJoon10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue queue = new Queue();

        int inputNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputNum; i++) {
            String[] inputString = br.readLine().split(" ");
            if (inputString[0].equals("push")) {
                int input = Integer.parseInt(inputString[1]);
                queue.push(input);
            } else if (inputString[0].equals("pop")) {
                bw.write(queue.pop() + "\n");
            } else if (inputString[0].equals("size")) {
                bw.write(queue.size() + "\n");
            } else if (inputString[0].equals("empty")) {
                bw.write(queue.empty() + "\n");
            } else if (inputString[0].equals("front")) {
                bw.write(queue.front() + "\n");
            } else if (inputString[0].equals("back")) {
                bw.write(queue.back() + "\n");
            }
        }
        bw.flush();bw.close();br.close();
    }

    static public class QueueNode {
        int data;
        QueueNode link;
        QueueNode(int data){
            this.data = data;
        }
    }

    static public class Queue {
        QueueNode front;
        QueueNode rear;
        int currentCount;

        Queue() {
            front = null;
            rear = null;
            currentCount = 0;
        }

        void push(int data) {
            QueueNode newNode = new QueueNode(data);
            if (empty() == 1){
                front = newNode;
                rear = newNode;
            } else{
                rear.link = newNode;
                rear = newNode;
            }
            currentCount++;
        }

        int pop() {
            if(empty() == 1){
                return -1;
            } else{
                int ret = front.data;
                front = front.link;
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

        int front() {
            if(empty() == 1){
                return -1;
            }else{
                return front.data;
            }
        }

        int back() {
            if(empty() == 1){
                return -1;
            }else{
                return rear.data;
            }
        }
    }
}