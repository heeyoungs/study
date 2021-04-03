package ch4.doublelinkedlist;

import ch3.singlelinkedlist.PositionException;
import ch3.singlelinkedlist.DataException;

public class DoubleLinkedListExample {
    public static void main(String[] args){
        DoubleLinkedList pList = new DoubleLinkedList();

        try {
            pList.addNode(10);
            pList.addNode( 20);
            pList.addNode(400);
            pList.addNode(1, 30);
        }catch (PositionException e){
            e.printStackTrace();
            return;
        }
        System.out.print(pList.getDoubleLinkedListData(1));

        pList.disPlayList();
//
//        try{
//            pList.removeNodeByIndex(2);
//        }catch (PositionException e){
//            e.printStackTrace();
//            return;
//        }
//
//        System.out.println("이중 연결 리스트 현재 노드의 개수 : " + pList.getDoubleLinkedListLength());
//
//        try{
//            pList.removeNodeByData(30);
//        }catch (DataException e){
//            e.printStackTrace();
//            return;
//        }
//
//        pList.disPlayList();
//        System.out.println("인덱스 0의 값 : " + pList.getDoubleLinkedListData(0));
    }
}
