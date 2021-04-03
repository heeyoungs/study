package ch7.linkeddeque;

public class LinkedDequeNode {
    private char data;
    private LinkedDequeNode link;
    public LinkedDequeNode(char data){
        this.data = data;
    }
    public char getData(){
        return data;
    }
    public void setLink(LinkedDequeNode link){
        this.link = link;
    }
    public LinkedDequeNode getLink(){
        return link;
    }
}
