package book;

import java.util.Comparator;

public class BookSort implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
        if (!a.getBookName().equals(b.getBookName())) {
            return a.getBookName().compareTo(b.getBookName());
        } else {
            return a.getBookWriter().compareTo(b.getBookWriter());
        }
    }
}
