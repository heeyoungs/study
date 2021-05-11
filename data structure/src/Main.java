import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        do1 a = new do1();
        do2 b = new do2();
        a.setNum(list);
        b.checkNum(list);
    }

    static class do1 {
        public void setNum(ArrayList<Integer> list){
            System.out.print("배열 안의 난수: ");
            for(int i=0;i<3;i++){
                int rand = (int) (Math.random()*6 + 1);
                list.add(rand);
                System.out.print(rand + " ");
            }
            System.out.println();
        }
    }

    static class do2 {
        public void checkNum(ArrayList<Integer> list){
            Scanner sc = new Scanner(System.in);
            while(list.size() != 0){
                System.out.print("사용자 입력: ");
                int input = sc.nextInt();
                if (input < 0 || input > 6){
                    System.out.println("배열 값 이외의 수");
                }
                else if (list.contains(input)){
                    System.out.println("정답");
                    list.remove((Integer) input);
                }else{
                    System.out.println("오답");
                }
            }
            System.out.println("you win~");
        }
    }
}
