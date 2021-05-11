package ch12.binarysearch;

public class BinarySearchExample {
    public static void main(String[] args){
        int key = 0;
        int index = 0;
        int ascSortedArray[] = {10, 20, 50, 60, 70, 80};

        key = 60;
        index = binarySearchRecursive(ascSortedArray, 0, 5, key);
        if ( index >= 0 ) {
            System.out.println("키-" + key + ",위치-" + index);
        }
        else {
            System.out.println("키-" + key + ",검색 실패");
        }

        key = 65;
        index = binarySearchRecursive(ascSortedArray, 0 ,5, key);
        if ( index >= 0 ) {
            System.out.println("키-" + key + ",위치-" + index);
        }
        else {
            System.out.println("키-" + key + ",검색 실패");
        }
    }
    static int binarySearchRecursive(int values[], int start, int end, int key){
        int ret = -1;
        int middle;

        if ( start <= end ) {
            middle = ( start + end ) / 2;
            if ( key == values[middle] ) {
                ret = middle;
            }
            else if ( key < values[middle] ) {
                ret = binarySearchRecursive(values, start, middle - 1, key);
            }
            else {
                ret = binarySearchRecursive(values, middle + 1, end, key);
            }
        }
        return ret;
    }
    static int binarySearchWhile(int values[], int start, int end, int key){
        int ret = -1;
        int middle;
        int tempStart = start, tempEnd = end;

        while ( start <= end ) {
            middle = ( start + end ) / 2;
            if ( key == values[middle] ) {
                ret = middle;
                break;
            }
            else if ( key < values[middle] ) {
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        return ret;
    }
}
