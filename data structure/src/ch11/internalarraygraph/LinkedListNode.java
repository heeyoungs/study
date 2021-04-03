package ch11.internalarraygraph;

public class LinkedListNode {
    public LinkedListNode(int data){
        this.data = data;
        this.link = null;
    }
    private int data;
    private LinkedListNode link;
    public int getData(){
        return data;
    }
    public void setLink(LinkedListNode link){
        this.link = link;
    }
    public LinkedListNode getLink(){
        return link;
    }
}