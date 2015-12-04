package main.java.com.personal.DesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by riyaz on 22/11/15.
 */
interface DisplayElements {
    void display();
}

interface Observer {
    void update(float t, float h, float p);
}

interface Subject {
    boolean subscribe(Observer o);

    boolean unsubcribe(Observer o);

    void notifyAllSubscriber();
}

class Weather implements Subject {
    List<Observer> observers;
    float temperature;
    float humidity;
    float pressure;

    public Weather() {
        this.observers = new ArrayList<>();
    }

    @Override
    public boolean subscribe(Observer o) {
        return observers.add(o) == true;
    }

    @Override
    public boolean unsubcribe(Observer o) {
        return observers.remove(o) == true;
    }

    @Override
    public void notifyAllSubscriber() {
        int size = observers.size();
        for (int i = 0; i < size; ++i) {
            observers.get(i).update(temperature, humidity, pressure);
        }
    }

    void setStatistics(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyAllSubscriber();
    }
}

class CurrentConditions implements Observer, DisplayElements {
    Weather wetherObjet;
    float temperature;
    float humidity;
    float pressure;

    public CurrentConditions(Weather wetherObjet) {
        this.wetherObjet = wetherObjet;
        wetherObjet.subscribe(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions of all the variables" + temperature + "\t" + humidity + "\t" + pressure);
    }

    @Override
    public void update(float t, float h, float p) {
        this.temperature = t;
        this.humidity = h;
        this.pressure = p;
    }
}

class StatisticsDisplay implements Observer, DisplayElements {
    Weather wetherObjet;
    float temperature;
    float humidity;
    float pressure;

    public StatisticsDisplay(Weather wetherObjet) {
        this.wetherObjet = wetherObjet;
        wetherObjet.subscribe(this);
    }

    @Override
    public void display() {
        System.out.println("StatisticsDisplay" + temperature + "\t" + humidity + "\t" + pressure);
    }

    @Override
    public void update(float t, float h, float p) {
        this.temperature = t;
        this.humidity = h;
        this.pressure = p;
    }
}

class ForecastDisplay implements Observer, DisplayElements {
    Weather wetherObjet;
    float temperature;
    float humidity;
    float pressure;

    public ForecastDisplay(Weather wetherObjet) {
        this.wetherObjet = wetherObjet;
        wetherObjet.subscribe(this);
    }

    @Override
    public void display() {
        System.out.println("ForecastDisplay" + temperature + "\t" + humidity + "\t" + pressure);
    }

    @Override
    public void update(float t, float h, float p) {
        this.temperature = t;
        this.humidity = h;
        this.pressure = p;
    }
}


public class WeatherStation {
    public static void main(String[] args) {
        Weather weather = new Weather();
        CurrentConditions conditions = new CurrentConditions(weather);
        StatisticsDisplay stats = new StatisticsDisplay(weather);
        ForecastDisplay forecast = new ForecastDisplay(weather);
        weather.setStatistics(10f, 20f, 30f);
        forecast.display();
        stats.display();
        conditions.display();
    }
}