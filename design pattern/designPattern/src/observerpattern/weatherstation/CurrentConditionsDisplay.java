package observerpattern.weatherstation;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature,float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    } // notifyObservers의 update 메소드

    public void display(){
        System.out.println("Current conditions: " + temperature + "F degree and " +
                humidity + "% humidity");
    }
}
