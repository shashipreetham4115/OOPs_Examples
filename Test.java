class ZMain {
    public static void main(String[] args) {
        Encapsulation en = new Encapsulation();
        System.out.println(en.getEmp_id());
        en.setEmp_id("PT-4500/22");
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

        Polymorphism po = new Polymorphism();
        po.method();
        System.out.println(po.getWallet());

        System.out.println();

        Abstraction ab = new Abstraction();
        ab.start();
        ab.ChangeGear();
        ab.stop();

    }
}