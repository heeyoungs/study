package ch4.CircleLinkedList;

public class CircleLinkedList {
    private int currentCount;
    private CircleLinkedListNode head;

    CircleLinkedList(){
        this.head = null;
        this.currentCount = 0;
    }
    void addNode(int data){
        CircleLinkedListNode newNode = new CircleLinkedListNode(data);
        if(head == null){
            head = newNode;
            newNode.link = newNode;
        }
        else{
            CircleLinkedListNode tempNode = head;
            for(int i=0;i<currentCount-1;i++) {
                tempNode = tempNode.link;
            }
            tempNode.link = newNode;
            newNode.link = head;
        }
        currentCount++;
    }
    void addNode(int index,int data)throws ch3.SingleLinkedList.PositionException{
        CircleLinkedListNode newNode = new CircleLinkedListNode(data);
        CircleLinkedListNode tempNode = head;
        if(index<0||index>currentCount){
            throw new ch3.SingleLinkedList.PositionException("인덱스 에러");
        }
        else if(head == null){
            head = newNode;
            newNode.link = newNode;
        }
        else if(index == 0){ // 처음에 삽입
            for(int i=0;i<currentCount-1;i++){
                tempNode = tempNode.link;
            }
            tempNode.link = newNode;
            newNode.link = head;
            head = newNode;
        }else{
            for (int i = 0; i < index-1; i++) {
                tempNode = tempNode.link;
            }
            newNode.link = tempNode.link;
            tempNode.link = newNode;
        }
        currentCount++;
    }
    void removeNodeByIndex(int index)throws ch3.SingleLinkedList.PositionException{
        CircleLinkedListNode tempNode = head;
        CircleLinkedListNode tempPreNode = null;
        if(index<0 || index > currentCount-1){
            throw new ch3.SingleLinkedList.PositionException("인덱스 에러");
        }
        else if(index == 0){ // 처음
            tempNode = tempNode.link;
            this.head = tempNode;
            for(int i=0;i<currentCount-2;i++){ // 순환처리
                tempNode =tempNode.link;
            }
            tempNode.link = head;
        }
        else if(index >0 && index < currentCount){ // 중간
            for(int i=0;i<index;i++){
                tempPreNode= tempNode;
                tempNode=tempNode.link;
            }
            tempPreNode.link = tempNode.link;
            tempNode.link = tempPreNode;
        }
        currentCount--;
    }
    void removeNodeByData(int data)throws ch3.SingleLinkedList.DataException{
        CircleLinkedListNode tempNode = head;
        CircleLinkedListNode tempPreNode = null;
        int count = 0;
        int nodeCount = 0;
        for(nodeCount=0;nodeCount<currentCount;nodeCount++){ // 값이 같은 노드 찾기
            count++;
            if(tempNode.data == data){
                break;
            }
            tempPreNode= tempNode;
            tempNode = tempNode.link;
        }
        if(nodeCount == currentCount){
            throw new ch3.SingleLinkedList.DataException("잘못된 자료 값");
        }
        else if(tempNode == head){ // 첫번째 노드일 경우
            tempNode = tempNode.link;
            this.head = tempNode;
            for(int i=0;i<currentCount-2;i++){ // 순환처리
                tempNode =tempNode.link;
            }
            tempNode.link = head;
        }
        else if (count == currentCount+1){ // 마지막 노드일 경우
            tempNode = head;
            for(int i=0;i<currentCount-2;i++){
                tempNode=tempNode.link;
            }
            tempNode.link = head;
        }
        else{ // 중간 노드일 경우
            tempPreNode.link = tempNode.link;
            tempNode.link = tempPreNode;
        }
        currentCount--;
    }
    int getCircleLinkedListData(int index) throws ch3.SingleLinkedList.PositionException{
        CircleLinkedListNode tempNode = head;
        if(index<currentCount){
            throw new ch3.SingleLinkedList.PositionException("인덱스 에러");
        }
        for(int i=0;i<index;i++){
            tempNode = tempNode.link;
        }
        return tempNode.data;
    }
    int getCircleLinkedListSize(){
        return currentCount;
    }
    void disPlayCircleLinkedList(){
        CircleLinkedListNode tempNode = head;
        for(int i=0;i<currentCount;i++){
            System.out.println("인덱스 " + i + "의 값 : " + tempNode.data);
            tempNode = tempNode.link;
        }
    }
}
