package ch12;

public class YieldExample {
    public static void main(String[] args){
        ThreadA_ threadA_ = new ThreadA_();
        ThreadB_ threadB_ = new ThreadB_();

        threadA_.start();
        threadB_.start();

        try{
            Thread.sleep(3000);
        }catch (Exception e){}
        threadA_.work = false;

        try{
            Thread.sleep(3000);
        }catch (Exception e){}
        threadA_.work = true;

        try{
            Thread.sleep(3000);
        }catch (Exception e) {}
        threadA_.stop = true;
        threadB_.stop = true;
    }
}
