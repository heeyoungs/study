package ch7.arraycirclequeue;

import ch5.arraystack.IndexException;

public class ArrayCircleQueue {
    private int currentCount;
    private int maxCount;
    private int front;
    private int rear;
    private ArrayCircleQueueNode[] element = null;
    public ArrayCircleQueue(int count) throws IndexException {
        if(count<0){
            throw new IndexException("0보다 작은 숫자가 입력됨");
        }
        this.maxCount = count;
        this.currentCount = 0;
        this.front = -1;
        this.rear = -1;
        this.element = new ArrayCircleQueueNode[count];
    }
    public int enqueueAQ(char data){
        if(isArrayQueueFull() == 1){ // 배열이 꽉차 있다!
            return -1;
        }
        rear = (rear+1) % maxCount;
        element[rear] = new ArrayCircleQueueNode();
        element[rear].setData(data);
        currentCount++;
        return 1;
    }
    public ArrayCircleQueueNode dequeueAQ(){
        ArrayCircleQueueNode data = null;
        if(isArrayQueueEmpty() == 1){
            return null;
        }
        if(front != -1){
            element[front] = null;
        }
        front=(front+1)%maxCount;
        data = element[front];
        currentCount--;
        return data;
    }
    public ArrayCircleQueueNode peekAQ(){
        if(isArrayQueueEmpty() == 1){
            return null;
        }
        return element[front+1];
    }
    public int isArrayQueueEmpty(){
        if(currentCount == 0){
            return 1;
        }
        return -1;
    }
    public int isArrayQueueFull(){
        if(currentCount == maxCount){
            return 1;
        }
        else{
            return -1;
        }
    }
    public void deleteAQ(){
        for(int i=0;i<maxCount;i++){
            element[i] = null;
        }
        front = -1;
        rear = -1;
        currentCount = 0;
    }
    public void disPlayAQ(){
        if(currentCount==0){
            System.out.println("큐가 비어있습니다.");
            return;
        }
        System.out.println("큐의 크기: " + maxCount + ", 현재 노드 개수: " + currentCount);
        for(int i = front+1;i<=front+currentCount;i++){
            int position = i % maxCount;
            System.out.println(position + "-" + element[position].getData());
        }
    }
}
