package ch4.DoubleLinkedList;

import ch3.SingleLinkedList.PositionException;
import ch3.SingleLinkedList.DataException;

public class DoubleLinkedListExample {
    public static void main(String[] args){
        DoubleLinkedList pList = new DoubleLinkedList();

        try {
            pList.addNode(10);
            //pList.addNode( 20);
            pList.addNode(400);
            pList.addNode(2,30);
        }catch (PositionException e){
            e.printStackTrace();
            return;
        }

        pList.disPlayList();

        try{
            pList.removeNodeByData(400);
        }catch (DataException e){
            e.printStackTrace();
            return;
        }

        pList.disPlayList();
    }
}
