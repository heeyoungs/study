package ch12.binsearchtree;

public class BinSearchTreeNode {
    private int key;
    private char value;
    private BinSearchTreeNode leftchild;
    private BinSearchTreeNode rightchild;

    public void setKey(int key){
        this.key = key;
    }
    public int getKey(){
        return key;
    }
    public void setValue(char value){
        this.value = value;
    }
    public char getValue(){
        return value;
    }
    public void setLeftchild(BinSearchTreeNode leftchild){
        this.leftchild = leftchild;
    }
    public BinSearchTreeNode getLeftchild(){
        return leftchild;
    }
    public void setRightchild(BinSearchTreeNode rightchild){
        this.rightchild = rightchild;
    }
    public BinSearchTreeNode getRightchild(){
        return rightchild;
    }
}
