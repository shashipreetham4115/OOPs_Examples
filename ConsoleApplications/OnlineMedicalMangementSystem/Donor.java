package ConsoleApplications.OnlineMedicalMangementSystem;

import java.util.Date;

public class Donor {
    String name, id, gender, bg, organ, issues, status;
    long number;
    int age;
    boolean phc;
    Date d = new Date();

    Donor(String name, int age, String gender, String bg, String organ, String issues, boolean phc, long number,
            String status) {
        this.name = name;
        this.gender = gender;
        this.bg = bg;
        this.organ = organ;
        this.phc = phc;
        this.issues = issues;
        this.number = number;
        this.status = status;
        this.age = age;
        this.id = "g" + d.getTime();
    }
}
