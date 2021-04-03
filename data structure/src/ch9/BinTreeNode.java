package ch9;

public class BinTreeNode {
    private char data;
    private BinTreeNode pLeftChild;
    private BinTreeNode pRightChild;

    public void setData(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }

    public void setpLeftChild(BinTreeNode link) {
        this.pLeftChild = link;
    }

    public void setpRightChild(BinTreeNode link) {
        this.pRightChild = link;
    }

    public BinTreeNode getpLeftChild() {
        return pLeftChild;
    }

    public BinTreeNode getpRightChild() {
        return pRightChild;
    }
}
