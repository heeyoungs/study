package ch8.p3;

public class SoundalbeExample {
    private static void printSound(Soundable soundalbe){
        System.out.println(soundalbe.sound());
    }

    public static void main(String args[]){
        printSound(new Cat());
        printSound(new Dog());
    }
}
