public class Account {
    private int money;
    static final int MIN_BALANCE = 0;
    static final int MAX_BALANCE = 1000000;

    void setBalance(int m){
        if( MIN_BALANCE>=(m) || MAX_BALANCE <=(m) ){
            return;
        }
        this.money = m;
    }
    int getBalance(){
        return money;
    }
}
// 6장 19번