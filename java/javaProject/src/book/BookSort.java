package book;

import java.util.Comparator;

public class BookSort implements Comparator<Book> {
    // 정렬 기준 (이름 순, 이름이 같으면-> 작가 이름 순)
    @Override
    public int compare(Book a, Book b) {
        if (!a.getBookName().equals(b.getBookName())) {
            return a.getBookName().compareTo(b.getBookName());
        } else {
            return a.getBookWriter().compareTo(b.getBookWriter());
        }
    }
}
