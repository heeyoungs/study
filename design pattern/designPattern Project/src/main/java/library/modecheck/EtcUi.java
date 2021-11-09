package library.modecheck;

import library.modecheck.mode.Mode;

public class EtcUi implements Mode {

    private static EtcUi etcUi = new EtcUi();

    private EtcUi(){}

    public static EtcUi getEtcUi(){
        return etcUi;
    }

    public void run(){}

    public void startUi() {
        System.out.println("안녕하세요. 자바 도서관에 오신 것을 환영합니다.");
        System.out.println("관리자는 1번, 손님은 2번, 등록은 3번 종료하시려면 0번을 눌러주세요.");
    }

    public void exitUi() {
        System.out.println("감사합니다. 다음에 또 이용해주세요!");
    }

    public void logOutUi() {
        System.out.println("초기화면으로 돌아갑니다.");
    }

    public void defaultUi() {
        System.out.println("표기된 숫자 중에 하나를 눌러주세요!");
    }
}
