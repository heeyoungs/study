package ch10.arraymaxheap;

public class ArrayHeap {
    private int maxCount;
    private int currentCount;
    private HeapNode[] data;
    ArrayHeap(int maxCount){
        if(maxCount < 0){
            System.out.println("0보다 작은 인덱스");
            return;
        }
        this.maxCount = maxCount;
        this.currentCount = 0;
        this.data = new HeapNode[maxCount+1];
    }
    int insertMaxHeapAH(int value){
        if(currentCount == maxCount){
            System.out.println("히프가 가득 찼습니다");
            return -1;
        }
        currentCount++;
        int i = currentCount;
        data[currentCount] = new HeapNode();
        while((i != 1) && (value > data[i/2].getData())){
            data[i].setData(data[i/2].getData()); // data[i] = data[i/2] 라 하면 객체를 같다 하는거라 29번째 줄에서 둘의 값이 동시에 바뀜
            i = i/2;

        }
        data[i].setData(value);
        return 1;
    }
    HeapNode removeMaxHeapAH(){
        HeapNode pReturn = null;
        HeapNode pTemp = null;
        int parent = 1, child = 2;

        if (currentCount < 0) {
            return null;
        }
        pReturn = new HeapNode();
        if(pReturn == null){
            System.out.println("메모리 할당 오류");
            return null;
        }
        pReturn = data[1];

        pTemp = data[currentCount];
        data[currentCount] = null;
        currentCount--;

        while(child <= currentCount){
            if(child < currentCount && data[child].getData() < data[child+1].getData()){
                child++;
            }

            if(pTemp.getData() >= data[child].getData()){
                break;
            }

            data[parent] = data[child];
            parent = child;
            child = child * 2;
        }
        data[parent] = pTemp;
        return pReturn;
    }
    void deleteArrayMaxHeap(){
        maxCount = 0;
        currentCount =0;
        data = null;
    }
    void displayArrayHeap(){
        for (int i = 1; i<= currentCount; i++){
            System.out.println(i + "-" + data[i].getData());
        }
    }
}
