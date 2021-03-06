package book;

public class Book {
    private String bookName;
    private String bookWriter;

    public Book(String bookName, String bookWriter) {
        this.bookName = bookName;
        this.bookWriter = bookWriter;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public String getBookName() {
        return bookName;
    }

    // 동일한 책의 기준, 책 이름과 작가가 동일
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return book.bookName.equals(bookName) && book.bookWriter.equals(bookWriter);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return bookName.hashCode() + bookWriter.hashCode();
    }
}
