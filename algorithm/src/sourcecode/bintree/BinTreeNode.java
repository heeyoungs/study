package sourcecode.bintree;

public class BinTreeNode {
    private int data;
    private BinTreeNode pLeftChild;
    private BinTreeNode pRightChild;

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
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
