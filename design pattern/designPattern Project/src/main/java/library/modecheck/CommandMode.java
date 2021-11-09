package library.modecheck;

import library.input.Input;
import exception.DateException;
import exception.NumException;
import library.modecheck.mode.CustomerMode;
import library.modecheck.mode.JoinMode;
import library.modecheck.mode.OwnerMode;
import library.modecheck.mode.Mode;

public class CommandMode {

    EtcUi etcUi = EtcUi.getEtcUi();
    Input input = Input.getInput();

    private enum Command {OWNER, CUSTOMER, JOIN, DEFAULT}

    private Command enumValue(int input) {
        Command command;
        if (input == 1) {
            command = Command.OWNER;
        } else if (input == 2) {
            command = Command.CUSTOMER;
        } else if (input == 3) {
            command = Command.JOIN;
        } else {
            command = Command.DEFAULT;
        }
        return command;
    }

    public void run() throws NumException, DateException {

        do {
            etcUi.startUi();
            int who = input.inputNum();
            if (who == 0) {
                etcUi.exitUi();
                return;
            }
            Command command = enumValue(who);
            librarySwitch(command);
        } while (true);
    }

    public void librarySwitch(Command co) throws NumException, DateException {
        Mode uiRun = null;

        switch (co) {
            case OWNER -> uiRun = new OwnerMode();
            case CUSTOMER -> uiRun = new CustomerMode();
            case JOIN -> uiRun = new JoinMode();
            case DEFAULT -> {
                etcUi.defaultUi();
                uiRun = EtcUi.getEtcUi();
            }
        }
        uiRun.run();
    }
}
