package ch12;

public class ThreadB__ extends Thread{
    private WorkObject workObject;

    public ThreadB__(WorkObject workObject){
        this.workObject = workObject;
    }

    @Override
    public void run(){
        for(int i=0;i<10;i++){
            workObject.methodB();
        }
    }
}
