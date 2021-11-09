package compoundpattern.quack;

import compoundpattern.observer.QuackObservable;

public interface Quackable extends QuackObservable {
    public void quack();
}
