import book.Book;
import book.Library;
import exception.InputNotNumberException;
import person.Customer;
import person.Owner;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws InputNotNumberException {
        Library.bookList.put(new Book("java", "j"),1998);
        Library.bookList.put(new Book("algorithm", "a"),2000);
        Library.bookList.put(new Book("data structure", "d"),2004);
        Library.bookList.put(new Book("design pattern","d"),1998);

        Scanner scanner = new Scanner(System.in);
        Owner owner = new Owner();
        Customer customer = new Customer();

        int input;
        boolean run = true; // 애플리케이션 상태
        int who; // 누구 인가

        System.out.println("안녕하세요. 자바 도서관에 오신것을 환영합니다.");
        while (run) {
            System.out.print("관리자는 1번, 손님은 2번, 종료하시려면 0번을 입력해주세요 : ");
            try {
                who = scanner.nextInt();
            } catch (Exception e) {
                throw new InputNotNumberException("잘못된 입력값입니다.");
            }
            switch (who) {
                case 0: {
                    System.out.println("감사합니다. 다음에 또 이용하세요!");
                    return;
                } // 종료
                case 1: {
                    owner.PasswordCountNull();
                    boolean ownerRun = true;
                    System.out.print("비밀번호를 입력해주세요, 3회 틀리면 종료됩니다. : ");
                    for (int i = 1; i <= 3; i++) {
                        String inputPassword = scanner.next();
                        if (inputPassword.equals(owner.getPassword())) {
                            System.out.println("\t\t[관리자]");
                            while (ownerRun) {
                                System.out.println("-------------------------");
                                System.out.println("어떤 기능을 이용하실 건가요.");
                                System.out.println("1.책 추가하기");
                                System.out.println("2.추가 요청 받은 책 확인 및 추가하기");
                                System.out.println("3.책 제거하기");
                                System.out.println("4.도서관의 책 목록 확인하기");
                                System.out.println("0.관리자 모드 종료하기");
                                System.out.print("입력 : ");
                                try {
                                    input = scanner.nextInt();
                                } catch (Exception e) {
                                    throw new InputNotNumberException("잘못된 입력값입니다.");
                                }
                                switch (input) {
                                    case 1:
                                        owner.addBook();
                                        break;
                                    case 2:
                                        owner.addBook2();
                                        break;
                                    case 3:
                                        owner.removeBook();
                                        break;
                                    case 4:
                                        Library.checkBook();
                                        break;
                                    case 0:
                                        ownerRun = false;
                                        break;
                                    default:
                                        System.out.println("<0,1,2,3,4,5> 중에 하나를 눌러주세요!");
                                        break;
                                }

                            }
                            break;
                        } else {
                            if (owner.getPasswordCount() == 2) {
                                System.out.println("비밀번호를 3회 틀려서 프로그램이 종료됩니다.");
                                return;
                            }
                            System.out.print("비밀번호를 " + i + "번 만큼 틀렸습니다. 다시 입력해 주세요 : ");
                            owner.plusPasswordCount();
                        }
                    }
                    break;
                } // 손님
                case 2: {
                    boolean customerRun = true;
                    System.out.println("\t\t[손님]");
                    while (customerRun) {
                        System.out.println("-------------------------");
                        System.out.println("어떤 기능을 이용하실 건가요.");
                        System.out.println("1.책 추가 요청하기");
                        System.out.println("2.책 빌려가기");
                        System.out.println("3.책 목록 확인하기");
                        System.out.println("0.손님 모드 종료하기");
                        System.out.print("입력 : ");
                        try {
                            input = scanner.nextInt();
                        } catch (Exception e) {
                            throw new InputNotNumberException("잘못된 입력값입니다.");
                        }
                        switch (input) {
                            case 1:
                                customer.addBook();
                                break;
                            case 2:
                                customer.borrowBook();
                                break;
                            case 3:
                                Library.checkBook();
                                break;
                            case 0:
                                customerRun = false;
                                break;
                            default:
                                System.out.println("<0,1,2,3> 중에 하나를 눌러주세요!");
                                break;
                        }
                    }
                    break;
                } // 주인
                default: {
                    System.out.println("<0,1,2> 중에 하나를 눌러주세요!");
                    break;
                } // 그 외
            }
        }
    }
}
