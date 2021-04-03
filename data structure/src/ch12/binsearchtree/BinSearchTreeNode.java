package ch12.binsearchtree;

public class BinSearchTreeNode {
    private int key;
    private char value;
    private BinSearchTreeNode leftchild;
    private BinSearchTreeNode rightchild;

    void setKey(int key){
        this.key = key;
    }
    int getKey(){
        return key;
    }
    void setValue(char value){
        this.value = value;
    }
    char getValue(){
        return value;
    }
    void setLeftchild(BinSearchTreeNode leftchild){
        this.leftchild = leftchild;
    }
    BinSearchTreeNode getLeftchild(){
        return leftchild;
    }
    void setRightchild(BinSearchTreeNode rightchild){
        this.rightchild = rightchild;
    }
    BinSearchTreeNode getRightchild(){
        return rightchild;
    }
}
