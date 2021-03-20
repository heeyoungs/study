package ch6.sol4;

public class LinkedStackNode {
    LinkedStackNode(ExprToken data){
        this.data = data;
    }
    private ExprToken data;
    private LinkedStackNode link;
    ExprToken getData(){
        return data;
    }
    void setLink(LinkedStackNode link){this.link = link;}
    LinkedStackNode getLink(){ return link; }
}