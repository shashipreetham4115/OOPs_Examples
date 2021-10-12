class SuperClass {
    int wallet = 10;

    // Compile time polymorphism
    // Method Overloading
    public void method() {
        System.out.println("Method1");
    }

    public void method(String hello) {
        System.out.println(hello);
    }
}

public class Polymorphism extends SuperClass {
    int wallet = 11;

    // Run time polymorphism
    // Method Overiding
    public void method() {
        System.out.println("Sub Class");
    }

    // for calling super class properties we use super key word
    public int getWallet() {
        return super.wallet;
    }

}
