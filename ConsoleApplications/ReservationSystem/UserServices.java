package ConsoleApplications.ReservationSystem;

public interface UserServices {
    abstract void ValidateUser(String un, String pw);

    abstract void changePassword(int id);

    abstract void addNewUser(String u, String p, String f);
}
