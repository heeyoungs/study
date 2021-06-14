package ch12.indexsequentialsearch;

public class SimpleIndexExample {
    public static void main(String[] args) {
        SimpleIndex pIndexTable = null;
        int indexSize = 3;
        int index = 0;
        int key = 0;
        int ascSortedValues[] = {10, 20, 50, 60, 70, 80};
        int arraySzie = 6;

        SimpleIndex.showArray(ascSortedValues, arraySzie);

        pIndexTable = new SimpleIndex(ascSortedValues, arraySzie, indexSize);
        pIndexTable.showIndexTable(indexSize);

        key = 60;
        index = pIndexTable.sequentialIndexSearch(ascSortedValues, arraySzie, indexSize, key);
        if (index >= 0) {
            System.out.println("키-" + key + ",위치-" + index);
        } else {
            System.out.println("키-" + key + ",검색 실패");
        }

        key = 65;
        index = pIndexTable.sequentialIndexSearch(ascSortedValues, arraySzie, indexSize, key);
        if (index >= 0) {
            System.out.println("키-" + key + ",위치-" + index);
        } else {
            System.out.println("키-" + key + ",검색 실패");
        }
    }
}
