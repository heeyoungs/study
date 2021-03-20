package ch3.singlelinkedlist;

public class LinkedListNode {
    LinkedListNode(int data){
        this.data = data;
    }
    private int data;
    LinkedListNode link;
    int getData(){
        return data;
    }

}
