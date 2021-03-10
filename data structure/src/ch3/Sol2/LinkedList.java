package ch3.Sol2;

public class LinkedList {
    LinkedListNode head;
    int currentCouunt;
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
        return tempNode.data;
    }
    double sum(){
        double scoresum = 0;
        for(int i =0;i<currentCouunt;i++){
           scoresum += getNodeData(i);
        }
        return scoresum;
    }
}
