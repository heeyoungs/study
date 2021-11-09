public class Thread2 extends Thread{
    private Syc s;

    public void setsyc(Syc s){
        this.s = s;
    }

    public void run(){
        for(int i=0;i<5;i++){
            s.setMem("쿵");
            System.out.println(s.getMem());
        }
    }
}
