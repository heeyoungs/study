import java.util.Scanner;

public class Libiary {
    public static void main(String[] args){
        BookInfo.bookList.add(new Book("java",5));
        BookInfo.bookList.add(new Book("algorithm",1));
        BookInfo.bookList.add(new Book("dataStructure",4));
        Owner owenr = new Owner();
        Customer customer = new Customer();
        boolean run = true;
        int who;
        Scanner scanner = new Scanner(System.in);
        System.out.println("안녕하세요. 자바 도서관에 오신것을 환영합니다.");
        while(run) {
        System.out.print("관리자는 1번, 손님은 2번, 종료하시려면 0번을 입력해주세요 : ");
            try {
                who = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력값입니다. 프로그램이 종료됩니다.");
                return;
            }
            switch (who) {
                case 1:
                    owenr.runTrue();
                    owenr.run();
                    break;
                case 2:
                    customer.runTrue();
                    customer.run();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("0,1,2 중에 하나를 눌러주세요!");
                    break;
            }
        }

        System.out.println("감사합니다. 다음에 또 이용하세요!");
    }
}
