package ConsoleApplications.ReservationSystem;

public interface UserServices {
    abstract int ValidateUser(String un, String pw);

    abstract void ChangePassword(int id);

    abstract void addNewUser(String u, String p, String f);
}
