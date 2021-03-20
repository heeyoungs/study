package ch6.sol3;

public class LinkedStackNode {
    LinkedStackNode(ExprTokenType data){
        this.data = data;
    }
    private ExprTokenType data;
    private LinkedStackNode link;
    ExprTokenType getData(){
        return data;
    }
    void setLink(LinkedStackNode link){this.link = link;}
    LinkedStackNode getLink(){ return link; }
}