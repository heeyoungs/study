package ch7;

public class SnowTireExample {
    public static void main(String args[]){
        SnowTire s = (SnowTire) new Tire();

        SnowTire snowTire = new SnowTire();
        Tire tire = new SnowTire();

        snowTire.run();
        tire.run();
    }
}
