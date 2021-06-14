package ch12.indexsequentialsearch;

public class SimpleIndex {
    private SimpleIndexNode[] nodes;
    public SimpleIndex(int[] values, int size, int indexSize){
        int i = 0;
        int ratio = 0;

        ratio = size / indexSize;
        if ( size % indexSize > 0 ){
            ratio = ratio + 1;
        }

        nodes = new SimpleIndexNode[indexSize];
        for ( i = 0; i < indexSize; i++){
            nodes[i] = new SimpleIndexNode();
            nodes[i].setPosition( i * ratio );
            nodes[i].setKey( values[ i * ratio ] );
        }
    }

    public int sequentialIndexSearch(int values[], int size, int indexSize, int key){
        int i = 0;
        int start,end;
        if ( key < values[0] || key > values[size-1] ){
            return -1;
        }

        for ( i = 0; i < indexSize; i++){
            if ( nodes[i].getKey() > key ){
                break;
            }
        }

        if ( i < indexSize ){
            start = nodes[i-1].getPosition();
            end  = nodes[i].getPosition() - 1;
        }
        else {
            start = nodes[i-1].getPosition();
            end = size - 1;
        }

        return sequentialRangeSearch(values, start, end, key);
    }

    public int sequentialRangeSearch(int values[], int start, int end, int key){
        int i = 0;
        for ( i = start; i <= end && values[i] < key; i++ ){}
        if ( i <= end && values[i] == key ){
            return i;
        }
        return -1;
    }
    public void showIndexTable(int indexSize){
        System.out.println("인덱스 테이블");
        System.out.println("위치,키");
        System.out.println("-----------");
        for ( int  i = 0; i < indexSize; i++){
            System.out.println(nodes[i].getPosition() + "," + nodes[i].getKey());
        }
    }
    static void showArray(int values[], int size){
        System.out.println("위치, 키 값");
        System.out.println("-----------");
        for ( int  i = 0; i < size; i++){
            System.out.println( i + "," + values[i] );
        }
    }
}
