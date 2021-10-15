public interface Abstraction {

    abstract void start();

    abstract void stop();

    abstract int getNoofWheels();
}

class Bike implements Abstraction {

    public int getNoofWheels() {
        return 2;
    }

    public void start() {
        System.out.println("Bike Started");
    }

    public void stop() {
        System.out.println("Bike Stoped");
    }

}

class Car implements Abstraction {
    public void start() {
        System.out.println("Car Started");
    };

    public void stop() {
        System.out.println("Car Stopped");
    }

    public int getNoofWheels() {
        return 4;
    }
}

// why we need Abstraction?

// In Abstraction user no need to know the logic of methods how it is done
// inside, here user only need to know what are options available for him to use
// so that from interface he can know what the functionalities he can use.