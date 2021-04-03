package ch11.linkedgraph;

public class LinkedListNode {
    LinkedListNode(int data){
        this.data = data;
        this.link = null;
    }
    private int data;
    private LinkedListNode link;
    int getData(){
        return data;
    }
    void setLink(LinkedListNode link){
        this.link = link;
    }
    LinkedListNode getLink(){
        return link;
    }
}
