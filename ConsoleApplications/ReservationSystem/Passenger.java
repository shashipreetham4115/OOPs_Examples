package ConsoleApplications.ReservationSystem;

public class Passenger {
    int p_id;
    String p_name;
    int p_age;
    String p_birth;
    String p_status;

    Passenger(int id, String name, int age, String birth, String status) {
        p_id = id;
        p_name = name;
        p_age = age;
        p_birth = birth;
        p_status = status;
    }
}
