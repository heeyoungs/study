package ch7.linkeddeque;

public class LinkedDeque {
    private int currentCount;
    private LinkedDequeNode front;
    private LinkedDequeNode rear;
    public LinkedDeque(){
        currentCount = 0;
        front = null;
        rear = null;
    }
    public int insertFront(char data){
        LinkedDequeNode newNode = new LinkedDequeNode(data);
        if(currentCount == 0){
            rear = newNode;
            front = newNode;
        }
        else{
            newNode.setLink(front);
            front = newNode;
        }
        currentCount++;
        return 1;
    }
    public int inserRear(char data){
        LinkedDequeNode newNode = new LinkedDequeNode(data);
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
    public LinkedDequeNode deleteFront(){
        LinkedDequeNode tempNode = null;
        if(isDQEmpty() == 1){
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
    public LinkedDequeNode deleteRear(){
        LinkedDequeNode tempNode = null;
        if(isDQEmpty() == 1){
            return null;
        }
        if(currentCount == 1){ // 남은 노드가 한 개 일때
            tempNode = rear;
            front = null;
            rear = null;
        }
        else{
            tempNode = rear;
            LinkedDequeNode tempPreNode = front;
            while(tempPreNode.getLink() != rear){
                tempPreNode=tempPreNode.getLink();
            }
            rear = tempPreNode;
            tempPreNode.setLink(null);
        }
        currentCount--;
        return tempNode;
    }
    public LinkedDequeNode peekFront(){
        if(isDQEmpty() == 1){
            return null;
        }
        return front;
    }
    public LinkedDequeNode peekRear(){
        if(isDQEmpty() == 1){
            return null;
        }
        return rear;
    }
    public int isDQEmpty(){
        if(currentCount == 0){
            return 1;
        }
        else{
            return -1;
        }
    }
    public void deleteDQ(){
        front = null;
        rear = null;
        currentCount = 0;
    }
    public void disPlayDQ(){
        LinkedDequeNode tempNode = front;
        int i = 0;
        System.out.println("현재 노드 개수: " + currentCount);
        while(tempNode != null){
            System.out.println(i + "-" + tempNode.getData());
            i++;
            tempNode = tempNode.getLink();
        }
    }
}