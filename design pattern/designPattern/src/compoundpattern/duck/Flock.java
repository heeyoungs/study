package compoundpattern.duck;

import compoundpattern.observer.Observable;
import compoundpattern.observer.Observer;
import compoundpattern.quack.Quackable;

import java.rmi.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable {
    ArrayList quackers = new ArrayList();
    Observable observable = new Observable(this);

    public void add(Quackable quacker){
        quackers.add(quacker);
    }

    public void quack(){
        Iterator iterator = quackers.iterator();
        while(iterator.hasNext()){
            Quackable quacker = (Quackable) iterator.next();
            quacker.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        Iterator iterator = quackers.iterator();
        while(iterator.hasNext()){
            Quackable duck = (Quackable) iterator.next();
            duck.registerObserver(observer);
        }
    }

    @Override
    public void notifyObserver() {
        observable.notifyObserver();
    }
}
