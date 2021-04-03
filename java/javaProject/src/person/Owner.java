package person;

import book.Book;
import book.Library;

import java.lang.System;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Owner {
    private Scanner scanner = new Scanner(System.in);
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

    public void addBook() {
        System.out.println("책을 추가하려고 합니다.");
        System.out.print("책 이름을 입력해주세요 : ");
        String bookName = scanner.next();
        System.out.print("책 저자를 입력해주세요 : ");
        String bookWriter = scanner.next();

        boolean check = Library.bookList.stream()
                .anyMatch(n -> n.equals(new Book(bookName, bookWriter)));

        if (check) {
            System.out.println("동일한 책이 있습니다.");
        } else {
            Library.bookList.add(new Book(bookName, bookWriter));
            System.out.println(bookName + " - " + bookWriter + " 책이 추가되었습니다.");
        }
    } // 직접 추가

    public void addBook2() {
        System.out.println("추가 요청받은 책을 확인합니다.");

        if (Library.bookPlus.size() == 0) {
            System.out.println("요청받은 책이 없습니다.");
            return;
        }

        Library.bookPlus.stream()
                .forEach(n -> System.out.println("책 이름: " + n.getBookName() + " - 저자: " + n.getBookWriter()));

        System.out.print("책을 추가하려면 비밀번호를 다시 입력 해주세요: ");
        String inputString = scanner.next();
        if (inputString.equals(password)) {
            System.out.println("요청 받은 책들을 추가합니다.");
            Library.bookList = Stream.concat(Library.bookList.stream(), Library.bookPlus.stream())
                    .distinct()
                    .collect(Collectors.toList());

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

        boolean check = Library.bookList.stream()
                .anyMatch(n -> n.equals(new Book(bookName, bookWriter)));

        if (check) {
            Library.bookList.remove(new Book(bookName, bookWriter));
            System.out.println(bookName + " - " + bookWriter + " 책이 제거되었습니다.");
        } else {
            System.out.println("없는 책입니다.");
        }
    } // 책 제거
}
