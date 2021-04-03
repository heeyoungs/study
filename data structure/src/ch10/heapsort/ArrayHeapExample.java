package ch10.heapsort;

public class ArrayHeapExample {
    public static void main(String[] args){
        int values[] = {10,50,70,80,60,20,40,30};

        System.out.println("Before Sort");
        printArray(values,values.length);

        heapSort(values, values.length);

        System.out.println("After Sort");
        printArray(values,values.length);
    }
    static void printArray(int values[], int count){
        for (int i=0; i<count; i++){
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }
    static void heapSort(int values[], int count){
        ArrayHeap heap = new ArrayHeap(8);

        if(heap == null){
            System.out.println("오류");
            return;
        }
        for(int i=0; i<count; i++){
               heap.insertMaxHeapAH(values[i]);
        }

        HeapNode node = null;
        for(int i=0; i<count; i++){
            node = heap.removeMaxHeapAH();
            values[i] = node.getData();
        }

        heap.deleteArrayMaxHeap();
    }
}
