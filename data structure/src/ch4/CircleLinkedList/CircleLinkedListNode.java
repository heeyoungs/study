package ch4.circlelinkedlist;

public class CircleLinkedListNode {
    private int data;
    int getData(){
        return data;
    }
    CircleLinkedListNode link;
    CircleLinkedListNode(int data){
        this.data = data;
        this.link = null;
    }
}
