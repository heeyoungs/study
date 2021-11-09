package compoundpattern.quack;

import compoundpattern.observer.Observer;
import compoundpattern.observer.QuackObservable;

public class Quackologist implements Observer {
    public void update(QuackObservable duck){
        System.out.println("Quackologist: " + duck + " just quacked. ");
    }
}
