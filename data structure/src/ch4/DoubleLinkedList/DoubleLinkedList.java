package ch4.doublelinkedlist;

import ch3.singlelinkedlist.DataException;
import ch3.singlelinkedlist.PositionException;

public class DoubleLinkedList {
    private int currentCount;
    private DoubleLinkedListNode head;

    DoubleLinkedList(){
        this.currentCount = 0;
        this.head = null;
    }

    void addNode(int data){
         DoubleLinkedListNode newNode = new DoubleLinkedListNode(data);
         DoubleLinkedListNode tempNode = head;
         if(head == null){
             head = newNode;
         }
         else{
             while(tempNode.Rlink != null){
                 tempNode = tempNode.Rlink;
             }
             tempNode.Rlink = newNode;
             newNode.Llink = tempNode;
         }
         currentCount++;
    }
    void addNode(int index,int data)throws PositionException {
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(data);
        DoubleLinkedListNode tempNode = head;
        if(index <0 || index >currentCount){ // 음수 또는 연결리스트보다 큰 인덱스 예외
            throw new PositionException("잘못된 인덱스 값");
        }
        else if(index == 0){ // 처음일 경우
            head = newNode;
            newNode.Rlink = tempNode;
            if(tempNode != null) {
                tempNode.Llink = newNode;
            }
        }
        else if(index > 0 && index < currentCount ){ //중간일 경우
            for (int i = 0; i < index-1; i++) {
                tempNode = tempNode.Rlink;
            }
            newNode.Rlink = tempNode.Rlink;
            tempNode.Rlink = newNode;
            newNode.Llink = tempNode;
            newNode.Rlink.Llink = newNode;
        }
        else{ // 마지막일 경우
            while(tempNode.Rlink!=null){
                tempNode = tempNode.Rlink;
            }
            tempNode.Rlink = newNode;
            newNode.Llink = tempNode;
        }
        currentCount++;
    }
    void removeNodeByIndex(int index) throws PositionException {
        DoubleLinkedListNode tempNode = head;
        if(index<0 || index > currentCount -1){
            throw new PositionException("인덱스 에러");
        }
        else if(index == 0){
            tempNode = tempNode.Rlink;
            head = tempNode;
            if(head != null){
                tempNode.Llink = null;
            }
        }
        else if(index > 0 && index < currentCount -1){
            for(int i=0;i<index;i++){
                tempNode = tempNode.Rlink;
            }
            tempNode.Llink.Rlink = tempNode.Rlink;
            tempNode.Rlink.Llink = tempNode.Llink;
        }
        else{
            while(tempNode.Rlink.Rlink!=null){
                tempNode = tempNode.Rlink;
            }
            tempNode.Rlink = null;
        }
        currentCount--;
    }
    void removeNodeByData(int data)throws DataException{
        DoubleLinkedListNode tempNode = head;
        int nodeCount = 0;
        while(tempNode != null){
            if(tempNode.getData() == data){
                break;
            }
            tempNode = tempNode.Rlink;
            nodeCount++;
        }
        if(tempNode == null){
            throw new DataException("잘못된 자료 값");
        }
        else if(tempNode == head){ // 처음
            tempNode = tempNode.Rlink;
            head = tempNode;
            if(tempNode!=null){
                tempNode.Llink = null;
            }
        }
        else if(nodeCount > 0 && nodeCount < currentCount - 1){
            tempNode.Llink.Rlink = tempNode.Rlink;
            tempNode.Rlink.Llink = tempNode.Llink;
        }
        else{
            tempNode = head;
            while (tempNode.Rlink.Rlink!=null){
                tempNode = tempNode.Rlink;
            }
            tempNode.Rlink = null;
        }
        currentCount--;
    }
    void disPlayList(){
        DoubleLinkedListNode tempNode = head;
        System.out.println("disPlayList");
        for(int i=0;i<currentCount;i++){
            System.out.println("인덱스 " + i + "의 값 : " + tempNode.getData());
            tempNode = tempNode.Rlink;
        }
    }
    int getDoubleLinkedListData(int index){
        DoubleLinkedListNode tempNode = head;
        for(int i=0;i<index;i++){
            tempNode = tempNode.Rlink;
        }
        return tempNode.getData();
    }
    int getDoubleLinkedListLength(){
        return currentCount;
    }
    void clearDoubleLinkedList(){
        head = null;
        currentCount = 0;
    }
}
