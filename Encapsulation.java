import java.util.Scanner;

class Encapsulation {
    private String emp_id = "PT-45435643";
    private String emp_name = "Tangella Shashipreetham Reddy";
    private String emp_role = "Project Trainee";
    private int emp_pin = 9999;
    private boolean isValid = false;

    Encapsulation() {
        System.out.println("Please Enter Your Pin");
        Scanner sc = new Scanner(System.in);
        if (sc.nextInt() == emp_pin) {
            isValid = true;
            System.out.println("Validation Successfull");
        } else {
            System.out.println("You have Entered Incorrect Pin");
            System.exit(0);
        }
        sc.close();
    }

    public String getEmp_id() {
        return isValid ? emp_id : "Not a Valid User";
    }

    public void setEmp_id(String id) {
        if (isValid)
            emp_id = id;
    }

    public String getEmp_name() {
        return isValid ? emp_name : "Not a Valid User";
    }

    public void setEmp_name(String name) {
        if (isValid)
            emp_name = name;
    }

    public String getEmp_role() {
        return isValid ? emp_role : "Not a Valid User";
    }

    public void setEmp_role(String role) {
        if (isValid)
            emp_role = role;
    }
}

// why we encapsulation?
// To hide data mainly we use encapsulation.
// In encapsulation we will create getters and setters for hidded data because
// of data privacy if there are getters and setter then there we can verify
// weather the user is valid user or not by certain validation methods.