package compoundpattern.factory;

import compoundpattern.quack.QuackCounter;
import compoundpattern.quack.Quackable;
import compoundpattern.duck.DuckCall;
import compoundpattern.duck.MallardDuck;
import compoundpattern.duck.RedheadDuck;
import compoundpattern.duck.RubberDuck;

public class CountingDuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }
}
