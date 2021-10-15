package ConsoleApplications.ReservationSystem;

public interface BookingServices {
    abstract void bookTicket(String name, int age);

    abstract void cancelTicket(int id);

    abstract void printTicket(int id);
}
