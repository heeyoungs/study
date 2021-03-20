package ch3.singlelinkedlist;

public class LinkedListExample {
    public static void main(String[] args){
        LinkedList pList = null;
        int value = 0;

        pList = new LinkedList();
        try {
            pList.addNode(0, 10);
            pList.addNode(20);
            pList.addNode(2, 30);
        }catch (PositionException e){ e.printStackTrace(); return;}

        value = pList.getNodeData(1);
        System.out.println("인덱스 1의 값_ : " + value);

        try { pList.removeNodeByIndex(2); }catch(PositionException e) {e.printStackTrace(); return;}
        pList.disPlayList();

        LinkedList kList = new LinkedList();
        kList.addNode(90);
        kList.addNode(100);
        pList.concatLinkedList(kList);
        try{ pList.removeNodeByData(100); }catch (DataException e){e.printStackTrace();return;}
        pList.iterateLinkedList();

        pList.reverseLinkedList();
        pList.iterateLinkedList();
    }
}
