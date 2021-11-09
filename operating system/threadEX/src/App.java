public class App {
    public static void main(String[] args) {
        Syc syc = new Syc();

        Thread1 th1 = new Thread1();
        Thread2 th2 = new Thread2();

        th1.setsyc(syc);
        th2.setsyc(syc);

        th1.start();
        th2.start();

        System.out.println(syc.getMem());
    }
}
