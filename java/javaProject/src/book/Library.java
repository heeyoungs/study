package book;

import java.util.*;

public class Library {
    public static Map<Book,Integer> bookList = new TreeMap<>(new BookSort()); // 도서관 책 목록
    public static Map<Book,Integer> bookPlus = new TreeMap<>(new BookSort()); // 요청받은 책 목록

    public static void checkBook() {
        System.out.println("책 목록을 확인합니다.");
        Set<Book> bookName = bookList.keySet();
        for (Book key : bookName) {
            System.out.println("책 이름: " + key.getBookName() + " - 저자: " + key.getBookWriter() + " - 년도: " + bookList.get(key));
        }
    } // 책 확인하기
}
