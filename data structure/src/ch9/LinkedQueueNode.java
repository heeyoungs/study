package ch9;

public class LinkedQueueNode {
    private BinTreeNode data;
    private LinkedQueueNode link;

    public LinkedQueueNode(BinTreeNode data) {
        this.data = data;
    }

    public BinTreeNode getData() {
        return data;
    }

    public void setLink(LinkedQueueNode link) {
        this.link = link;
    }

    public LinkedQueueNode getLink() {
        return link;
    }
}