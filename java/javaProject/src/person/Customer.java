package person;

import book.Book;
import book.Library;
import exception.InputNotNumberException;

import java.util.*;

public class Customer {
    private Scanner scanner = new Scanner(System.in);

    // 손님의 기능
    public void addBook() throws InputNotNumberException{
        System.out.println("책 추가를 요청합니다.");
        System.out.print("책 이름을 입력해주세요 : ");
        String bookName = scanner.next();
        System.out.print("책 저자를 입력해주세요 : ");
        String bookWriter = scanner.next();

        boolean check = Library.bookList.containsKey(new Book(bookName,bookWriter));
        if (check) {
            System.out.println("동일한 책이 있습니다.");
            return;
        }

        check = Library.bookPlus.containsKey(new Book(bookName,bookWriter));
        if (check) {
            System.out.println("이미 요청받은 책입니다.");
            return;
        }

        System.out.print("책 년도를 입력해주세요 : ");
        int bookYear;
        try {
            bookYear = scanner.nextInt();
        }catch (Exception e){
            throw new InputNotNumberException("잘못된 입력값입니다.");
        }
        Library.bookPlus.put(new Book(bookName, bookWriter),bookYear);
        System.out.println("책을 추가 요청했습니다.");
    } // 책 추가 요청

    public void borrowBook() {
        System.out.println("책 빌리기를 요청합니다.");
        System.out.print("책 이름을 입력해주세요 : ");
        String bookName = scanner.next();
        System.out.print("책 저자를 입력해주세요 : ");
        String bookWriter = scanner.next();

        boolean check = Library.bookList.containsKey(new Book(bookName, bookWriter));
        if (check) {
            System.out.println(bookName + " - " + bookWriter + " - " + Library.bookList.get(new Book(bookName, bookWriter)) + " 책을 빌려갑니다.");
        } else {
            System.out.println("없는 책입니다.");
        }
    } // 책 빌리기
}
