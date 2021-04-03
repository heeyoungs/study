package ch11.internalarraygraph;

public class LinkedQueueNode {
    private int data;
    private LinkedQueueNode link;
    public LinkedQueueNode(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }
    public void setLink(LinkedQueueNode link){
        this.link = link;
    }
    public LinkedQueueNode getLink(){
        return link;
    }
}
