package ch12_;

public class MovieThread_ extends Thread{
    @Override
    public void run(){
        while(true){
            System.out.println("동영상을 재생합니다.");
            if(interrupted()){
                break;
            }
        }
    }
}
