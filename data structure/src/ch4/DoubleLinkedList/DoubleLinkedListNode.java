package ch4.DoubleLinkedList;

public class DoubleLinkedListNode {
    protected DoubleLinkedListNode Rlink,Llink;
    protected int data;

    DoubleLinkedListNode(int data){
        this.data = data;
        Rlink = Llink = null;
    }
}
