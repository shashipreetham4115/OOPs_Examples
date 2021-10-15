package ConsoleApplications.ReservationSystem;

import java.util.Date;

public class Passenger {
    long p_id;
    String p_name;
    int p_age;
    String p_birth;
    String p_status;
    Date d = new Date();

    Passenger(String name, int age, String birth, String status) {
        p_id = d.getTime();
        p_name = name;
        p_age = age;
        p_birth = birth;
        p_status = status;
    }
}
