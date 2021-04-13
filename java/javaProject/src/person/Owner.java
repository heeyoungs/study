package person;

import book.Book;
import book.Library;
import exception.InputNotNumberException;

import java.lang.System;
import java.util.Scanner;
import java.util.Set;

public class Owner {
    private Scanner scanner = new Scanner(System.in);
    // 패스 워드 정보
    private int passwordCount = 0;

    private final static String password = "9605";

    public int getPasswordCount() {
        return passwordCount;
    }

    public void PasswordCountNull() {
        passwordCount = 0;
    }

    public String getPassword() {
        return password;
    }

    public void plusPasswordCount() {
        passwordCount++;
    }

    // 주인의 기능
    public void addBook() throws InputNotNumberException{
        System.out.println("책을 추가하려고 합니다.");
        System.out.print("책 이름을 입력해주세요 : ");
        String bookName = scanner.next();
        System.out.print("책 저자를 입력해주세요 : ");
        String bookWriter = scanner.next();
        System.out.print("책 년도를 입력해주세요 : ");
        int bookYear;
        try {
            bookYear = scanner.nextInt();
        }catch (Exception e){
            throw new InputNotNumberException("잘못된 입력값입니다.");
        }

        boolean check = Library.bookList.containsKey(new Book(bookName,bookWriter));

        if (check) {
            System.out.print("동일한 책이 있습니다. 출판년도를 최신화 하려면 비밀번호를 다시 입력해주세요: ");
            String input = scanner.next();
            if (input.equals(password)) {
                System.out.println("출판년도를 최신화 합니다.");
                Library.bookList.put(new Book(bookName, bookWriter), bookYear);
            } else {
                System.out.println("최신화하지 않습니다.");
            }
        } else {
            Library.bookList.put(new Book(bookName,bookWriter),bookYear);
            System.out.println(bookName + " - " + bookWriter + " 책이 추가되었습니다.");
        }
    } // 직접 추가

    public void addBook2() {
        System.out.println("추가 요청받은 책을 확인합니다.");

        if (Library.bookPlus.size() == 0) {
            System.out.println("요청받은 책이 없습니다.");
            return;
        }

        Set<Book> bookName = Library.bookPlus.keySet();
        for (Book key : bookName) {
            System.out.println("책 이름: " + key.getBookName() + " - 저자: " + key.getBookWriter() + " - 년도: " + Library.bookList.get(key));
        }

        System.out.print("책을 추가하려면 비밀번호를 다시 입력 해주세요: ");
        String inputString = scanner.next();
        if (inputString.equals(password)) {
            System.out.println("요청 받은 책들을 추가합니다.");
            bookName = Library.bookPlus.keySet();
            for (Book key : bookName) {
                System.out.println("책 이름: " + key.getBookName() + " - 저자: " + key.getBookWriter() + " - 년도: " + Library.bookPlus.get(key));
            }
            Library.bookPlus.clear();
        } else {
            System.out.println("요청 받은 책들을 추가하지 않습니다.");
        }
    } // 요청 받은 책 추가

    public void removeBook() {
        System.out.println("책을 제거하려고 합니다.");
        System.out.print("책 이름을 입력해주세요 : ");
        String bookName = scanner.next();
        System.out.print("책 저자를 입력해주세요 : ");
        String bookWriter = scanner.next();

        boolean check = Library.bookList.containsKey(new Book(bookName,bookWriter));

        if (check) {
            Library.bookList.remove(new Book(bookName,bookWriter));
            System.out.println(bookName + " - " + bookWriter + " - "  + Library.bookList.get(new Book(bookName,bookWriter)) + " 책이 제거되었습니다.");
        } else {
            System.out.println("없는 책입니다.");
        }
    } // 책 제거
}
