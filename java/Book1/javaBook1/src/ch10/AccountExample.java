package ch10;

public class AccountExample{
    public static void main(String args[]){
        Account account = new Account();

        account.deposit(10000);
        System.out.println("예금액: " + account.getBalance());

        try{
            account.withdraw(30000);
        }
        catch(BalanceInsufficientException e){ // 예외 메세지 얻기
            String message = e.getMessage();
            System.out.println(message); // 예외 후 출력
            System.out.println();
            e.printStackTrace();
        }
    }
}