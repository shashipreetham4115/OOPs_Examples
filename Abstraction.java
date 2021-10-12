interface Vehicle1 {
    public void start();
}

abstract class Vehicle2 {
    abstract void stop();

    public void ChangeGear() {
        System.out.println("Gear Changed");
    }
}

public class Abstraction extends Vehicle2 implements Vehicle1 {
    public void start() {
        System.out.println("Vehicle Started");
    };

    public void stop() {
        System.out.println("Vehicle Stopped");
    }
}
