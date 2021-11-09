package library.login;

import library.input.Input;
import database.query.SelectService;

public class CustomerLogin {

    Input input = Input.getInput();

    public String customerLogin(){

        System.out.println("등록할 때 사용한 전화번호를 입력해주세요: ");
        String phoneNum = input.inputString();
        return checkUserNumber(phoneNum);
    }

    private String checkUserNumber(String phoneNum){
        SelectService selectService = new SelectService();

        if (selectService.isCustomerExist(phoneNum)){
            String customerName = selectService.getCustomerName(phoneNum);
            System.out.println(customerName + "님 안녕하세요!");
            return phoneNum;
        }else{
            System.out.println("존재하지 않는 사용자입니다.");
            return "-1";
        }
    }
}
