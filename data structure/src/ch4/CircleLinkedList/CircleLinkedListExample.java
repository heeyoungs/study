package ch4.circlelinkedlist;

import ch3.singlelinkedlist.PositionException;
import ch3.singlelinkedlist.DataException;

public class CircleLinkedListExample {
    public static void main(String[] args){
        CircleLinkedList pList = new CircleLinkedList();

        try {
            pList.addNode(0,10);
            pList.addNode( 20);
            pList.addNode(2,100);
            pList.addNode(3,500);
        }catch (PositionException e){
            e.printStackTrace();
            return;
        }

        pList.disPlayCircleLinkedList();

        try{
            pList.removeNodeByIndex(3);
        }catch (PositionException e){
            e.printStackTrace();
            return;
        }

        System.out.println("원형 연결리스트 현재 자료의 개수: " + pList.getCircleLinkedListSize());

        try {
            pList.removeNodeByData(10);
        }catch (DataException e){
            e.printStackTrace();
            return;
        }

        pList.disPlayCircleLinkedList();
        int value = pList.getCircleLinkedListData(2);
        System.out.println("인덱스 0의 값 : " + value);
    }
}
