package ch7.linkedqueue;

public class LinkedQueueNode {
    private char data;
    private LinkedQueueNode link;
    public LinkedQueueNode(char data){
        this.data = data;
    }
    public char getData(){
        return data;
    }
    public void setLink(LinkedQueueNode link){
        this.link = link;
    }
    public LinkedQueueNode getLink(){
        return link;
    }
}
