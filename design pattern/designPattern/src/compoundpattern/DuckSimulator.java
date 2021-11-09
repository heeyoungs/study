package compoundpattern;

import compoundpattern.duck.Goose;
import compoundpattern.duck.GooseAdapter;
import compoundpattern.quack.QuackCounter;
import compoundpattern.quack.Quackologist;
import compoundpattern.factory.AbstractDuckFactory;
import compoundpattern.factory.CountingDuckFactory;
import compoundpattern.duck.Flock;
import compoundpattern.quack.Quackable;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();

        simulator.simulate(duckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("\nDuck Simulator");

        Flock flockOfDucks = new Flock();

        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();

        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        flockOfDucks.add(flockOfMallards);
//
//        System.out.println("wholes");
//        simulate(flockOfDucks);
//
//        System.out.println("mallard");
//        simulate(flockOfMallards);

//        System.out.println(QuackCounter.getQuacks());
        System.out.println("\nDuck Simulator : With Observer");
        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);

        simulate(flockOfDucks);

        System.out.println(QuackCounter.getQuacks());
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
