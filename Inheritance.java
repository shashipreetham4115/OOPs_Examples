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
