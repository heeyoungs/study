package ch12_;

public class ThreadExample__ {
    public static void main(String[] args){
        Thread thread = new MovieThread__();
        thread.setDaemon(true);
        thread.start();

        try{Thread.sleep(3000);}catch(InterruptedException e){}
    }
}
