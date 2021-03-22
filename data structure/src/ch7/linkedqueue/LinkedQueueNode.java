package ch7.linkedqueue;

public class LinkedQueueNode {
    private char data;
    private LinkedQueueNode link;
    LinkedQueueNode(char data){
        this.data = data;
    }
    char getData(){
        return data;
    }
    void setLink(LinkedQueueNode link){
        this.link = link;
    }
    LinkedQueueNode getLink(){
        return link;
    }
}
