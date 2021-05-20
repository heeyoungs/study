package sss;

public class GuessGame {
    int[] card = {3, 1, 6};
    Player p1;
    Player p2;
    Player p3;

    public GuessGame() {
        p1 = new Player(1, 0);
        p2 = new Player(2, 0);
        p3 = new Player(3, 0);
    }

    public void startGame() {
        int count = 0;
        while (true) {
            Player now;
            if (count % 3 == 0) {
                now = p1;
            } else if (count % 3 == 1) {
                now = p2;
            } else {
                now = p3;
            }
            if (hitOrNot(now.haveGuess(), now)) {
                System.out.println("hit");
                now.hitCount++;
                if (now.hitCount >= 3) {
                    System.out.println("player " + now.playerNum + " win");
                    break;
                }
            } else {
                System.out.println("miss");
            }
            count++;
            if (count > 15) {
                System.out.println("Game over");
                break;
            }
        }

    }

    private boolean hitOrNot(int input, Player now) {
        for (int i = 0; i < card.length; i++) {
            if (input == card[i]) {
                if (now.check[input]) continue;
                now.check[input] = true;
                return true;
            }
        }
        return false;
    }
}