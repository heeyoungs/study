package sss;

import java.util.*;

public class Player {
    boolean[] check;
    int hitCount;
    int playerNum;
    int num;

    Player(int playerNum, int hitCount) {
        this.playerNum = playerNum;
        this.hitCount = hitCount;
        check = new boolean[7];
    }

    public int haveGuess() {
        Scanner in = new Scanner(System.in);
        System.out.print(playerNum + "번님 ~ 숫자를 알아맞춰 보세요(1~6값) : ");
        return num = in.nextInt();
    }
}