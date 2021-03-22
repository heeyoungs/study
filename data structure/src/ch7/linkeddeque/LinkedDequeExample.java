package ch7.linkeddeque;

public class LinkedDequeExample {
    public static void main(String[] args){
        LinkedDeque dq = new LinkedDeque();

        dq.inserRear('O');
        dq.inserRear('2');
        dq.insertFront('1');
        dq.disPlayDQ();

        System.out.println(dq.peekRear().getData());
        dq.disPlayDQ();

        System.out.println(dq.peekFront().getData());
        dq.disPlayDQ();

        dq.deleteRear();
        dq.deleteFront();
        dq.insertFront('K');
        dq.inserRear('R');
        dq.inserRear('E');
        dq.inserRear('A');
        dq.disPlayDQ();

        dq.deleteDQ();
        dq.disPlayDQ();
    }
}
