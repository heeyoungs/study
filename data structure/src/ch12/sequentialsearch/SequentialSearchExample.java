package ch12.sequentialsearch;

public class SequentialSearchExample {
    public static void main(String[] args){
        int index =0, count = 0;
        int notSortedArray[] = {80, 20, 70, 50};
        int ascSortedArray[] = {20, 50, 70, 80};

        // 정렬 x
        count = notSortedArray.length;
        showArray(notSortedArray, count);

        index = sequentialSearchNotSorted(notSortedArray,count,70);
        showSearchResult(70, index);

        index = sequentialSearchNotSorted(notSortedArray,6,25);
        showSearchResult(25, index);

        // 정렬 o
        count = ascSortedArray.length;
        showArray(ascSortedArray, count);

        index = sequentialSearchAscendingSorted(ascSortedArray,count,70);
        showSearchResult(70, index);

        index = sequentialSearchAscendingSorted(ascSortedArray,count,25);
        showSearchResult(5, index);
    }
    static void showArray(int[] values, int size){
        System.out.println("position,key");
        System.out.println("------------");
        for(int i=0;i<size;i++){
            System.out.println(i + "," + values[i]);
        }
    }
    static void showSearchResult(int key, int index){
        if(index >= 0){
            System.out.println("키-" + key + ",위치-" + index);
        }
        else{
            System.out.println("키-" + key + ",검색 실패");
        }
    }
    static int sequentialSearchNotSorted(int values[], int size, int key){
        int i = 0;
        if(size > values.length){
            size = values.length;
        }
        for(i=0; i<size && values[i] != key; i++){}
        if(i<size){
            return i;
        }
        return -1;
    }
    static int sequentialSearchAscendingSorted(int values[], int size, int key){
        int i = 0;
        for(i = 0; i<size && values[i]<key; i++){}
        if(i<size && values[i]==key){
            return i;
        }
        return -1;
    }
}
