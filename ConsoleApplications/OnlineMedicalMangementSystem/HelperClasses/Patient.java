package ConsoleApplications.OnlineMedicalMangementSystem.HelperClasses;

public class Patient extends PatientDetails {

    public Patient(String name, int age, String bloodGroup, String gender, long number) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.number = number;
        this.id = "p" + d.getTime();
    }

}
