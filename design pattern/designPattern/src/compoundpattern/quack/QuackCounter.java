package compoundpattern.quack;

import compoundpattern.observer.Observer;

public class QuackCounter implements Quackable {
    Quackable duck;
    static int numberOfQuack;

    public QuackCounter (Quackable duck){
        this.duck = duck;
    }

    public void quack(){
        duck.quack();
        numberOfQuack++;
    }

    public static int getQuacks(){
        return numberOfQuack;
    }

    @Override
    public void registerObserver(Observer observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void notifyObserver() {
        duck.notifyObserver();
    }
}
