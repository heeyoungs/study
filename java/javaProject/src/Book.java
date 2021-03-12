public class Book {
    private String bookName;
    private int bookCount;
    Book(String bookName,int bookCount){
        this.bookName = bookName;
        this.bookCount = bookCount;
    }
    void minusBookCount() {this.bookCount--;}
    void plusBookCount(int num){this.bookCount += num;}
    int getBookCount() {return bookCount;}
    String getBookName(){
        return bookName;
    }
}
