package ConsoleApplications.ReservationSystem;

public interface BookingServices {
    abstract void bookTicket(String name, int age);

    abstract void cancelTicket(long id);

    abstract void printTicket(long id);
}
