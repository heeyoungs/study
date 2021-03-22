package ch7.arrayqueue;

import ch5.arraystack.IndexException;

public class ArrayQueueExample {
    public static void main(String[] args) {
        ArrayQueue queue = null;
        ArrayQueueNode node = null;
        try {
            queue = new ArrayQueue(4);
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
