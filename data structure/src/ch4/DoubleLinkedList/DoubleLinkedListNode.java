package ch4.doublelinkedlist;

public class DoubleLinkedListNode {
    DoubleLinkedListNode Rlink,Llink;
    private int data;
    int getData(){
        return data;
    }
    DoubleLinkedListNode(int data){
        this.data = data;
        Rlink = Llink = null;
    }
}
