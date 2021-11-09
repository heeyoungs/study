package library.modecheck.mode;

import exception.DateException;
import exception.NumException;

public interface Mode {

    void run() throws NumException, DateException;
}
