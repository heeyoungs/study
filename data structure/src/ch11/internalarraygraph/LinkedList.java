package ch11.internalarraygraph;

import ch3.singlelinkedlist.PositionException;

public class LinkedList {
    private LinkedListNode head;
    private int currentCount;
    public LinkedList(){
        this.head = new LinkedListNode(0);
        this.currentCount = 0;
    }
    public void addNode(int index,int data)throws PositionException {
        LinkedListNode newNode = new LinkedListNode(data);
        LinkedListNode tempNode = head;
        if(index <0 || index >currentCount){
            throw new PositionException("잘못된 인덱스 값");
        }
        else {
            for (int i = 0; i<index; i++) {
                tempNode.setLink(tempNode.getLink());
            }
            newNode.setLink(tempNode.getLink());
            tempNode.setLink(newNode);
        }
        currentCount++;
    }
    public void removeNodeByIndex(int index) throws PositionException {
        LinkedListNode tempNode = head;
        LinkedListNode tempPreNode = null;
        if(index < 0 || index > currentCount-1) {
            throw new PositionException("잘못된 인덱스 값");
        }
        for(int i=0;i<index+1;i++){
            tempPreNode= tempNode;
            tempNode=tempNode.getLink();
        }
        tempPreNode.setLink(tempNode.getLink());
        currentCount--;
    }
    public int getNodeData(int index){
        LinkedListNode tempNode = head;
        for(int i=0;i<index+1;i++){
            tempNode = tempNode.getLink();
        }
        return tempNode.getData();
    }
    public int getLinkedListLength(){
        return currentCount;
    }
    public void deleteLinkedList(){
        head = null;
        currentCount = 0;
    }
}