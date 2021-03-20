package ch4.doublelinkedlist;

import ch3.singlelinkedlist.PositionException;
import ch3.singlelinkedlist.DataException;

public class DoubleLinkedListExample {
    public static void main(String[] args){
        DoubleLinkedList pList = new DoubleLinkedList();

        try {
            pList.addNode(0,10);
            pList.addNode( 1,20);
            pList.addNode(2,400);
            pList.addNode(30);
        }catch (PositionException e){
            e.printStackTrace();
            return;
        }

        pList.disPlayList();

        try{
            pList.removeNodeByIndex(2);
        }catch (PositionException e){
            e.printStackTrace();
            return;
        }

        System.out.println("이중 연결 리스트 현재 노드의 개수 : " + pList.getDoubleLinkedListLength());

        try{
            pList.removeNodeByData(30);
        }catch (DataException e){
            e.printStackTrace();
            return;
        }

        pList.disPlayList();
        System.out.println("인덱스 0의 값 : " + pList.getDoubleLinkedListData(0));
    }
}
