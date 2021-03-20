package ch5.linkedstack;

public class LinkedStack {
    private int currentCount;
    private LinkedStackNode top;
    LinkedStack(){
        this.currentCount = 0;
        this.top = null;
    }
    int pushLinkedStack(char data){
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
            return null;
        }
        data = top;
        top = top.getLink();
        currentCount--;
        return data;
    }
    LinkedStackNode peekLinkedStack(){
        LinkedStackNode data = null;
        if (isLinkedStackEmpty() == 1) {
            return null;
        }
        return top;
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
    void disPlayLinkedStack(){
        LinkedStackNode temp = top;
        if(isLinkedStackEmpty() == 1){
            System.out.println("스택이 비어 있습니다.");
            return;
        }
        System.out.println("현재 노드 개수: " + currentCount);
        int Count = currentCount;
        while(temp != null){
            System.out.println( (Count-1) + "-" +  temp.getData() );
            temp = temp.getLink();
            Count--;
        }
    }
}
