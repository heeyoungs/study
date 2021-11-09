package compoundpattern.duck;

import compoundpattern.observer.Observable;
import compoundpattern.observer.Observer;
import compoundpattern.quack.Quackable;

public class RedheadDuck implements Quackable {
    Observable observable;

    public RedheadDuck() {
        observable = new Observable(this);
    }

    public void quack() {
        System.out.println("Quack");
        notifyObserver();
    }


    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObserver() {
        observable.notifyObserver();
    }

    @Override
    public String toString(){
        return "Redhead Duck";
    }
}
