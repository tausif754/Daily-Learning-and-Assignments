

interface Engine {
    void start();
}

class ElectricalEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    void drive() {
        engine.start();
        System.out.println("Car started driving");
    }
}

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        Engine engine = new ElectricalEngine(); 
        Car car = new Car(engine);
        car.drive(); 
    }
}