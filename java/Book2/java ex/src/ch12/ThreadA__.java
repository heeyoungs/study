package ch12;

public class ThreadA__ extends Thread{
    private WorkObject workObject;

    public ThreadA__(WorkObject workObject){
        this.workObject = workObject;
    }

    @Override
    public void run(){
        for(int i=0;i<10;i++){
            workObject.methodA();
        }
    }
}
