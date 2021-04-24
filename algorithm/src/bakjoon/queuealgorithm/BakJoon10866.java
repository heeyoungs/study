package bakjoon.queuealgorithm;

import java.io.*;
// 덱
public class BakJoon10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque deque = new Deque();

        int inputNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputNum; i++) {
            String[] inputString = br.readLine().split(" ");
            if (inputString[0].equals("push_front")) {
                int input = Integer.parseInt(inputString[1]);
                deque.push_front(input);
            }else if (inputString[0].equals("push_back")) {
                int input = Integer.parseInt(inputString[1]);
                deque.push_back(input);
            } else if (inputString[0].equals("pop_front")) {
                bw.write(deque.pop_front() + "\n");
            } else if (inputString[0].equals("pop_back")) {
                bw.write(deque.pop_back() + "\n");
            }else if (inputString[0].equals("size")) {
                bw.write(deque.size() + "\n");
            } else if (inputString[0].equals("empty")) {
                bw.write(deque.empty() + "\n");
            } else if (inputString[0].equals("front")) {
                bw.write(deque.front() + "\n");
            } else if (inputString[0].equals("back")) {
                bw.write(deque.back() + "\n");
            }
        }
        bw.flush();bw.close();br.close();
    }

    static public class DequeNode {
        int data;
        DequeNode Llink;
        DequeNode Rlink;
        DequeNode(int data){
            this.data = data;
        }
    }

    static public class Deque {
        DequeNode front;
        DequeNode rear;
        int currentCount;

        Deque() {
            front = null;
            rear = null;
            currentCount = 0;
        }

        void push_front(int data) {
            DequeNode newNode = new DequeNode(data);
            if (empty() == 1){
                front = newNode;
                rear = newNode;
            } else{
                front.Llink = newNode;
                newNode.Rlink = front;
                front = newNode;
            }
            currentCount++;
        }

        void push_back(int data) {
            DequeNode newNode = new DequeNode(data);
            if (empty() == 1){
                front = newNode;
                rear = newNode;
            } else{
                rear.Rlink = newNode;
                newNode.Llink = rear;
                rear = newNode;
            }
            currentCount++;
        }

        int pop_front() {
            if(empty() == 1){
                return -1;
            } else{
                int ret = front.data;
                front = front.Rlink;
                currentCount--;
                return ret;
            }
        }

        int pop_back() {
            if(empty() == 1){
                return -1;
            } else{
                int ret = rear.data;
                rear = rear.Llink;
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
