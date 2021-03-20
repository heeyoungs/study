package ch3.sol2;

public class LinkedListNode {
    LinkedListNode(double data){
        this.data = data;
    }
    private double data;
    double getData(){
        return data;
    }
    LinkedListNode link;
}
