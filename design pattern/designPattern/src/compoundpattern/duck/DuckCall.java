package compoundpattern.duck;

import compoundpattern.observer.Observable;
import compoundpattern.observer.Observer;
import compoundpattern.quack.Quackable;

public class DuckCall implements Quackable {
    Observable observable;

    public DuckCall(){
        observable = new Observable(this);
    }

    public void quack() {
        System.out.println("Kwak");
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
        return "DuckCall";
    }
}
