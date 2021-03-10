package ch12;

public class WaitNotifyExample {
    public static void main(String[] args){
        WorkObject sharedObject = new WorkObject();
        ThreadA__ threadA__ = new ThreadA__(sharedObject);
        ThreadB__ threadB__ = new ThreadB__(sharedObject);

        threadA__.start();
        threadB__.start();
    }
}
