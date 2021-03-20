package ch6.sol2;

public class LinkedStackNode {
    LinkedStackNode(char data){
        this.data = data;
    }
    private char data;
    private LinkedStackNode link;
    char getData(){ return data; }
    void setLink(LinkedStackNode link){this.link = link;}
    LinkedStackNode getLink(){ return link; }
}