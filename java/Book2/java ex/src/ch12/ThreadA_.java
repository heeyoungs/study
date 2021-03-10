package ch12;

public class ThreadA_ extends Thread{
    public boolean stop = false;
    public boolean work = true;

    public void run(){
        while(!stop){
            if(work){
                System.out.println("ThreadA_ 작업 내용");
            }
            else{
                Thread.yield();
            }
        }
        System.out.println("ThreadA 종료");
    }
}
