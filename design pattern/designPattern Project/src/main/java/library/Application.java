package library;

import exception.DateException;
import exception.NumException;
import library.modecheck.*;

public class Application {

    public static void main(String[] args) throws NumException, DateException {
        CommandMode mode = new CommandMode();
        mode.run();
    }
}