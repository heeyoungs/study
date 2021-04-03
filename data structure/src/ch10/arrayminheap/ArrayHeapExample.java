package ch10.arrayminheap;

public class ArrayHeapExample {
    public static void main(String[] args) {
        int minHeapSize = 20;
        ArrayHeap heap = null;
        HeapNode node = null;

        heap = new ArrayHeap(minHeapSize);
        if (heap != null){
            heap.insertMinHeapAH(30);
            heap.insertMinHeapAH(35);
            heap.insertMinHeapAH(40);
            heap.insertMinHeapAH(45);
            heap.insertMinHeapAH(50);
            heap.insertMinHeapAH(55);
            heap.insertMinHeapAH(60);
            heap.insertMinHeapAH(65);
            heap.insertMinHeapAH(70);
            heap.insertMinHeapAH(75);
            heap.insertMinHeapAH(80);
            heap.insertMinHeapAH(85);
            heap.insertMinHeapAH(90);

            System.out.println("Min Heap:");
            heap.displayArrayHeap();

            heap.insertMinHeapAH(29);
            System.out.println("After insertMinHeap()-29");

            System.out.println("Min Heap");
            heap.displayArrayHeap();

            node = heap.removeMinHeapAH();
            if(node != null){
                System.out.println("removeMinHeapAH()-" + node.getData());
            }

            System.out.println("Min Heap");
            heap.displayArrayHeap();

            heap.deleteArrayMinHeap();
        }
    }
}