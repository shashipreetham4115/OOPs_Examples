package ConsoleApplications.OnlineMedicalMangementSystem;

public class Donor extends PatientDetails {
    String organ, issues, status;
    boolean phc;

    Donor(String name, int age, String gender, String bg, String organ, String issues, boolean phc, long number,
            String status) {
        this.name = name;
        this.gender = gender;
        this.bloodGroup = bg;
        this.organ = organ;
        this.phc = phc;
        this.issues = issues;
        this.number = number;
        this.status = status;
        this.age = age;
        this.id = "g" + d.getTime();
    }
}
