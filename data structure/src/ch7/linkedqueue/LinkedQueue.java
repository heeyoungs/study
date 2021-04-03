package ch7.linkedqueue;

public class LinkedQueue {
    private int currentCount;
    private LinkedQueueNode front;
    private LinkedQueueNode rear;
    public LinkedQueue(){
        currentCount = 0;
        front = null;
        rear = null;
    }
    public int enqueueLQ(char data){
        LinkedQueueNode newNode = new LinkedQueueNode(data);
        if(currentCount == 0){
             rear = newNode;
             front = newNode;
        }
        else{
            rear.setLink(newNode);
            rear = newNode;
        }
        currentCount++;
        return 1;
    }
    public LinkedQueueNode dequeueLQ(){
        LinkedQueueNode tempNode = null;
        if(isLinkedQueueEmpty() == 1){
            return null;
        }
        if(currentCount == 1){ // 남은 노드가 한 개 일때
            tempNode = front;
            front = null;
            rear = null;
        }
        else{ // 두 개 이상일 때
            tempNode = front;
            front = front.getLink();
        }
        currentCount--;
        return tempNode;
    }
    public LinkedQueueNode peekLQ(){
        if(isLinkedQueueEmpty() == 1){
            return null;
        }
        return front;
    }
    public int isLinkedQueueEmpty(){
        if(currentCount == 0){
            return 1;
        }
        else{
            return -1;
        }
    }
    public void deleteLQ(){
        front = null;
        rear = null;
        currentCount = 0;
    }
    public void disPlayLQ(){
        LinkedQueueNode tempNode = front;
        int i = 0;
        System.out.println("현재 노드 개수: " + currentCount);
        while(tempNode != null){
            System.out.println(i + "-" + tempNode.getData());
            i++;
            tempNode = tempNode.getLink();
        }
    }
}
