import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BookInfo {
    Scanner scanner = new Scanner(System.in);

    protected static int booknum = 3;
    protected static int bookRequest = 0;
    protected String bookName;
    protected int input;

    static List<Book> bookList = new ArrayList<Book>(1000);
    static List<Book> bookPlus = new ArrayList<Book>(1000);

    protected void checkBook(){
        System.out.println("책 목록을 확인합니다.");
        for(int i=0;i<booknum;i++) {
            System.out.println( bookList.get(i).getBookName() + " " + bookList.get(i).getBookCount() + "권" );
        }
    }
}
