package ch6.sol4;

public class LinkedStack {
    private int currentCount;
    private LinkedStackNode top;
    LinkedStack(){
        this.currentCount = 0;
        this.top = null;
    }
    int pushLinkedStack(ExprToken data){
        LinkedStackNode newStack = new LinkedStackNode(data);
        if(isLinkedStackEmpty() == 1){ // 처음일 경우
            this.top = newStack;
            newStack.setLink(null);
        }
        else{
            newStack.setLink(top);
            this.top = newStack;
        }
        currentCount++;
        return 1;
    }
    LinkedStackNode popLinkedStack() {
        LinkedStackNode data = null;
        if (isLinkedStackEmpty() == 1) {
            return data;
        }
        data = top;
        top = top.getLink();
        currentCount--;
        return data;
    }
    LinkedStackNode peekLinkedStack(){
        LinkedStackNode data = null;
        if (isLinkedStackEmpty() == 1) {
            return data;
        }
        data = top;
        return data;
    }
    int isLinkedStackEmpty(){
        if(currentCount == 0){ return 1;}
        return -1;
    }
    void deleteLinkedStack(){
        if(isLinkedStackEmpty() == 1){
            return;
        }
        top.setLink(null);
        currentCount=0;
    }
}