package ch4.CircleLinkedList;

import ch3.SingleLinkedList.PositionException;
import ch3.SingleLinkedList.DataException;

public class CircleLinkedListExample {
    public static void main(String[] args){
        CircleLinkedList pList = new CircleLinkedList();

        try {
            pList.addNode(10);
            pList.addNode( 20);
            pList.addNode(2,100);
        }catch (PositionException e){
            e.printStackTrace();
            return;
        }

        pList.disPlayCircleLinkedList();
        System.out.println("원형 연결리스트 현재 자료의 개수: " + pList.getCircleLinkedListSize());

        try {
            pList.removeNodeByData(20);
        }catch (DataException e){
            e.printStackTrace();
            return;
        }

        pList.disPlayCircleLinkedList();
    }
}
