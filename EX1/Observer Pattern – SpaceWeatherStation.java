import java.util.*;

interface Observer {
    void update(String alert);
}

class SpaceShuttle implements Observer {
    private String name;
    public SpaceShuttle(String name) { this.name = name; }
    @Override
    public void update(String alert) {
        System.out.println(name + " received weather alert: " + alert);
    }
}

class SpaceWeatherStation {
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer o) { observers.add(o); }
    public void notifyAllObservers(String alert) {
        for (Observer o : observers) o.update(alert);
    }
}

public class SpaceWeatherStationDemo {
    public static void main(String[] args) {
        SpaceWeatherStation station = new SpaceWeatherStation();
        station.addObserver(new SpaceShuttle("Apollo-X"));
        station.addObserver(new SpaceShuttle("Lunar-9"));
        
        station.notifyAllObservers("Solar Storm Incoming!");
    }
}
