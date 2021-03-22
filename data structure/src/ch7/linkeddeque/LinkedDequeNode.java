package ch7.linkeddeque;

public class LinkedDequeNode {
    private char data;
    private LinkedDequeNode link;
    LinkedDequeNode(char data){
        this.data = data;
    }
    char getData(){
        return data;
    }
    void setLink(LinkedDequeNode link){
        this.link = link;
    }
    LinkedDequeNode getLink(){
        return link;
    }
}
