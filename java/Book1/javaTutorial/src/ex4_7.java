import java.util.Scanner;

public class ex4_7 {
    public static void main(String args[]){
        boolean run = true;

        int balance = 0;

        Scanner scanner = new Scanner(System.in);
        outer: while(run){
            System.out.println("---");
            System.out.println("1.예금 2.출금 3.잔액 4.종료");
            System.out.println("---");
            System.out.println("선택>");
            int i=scanner.nextInt();
            switch (i) {
                case 1:
                    System.out.print("예금액>");
                    i=scanner.nextInt();
                    balance=balance+i;
                    break;
                case 2:
                    System.out.print("출금액>");
                    i=scanner.nextInt();
                    balance=balance-i;
                    break;
                case 3:
                    System.out.print("잔액>");
                    System.out.println(balance);
                    break;
                case 4:
                    break outer;
            }
        }
        System.out.println("종료");
        scanner.close();
    }
}
