package ch2;

public class ArrayListNode {
    ArrayListNode(){
        data = 0;
    }
    protected void setData(int data){
        this.data = data;
    }
    protected int getData(){
        return data;
    }
    private int data;
}
