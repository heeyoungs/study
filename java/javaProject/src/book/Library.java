package book;

import java.util.LinkedList;
import java.util.List;

public class Library {
    public static List<Book> bookList = new LinkedList<>(); // 도서관 책 목록
    public static List<Book> bookPlus = new LinkedList<>(); // 요청받은 책 목록
    public static void checkBook() {
        System.out.println("책 목록을 확인합니다.");
        bookList.stream()
                .forEach(s -> System.out.println("책 이름: " + s.getBookName() + " - 저자: " + s.getBookWriter()));
    } // 책 확인하기
}
