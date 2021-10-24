package ConsoleApplications.OnlineMedicalMangementSystem;

import java.util.Date;

public class Patient {
    String name, gender, bloodGroup;
    int age;
    String id;
    long number;

    Date d = new Date();

    Patient(String name, int age, String bloodGroup, String gender, long number) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.number = number;
        this.id = "p" + d.getTime();
    }
}
