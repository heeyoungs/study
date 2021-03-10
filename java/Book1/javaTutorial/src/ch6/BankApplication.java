package ch6;

import java.util.Scanner;

public class BankApplication {
    private static Account[] accountArray = new Account[100];
    private static Scanner scanner = new Scanner(System.in);
    static int i = 0;

    public static void main(String args[]){
        boolean run = true;
        while(run){
            System.out.println("---------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("---------------------------------------------");
            System.out.print("선택> ");

            int selectNo = scanner.nextInt();

            if(selectNo == 1){
                createAccount();
            }
            else if(selectNo == 2){
                accountList();
            }
            else if(selectNo == 3){
                deposit();
            }
            else if(selectNo == 4){
                withdraw();
            }
            else if(selectNo == 5) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");
    }
    private static void createAccount(){
        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("계좌주: ");
        String owner = scanner.next();
        System.out.print("초기입금금액: ");
        int balance = scanner.nextInt();
        Account account_ = new Account(ano,owner,balance);
        System.out.println("결과: 계좌가 생성되었습니다.");
        accountArray[i] = account_;
        i++;
    }

    private static void accountList(){
        for(int k = 0;k<i;k++){
            System.out.println(accountArray[k].getAno() + " " + accountArray[k].getOwner() + " " + accountArray[k].getBalance());
        }
    }

    private static void deposit(){
        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("에금액: ");
        int money = scanner.nextInt();
        int num = findAccount(ano).getBalance();
        findAccount(ano).setBalance(num + money);
        System.out.println("결과: 예금이 성공되었습니다.");
    }

    private static void withdraw(){
        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("출금액: ");
        int money = scanner.nextInt();
        int num = findAccount(ano).getBalance();
        findAccount(ano).setBalance(num - money);
        System.out.println("결과: 출금이 성공되었습니다.");
    }

    private static Account findAccount(String ano){
        int k;
        for(k =0;k<i;k++) {
            if (ano.equals(accountArray[k].getAno())) {
                break;
            }
        }
        return accountArray[k];
    }
}