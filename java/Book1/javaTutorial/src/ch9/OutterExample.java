package ch9;

public class OutterExample {
    public static void main(String args[]){
        Outter outter = new Outter();
        Outter.Nested nested = outter.new Nested();
        nested.print();
    }
}
