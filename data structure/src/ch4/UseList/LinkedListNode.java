package ch4.uselist;

public class LinkedListNode {
    private LinkedListNode link;
    private DataBox data;
    LinkedListNode(DataBox data){
        this.data = data;
        this.link = null;
    }
    DataBox getData(){
        return data;
    }
    LinkedListNode getLink(){
        return link;
    }
    void setLink(LinkedListNode link){
        this.link = link;
    }
}
