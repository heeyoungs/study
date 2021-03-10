package ch12_;

public class ThreadExample_ {
    public static void main(String[] args){
        Thread thread = new MovieThread_();
        thread.start();

        try{Thread.sleep(1000);}catch (InterruptedException e){}

        thread.interrupt();
    }
}
