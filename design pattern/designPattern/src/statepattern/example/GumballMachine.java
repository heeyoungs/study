package statepattern.example;

public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    State getNoQuarterState() {
        return noQuarterState;
    }

    State getHasQuarterState() {
        return hasQuarterState;
    }

    State getSoldState() {
        return soldState;
    }

    State getSoldOutState() {
        return soldOutState;
    }

    State getWinnerState() {
        return winnerState;
    }

    int getCount() {
        return count;
    }

    public String toString(){
        String a = "주식회사 왕 뽑기";
        String b = "자바로 돌아가는 2021년형 뽑기 기계";
        String c = "남은 개수: " + count + "개";
        String d = "동전 투입 대기중";

        return a + "\n" + b + "\n" + c + "\n" + d + "\n";
    }
}