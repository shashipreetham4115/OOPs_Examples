package ConsoleApplications.ReservationSystem;

public class ReusedMethods {
    public static void print(Passenger p) {
        System.out.println("--------------------------\n");
        System.out.println("Ticket ID : " + p.p_id);
        System.out.println("Name      : " + p.p_name);
        System.out.println("Age       : " + p.p_age);
        System.out.println("Birth     : " + p.p_birth);
        System.out.println("--------------------------\n");
    }
}
