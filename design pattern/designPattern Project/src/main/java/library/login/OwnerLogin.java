package library.login;

import library.input.Input;
import database.query.SelectService;

public class OwnerLogin {

    Input input = Input.getInput();

    public void ownerLogin() {
        System.out.println("비밀번호를 입력해주세요, 3회 틀리면 종료됩니다.");
        checkOwnerPassword();
    }

    private void checkOwnerPassword() {
        SelectService selectService = new SelectService();

        for (int passwordCount = 1; passwordCount <= 3; passwordCount++) {
            String inputPassword = input.inputString();
            if (inputPassword.equals(selectService.getOwnerPassword())) {
                System.out.println("\t\t[관리자]");
                return;
            } else {
                System.out.println("비밀번호를 " + ++passwordCount + "번 만큼 들렸습니다.");
                if (passwordCount == 3) {
                    System.out.println("비밀번호를 3회 틀려서 프로그램이 강제종료됩니다.");
                    System.exit(0);
                }
            }
        }
    }
}
