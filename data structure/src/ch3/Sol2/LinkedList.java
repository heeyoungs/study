package ch3.sol2;

public class LinkedList {
    private LinkedListNode head;
    private int currentCouunt;
    LinkedList(){
        head = null;
        this.currentCouunt = 0;
    }
    void addNode(double data){ // 꼬리에 추가, 기본
        LinkedListNode newNode = new LinkedListNode(data);
        if(head == null){
            this.head = newNode;
        }
        else{
            LinkedListNode tempNode = head;
            while(tempNode.link != null){
                tempNode = tempNode.link;
            }
            tempNode.link = newNode;
        }
        currentCouunt++;
    }
    double getNodeData(int index){
        LinkedListNode tempNode = head;
        for(int i=0;i<index;i++){
            tempNode = tempNode.link;
        }
        return tempNode.getData();
    }
    double sum(){
        double scoresum = 0;
        LinkedListNode tempNode = head;
        for(int i=0;i<currentCouunt;i++){
            scoresum += tempNode.getData();
            tempNode = tempNode.link;
        }
        return scoresum;
    }
}
