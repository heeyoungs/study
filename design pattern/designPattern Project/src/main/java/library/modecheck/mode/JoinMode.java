package library.modecheck.mode;

import library.input.Input;
import exception.NumException;
import database.query.InsertService;
import library.modecheck.EtcUi;

public class JoinMode implements Mode {

    Input input = Input.getInput();
    EtcUi etcUi = EtcUi.getEtcUi();

    public void run() throws NumException {
        joinUi();
        isJoin();
    }

    private void joinUi(){
        System.out.print("회원등록을 하시겠습니까? 등록은 1번 다른 숫자를 눌러주세요: ");
    }

    private void writeUserInfo() {
        InsertService insertService = new InsertService();

        System.out.print("전화번호를 입력해주세요(-를 포함해주세요): ");
        String phoneNum = input.inputString();
        if (!checkIsExistPhoneNum(phoneNum)) {
            System.out.println("잘못된 번호입니다!");
            return;
        }

        System.out.print("사용자 이름을 입력해주세요: ");
        String userName = input.inputString();

        insertService.joinUser(phoneNum, userName);
    }

    private void isJoin() throws NumException {

        int num = input.inputNum();
        if (num == 1) {
            writeUserInfo();
        } else {
            etcUi.logOutUi();
        }
    }

    private boolean checkIsExistPhoneNum(String phoneNum) {
        // 010-1234-5678
        int normalPhoneNumLength = 13;
        // 길이체크
        if (phoneNum.length() != normalPhoneNumLength) return false;

        for (int i = 0; i < normalPhoneNumLength; i++) {
            if (i == 3 || i == 8) {
                if (phoneNum.charAt(i) != '-') return false;
            } else {
                if (phoneNum.charAt(i) < '0' || phoneNum.charAt(i) > '9') return false;
            }
        }
        return true;
    }
}
