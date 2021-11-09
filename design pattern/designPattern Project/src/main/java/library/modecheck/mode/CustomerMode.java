package library.modecheck.mode;

import database.query.DeleteService;
import library.input.Input;
import exception.NumException;
import library.login.CustomerLogin;
import database.query.SelectService;
import database.query.UpdateService;
import library.modecheck.EtcUi;

public class CustomerMode implements Mode {

    EtcUi etcUi = EtcUi.getEtcUi();
    Input input = Input.getInput();

    private enum CustomerSkill {BORROW, RETURN, CHECK_ALL, CHECK_BORROW, RESIGN, DEFAULT}

    private CustomerSkill enumValue(int input) {
        CustomerSkill customerSkill;
        if (input == 1) {
            customerSkill = CustomerSkill.BORROW;
        } else if (input == 2) {
            customerSkill = CustomerSkill.RETURN;
        } else if (input == 3) {
            customerSkill = CustomerSkill.CHECK_ALL;
        } else if (input == 4) {
            customerSkill = CustomerSkill.CHECK_BORROW;
        } else if (input == 5) {
            customerSkill = CustomerSkill.RESIGN;
        } else {
            customerSkill = CustomerSkill.DEFAULT;
        }
        return customerSkill;
    }

    private void customerUi() {
        System.out.println("-------------------------");
        System.out.println("어떤 기능을 이용하실 건가요.");
        System.out.println("1.책 빌려가기");
        System.out.println("2.책 반납하기");
        System.out.println("3.책 목록 확인하기");
        System.out.println("4.대여목록 확인하기");
        System.out.println("5.탈퇴하기");
        System.out.println("0.손님 모드 종료하기");
        System.out.print("입력 : ");
    }

    public void run() throws NumException {

        CustomerLogin customerLogin = new CustomerLogin();
        String phoneNum = customerLogin.customerLogin();

        if (phoneNum.equals("-1")) {
            return;
        }

        do {
            customerUi();
            int num = input.inputNum();
            if (num == 0) {
                etcUi.logOutUi();
                return;
            }
            CustomerSkill customerSkill = enumValue(num);
            customerSwitch(customerSkill, phoneNum);
        } while (true);
    }

    private void customerSwitch(CustomerSkill customerSkill, String phoneNum) throws NumException {
        UpdateService updateService = new UpdateService();
        SelectService selectService = new SelectService();
        DeleteService deleteService = new DeleteService();

        switch (customerSkill) {
            case BORROW -> updateService.borrowBook(phoneNum);
            case RETURN -> updateService.returnBook(phoneNum);
            case CHECK_ALL -> selectService.showBookList();
            case CHECK_BORROW -> selectService.showBorrowBookList(phoneNum);
            case RESIGN -> deleteService.resignUser(phoneNum);
            case DEFAULT -> etcUi.defaultUi();
        }
    }
}
