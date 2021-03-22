package ch7.linkedqueue;

public class LinkedQueueExample {
    public static void main(String[] args){
        LinkedQueue queue = new LinkedQueue();
        LinkedQueueNode node = null;

        queue.enqueueLQ('A');
        queue.enqueueLQ('B');
        queue.enqueueLQ('C');
        queue.enqueueLQ('D');
        queue.disPlayLQ();

        node = queue.dequeueLQ();
        System.out.println("Dequeue Value-" + node.getData());
        queue.disPlayLQ();

        node = queue.peekLQ();
        System.out.println("Peek Value-" + node.getData());
        queue.disPlayLQ();

        queue.enqueueLQ('E');
        queue.disPlayLQ();

        queue.deleteLQ();
        queue.disPlayLQ();
    }
}
