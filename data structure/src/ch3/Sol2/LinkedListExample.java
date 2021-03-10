package ch3.Sol2;

import java.util.Scanner;

public class LinkedListExample {
    public static void main(String[] args){
        double input;
        int count = 1;
        Scanner scanner = new Scanner(System.in);
        LinkedList score = new LinkedList();
        while(true){
            System.out.print("> " + count + "번째 점수는(-1을 입력하면 끝납니다)? ");
            try {
                input = scanner.nextDouble();
                if (input == -1) { // 종료 구문
                    double sum = score.sum();
                    double avg = sum / (double) (count - 1);
                    System.out.println((count - 1) + "명의 평균: " + avg);
                    return;
                }
                score.addNode(input);
                count++;
            }catch (Exception e){
                System.out.println("1명 이상의 점수를 입력해야 합니다.");
                return;
            }
        }
    }
}
