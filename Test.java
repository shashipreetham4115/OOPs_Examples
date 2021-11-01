class Test {
    public static void main(String[] args) {
        Encapsulation en = new Encapsulation();
        System.out.println(en.getEmp_id());
        en.setEmp_id("PT345656");
        System.out.println(en.getEmp_id());

        System.out.println();

        Inheritance in = new Inheritance();
        in.Android();
        in.Iphone();
        in.Macbook();
        in.Windows();
        in.Keypad();
        in.Desktop();

        System.out.println();

        SuperClass po = new Polymorphism();
        po.method();
        Polymorphism p = new Polymorphism();
        System.out.println(p.getWallet());

        System.out.println();

        Abstraction car = new Car();
        car.start();
        car.stop();
        System.out.println("No of Wheels : " + car.getNoofWheels());

        System.out.println();

        Abstraction bike = new Bike();
        bike.start();
        bike.stop();
        System.out.println("No of Wheels : " + bike.getNoofWheels());

    }
}