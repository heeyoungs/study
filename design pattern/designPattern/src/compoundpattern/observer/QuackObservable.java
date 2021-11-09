package compoundpattern.observer;

public interface QuackObservable {
    public void registerObserver(Observer observer);
    public void notifyObserver();
}
