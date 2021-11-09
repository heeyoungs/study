package compoundpattern.duck;

import compoundpattern.quack.Quackable;
import compoundpattern.observer.Observable;
import compoundpattern.observer.Observer;

public class GooseAdapter implements Quackable {
    Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    public void quack() {
        goose.honk();
    }
}
