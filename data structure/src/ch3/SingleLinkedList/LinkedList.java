package ch3.SingleLinkedList;

public class LinkedList {
    private LinkedListNode head;
    private int currentCount; // 1-1 번
    LinkedList(){
        this.head = null;
        this.currentCount = 0;
    }
    void addNode(int data){ // 꼬리에 추가, 기본
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
        currentCount++;
    }
    void addNode(int index,int data)throws PositionException{ // 인덱스에 의한 값 추가, 삽입
        LinkedListNode newNode = new LinkedListNode(data);
        LinkedListNode tempNode = head;
        if(index <0 || index >currentCount){ // 음수 또는 연결리스트보다 큰 인덱스 예외
            throw new PositionException("잘못된 인덱스 값");
        }
        else if(index == 0){ // 처음일 경우
            this.head = newNode;
            newNode.link = tempNode;
        }
        else { // 중간, 마지막일 경우
            for (int i = 0; i < index-1; i++) {
                tempNode = tempNode.link;
            }
            newNode.link = tempNode.link;
            tempNode.link = newNode;
        }
        currentCount++;
    } // 4-1번
    void removeNodeByIndex(int index)throws PositionException{
        LinkedListNode tempNode = head;
        LinkedListNode tempPreNode = null;
        if(index < 0 || index > currentCount-1) {
            throw new PositionException("잘못된 인덱스 값");
        }
        else if(index == 0){ // 처음
            tempNode = tempNode.link;
            this.head = tempNode;
        }
        else if(index == getLinkedListLength()){ // 마지막
            for(int i=0;i<getLinkedListLength()-1;i++){
                tempNode=tempNode.link;
            }
            tempNode.link = null;
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
    } // 4-2번
    void removeNodeByData(int data) throws DataException{
        LinkedListNode tempNode = head;
        LinkedListNode tempPreNode = null;
        int count = 0;
        while(tempNode != null){ // 값이 같은 노드 찾기
            count++;
            if(tempNode.data == data){
                break;
            }
            tempPreNode= tempNode;
            tempNode = tempNode.link;
        }
        if(tempNode == null){
            throw new DataException("잘못된 자료 값");
        }
        else if(tempNode == head){ // 첫번째 노드일 경우
            tempNode = tempNode.link;
            this.head = tempNode;
        }
        else if (count == getLinkedListLength()+1){ // 마지막 노드일 경우
            tempNode =head;
            for(int i=0;i<getLinkedListLength()-1;i++){
                tempNode=tempNode.link;
            }
            tempNode.link = null;
        }
        else{ // 중간 노드일 경우
            tempPreNode.link = tempNode.link;
            tempNode.link = tempPreNode;
        }
        currentCount--;
    } // 4-3번
    int getNodeData(int index){ // 값 가져오기
        LinkedListNode tempNode = head;
        for(int i=0;i<index;i++){
            tempNode = tempNode.link;
        }
        return tempNode.data;
    }
    int getLinkedListLength(){ // 1-2번
        int count=0;
        LinkedListNode tempNode = head;
        while(tempNode != null){
            tempNode = tempNode.link;
            count++;
        }
        return count;
    }
    void clearLinkedList(){ // 초기화
        head = null;
        currentCount = 0;
    }
    void disPlayList(){
        LinkedListNode tempNode = head;
        System.out.println("disPlayList");
        for(int i=0;i<getLinkedListLength();i++){
            System.out.println("인덱스 " + i + "의 값 : " + getNodeData(i));
        }
        System.out.println("총 노드의 개수 : " + getLinkedListLength());
    }
    void iterateLinkedList(){ // disPlayList 함수의 시간 복잡도 단축
        int count = 0;
        int value = 0;
        LinkedListNode tempNode = head;
        System.out.println("iterateList");

        while(tempNode != null){
            value = tempNode.data;
            System.out.println("인덱스 " + count + "의 값 : " + value);
            tempNode = tempNode.link;
            count++;
        }
        System.out.println("총 노드의 개수 : " + count);
    }
    void concatLinkedList(LinkedList backL){
        LinkedListNode firstListLastNode = head;

        if(this.head == null){ // 5번
            head = backL.head;
            return;
        }

        for(int i=0;i<getLinkedListLength()-1;i++){
            firstListLastNode = firstListLastNode.link;
        }
        currentCount = currentCount+ backL.currentCount;
        firstListLastNode.link = backL.head;
        backL.clearLinkedList();
    }
    void reverseLinkedList(){
        LinkedListNode p = head;
        LinkedListNode r,q = null;

        while(p !=null){
            r = q;
            q = p;
            p = p.link;
            q.link = r;
        }
        head = q;
    }
}
