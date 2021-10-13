class GrandParent {
    public void Keypad() {
        System.out.println("Nokia Keypad");
    }

    public void Desktop() {
        System.out.println("Acer Desktop");
    }
}

class Parent extends GrandParent {
    public void Macbook() {
        System.out.println("Macbook Pro");
    }

    public void Android() {
        System.out.println("Redmi Note 10 Pro");
    }
}

public class Inheritance extends Parent {
    public void Iphone() {
        System.out.println("Iphone 11 Pro Max");
    }

    public void Windows() {
        System.out.println("Hp Elite");
    }
}

// why we use inheritance?

// Instead of re writing code which is already writtien we can inherit a class
// to access all properties what we want...
// Disadvantages: if we need to remove any method we need to to through all
// classes which are inheriting this it is so complex...