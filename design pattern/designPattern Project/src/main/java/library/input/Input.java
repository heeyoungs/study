package library.input;

import exception.DateException;
import exception.NumException;

import java.sql.Date;
import java.util.Scanner;

public class Input {

    private final Scanner scanner = new Scanner(System.in);

    private static Input input = new Input();

    private Input() {}

    public static Input getInput() {
        return input;
    }

    public int inputNum() throws NumException {
        int input;
        try {
            input = scanner.nextInt();
            return input;
        } catch (Exception e) {
            throw new NumException("숫자를 입력해주세요.");
        }
    }

    public Date inputDate() throws DateException {
        Date input;
        try {
            input = Date.valueOf(scanner.next());
            return input;
        } catch (Exception e) {
            throw new DateException("날짜를 입력해주세요.");
        }
    }

    public String inputString() {
        String input;
        input = scanner.next();
        return input;
    }
}
