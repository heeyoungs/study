package ch4.UseList;

public class LinkedListNode {
    protected LinkedListNode link;
    protected DataBox data;
    LinkedListNode(DataBox data){
        this.data = data;
        this.link = null;
    }
}
