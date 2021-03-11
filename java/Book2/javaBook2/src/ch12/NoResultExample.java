package ch12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class NoResultExample {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors() // 현재 컴퓨터의 cpu의 코어의 수 (8)
        );

        System.out.println("[작업 처리 요청]");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sum =0;
                for(int i=0;i<=10;i++){sum += i;}
                System.out.println("[처리 결과] " + sum);
            }
        };
        Future future = executorService.submit(runnable);

        try{
            future.get();// 블로킹한다 -> 대기!
            System.out.println("[작업 처리 완료]");
        }catch (Exception e){
            System.out.println("[실행 예외 발생함] " + e.getMessage());
        }
        executorService.shutdown(); // 스레드풀 종료
    }
}
