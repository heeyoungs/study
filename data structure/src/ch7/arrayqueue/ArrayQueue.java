package ch7.arrayqueue;

import ch5.arraystack.IndexException;

public class ArrayQueue {
    private int currentCount;
    private int maxCount;
    private int front;
    private int rear;
    ArrayQueueNode[] element = null;
    ArrayQueue(int count) throws IndexException{
        if(count<0){
            throw new IndexException("0보다 작은 숫자가 입력됨");
        }
        this.maxCount = count;
        this.currentCount = 0;
        this.front = -1;
        this.rear = -1;
        this.element = new ArrayQueueNode[count];
    }
    int enqueueAQ(char data){
        if(isArrayQueueFull() == 1){ // 배열이 꽉차 있다!
            return -1;
        }
        rear++;
        element[rear] = new ArrayQueueNode();
        element[rear].setData(data);
        currentCount++;
        return 1;
    }
    ArrayQueueNode dequeueAQ(){
        ArrayQueueNode data = null;
        if(isArrayQueueEmpty() == 1){
            return null;
        }
        if(front != -1){
            element[front] = null;
        }
        front++;
        data = element[front];
        currentCount--;
        return data;
    }
    ArrayQueueNode peekAQ(){
        if(isArrayQueueEmpty() == 1){
            return null;
        }
        return element[front+1];
    }
    int isArrayQueueEmpty(){
        if(currentCount == 0){
            return 1;
        }
        return -1;
    }
    int isArrayQueueFull(){
        if(rear == maxCount-1 ||  currentCount == maxCount){
            return 1;
        }
        else{
            return -1;
        }
    }
    void deleteAQ(){
        for(int i=0;i<maxCount;i++){
            element[i] = null;
        }
        front = -1;
        rear = -1;
        currentCount = 0;
    }
    void disPlayAQ(){
        if(currentCount==0){
            System.out.println("큐가 비어있습니다.");
            return;
        }
        System.out.println("큐의 크기: " + maxCount + ", 현재 노드 개수: " + currentCount);
        for(int i = front+1;i<=rear;i++){
            System.out.println(i + "-" + element[i].getData());
        }
    }
}
