package ConsoleApplications.OnlineMedicalMangementSystem;

public interface UserServices {
    abstract int ValidateUser(String un, String pw, boolean isPatient);

    abstract void ChangePassword(int id);

    abstract void addDoctor();

    abstract void addPatient();
}