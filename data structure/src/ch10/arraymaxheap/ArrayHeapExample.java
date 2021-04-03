package ch10.arraymaxheap;

public class ArrayHeapExample {
    public static void main(String[] args) {
        int maxHeapSize = 20;
        ArrayHeap heap = null;
        HeapNode node = null;

        heap = new ArrayHeap(maxHeapSize);
        if (heap != null){
            heap.insertMaxHeapAH(90);
            heap.insertMaxHeapAH(85);
            heap.insertMaxHeapAH(80);
            heap.insertMaxHeapAH(75);
            heap.insertMaxHeapAH(70);
            heap.insertMaxHeapAH(65);
            heap.insertMaxHeapAH(60);
            heap.insertMaxHeapAH(55);
            heap.insertMaxHeapAH(50);
            heap.insertMaxHeapAH(45);
            heap.insertMaxHeapAH(40);
            heap.insertMaxHeapAH(35);
            heap.insertMaxHeapAH(30);

            System.out.println("Max Heap:");
            heap.displayArrayHeap();

            heap.insertMaxHeapAH(99);
            System.out.println("After insertMaxHeap()-99");

            System.out.println("Max Heap");
            heap.displayArrayHeap();

            node = heap.removeMaxHeapAH();
            if(node != null){
                System.out.println("removeMaxHeapAH()-" + node.getData());
            }

            System.out.println("Max Heap");
            heap.displayArrayHeap();

            heap.deleteArrayMaxHeap();
        }
    }
}
