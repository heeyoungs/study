package ch7.arraycirclequeue;

import ch5.arraystack.IndexException;

public class ArrayCircleQueueExample {
    public static void main(String[] args) {
        ArrayCircleQueue queue = null;
        ArrayCircleQueueNode node = null;
        try {
            queue = new ArrayCircleQueue(4);
        } catch (IndexException e) {
            e.printStackTrace();
            return;
        }
        queue.enqueueAQ('A');
        queue.enqueueAQ('B');
        queue.enqueueAQ('C');
        queue.enqueueAQ('D');
        queue.disPlayAQ();

        node = queue.dequeueAQ();
        System.out.println("Dequeue Value-" + node.getData());
        queue.disPlayAQ();

        node = queue.peekAQ();
        System.out.println("Peek Value-" + node.getData());
        queue.disPlayAQ();

        queue.enqueueAQ('E'); // 인큐 연산의 실패
        queue.disPlayAQ();

        queue.deleteAQ();
        queue.disPlayAQ();
    }
}