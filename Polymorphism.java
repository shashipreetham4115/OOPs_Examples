class SuperClass {
    int wallet = 10;

    // Compile time polymorphism
    // Method Overloading
    public void method() {
        System.out.println("Hello Super Class");
    }

    public void method(String name) {
        System.out.println("Hello " + name);
    }
}

public class Polymorphism extends SuperClass {
    int wallet = 11;

    // Run time polymorphism
    // Method Overiding
    public void method() {
        System.out.println("Hello Sub Class");
    }

    // for calling super class properties we use super keyword
    public int getWallet() {
        return super.wallet;
    }

}

// 1) why we use overloading ?
// There are some cases were we can't solve problem by single method. So that if
// there is overoading we can take different parameters from same method.
// for Example String.valueOf(variable); here we don't know what user want's to
// send, if he send's boolean value but our code only supports int means there
// is issue.

// 2) why we need overiding ?
// There are some cases were user want's to create some change in builtin
// functionality of class.
// he need proporties of class but he want to create some changes in builtin
// methods.
// he cant change them so only option is to create a new method with same name
// so that he can cretae his know functionality there
