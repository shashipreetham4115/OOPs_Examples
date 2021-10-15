package ConsoleApplications.ReservationSystem;

import java.util.*;

public class TicketBook extends ReusedMethods implements BookingServices {
    static int available_tickets = 0;
    static int rac_tickets = 0;
    static int waiting_tickets = 0;
    static int totalNoofTickets = 0;

    TicketBook() {
        available_tickets = 5;
        rac_tickets = 2;
        waiting_tickets = 2;
        totalNoofTickets = 9;
    }

    TicketBook(int at, int rt, int wt) {
        available_tickets = at;
        rac_tickets = rt;
        waiting_tickets = wt;
        totalNoofTickets = at + rt + wt;
    }

    int compartment = 1;
    String seat_birth = "L";
    int seating = 1;
    int no_of_rac_passengers = 1;
    int no_of_wl_passengers = 1;

    Queue<Integer> rac_waiting_list = new LinkedList<Integer>();
    Queue<Integer> waiting_list = new LinkedList<Integer>();

    Map<Integer, Passenger> passenger_details = new HashMap<Integer, Passenger>();

    public void bookTicket(String name, int age) {
        Passenger p = new Passenger(totalNoofTickets, name, age, "");
        if (available_tickets > 0) {
            p.p_birth = "S" + compartment + "/" + seating + "/" + seat_birth;
            passenger_details.put(totalNoofTickets, p);
            if (seating > 10) {
                compartment++;
                seat_birth = "L";
                seating = 1;
            } else {
                seating++;
                if (seat_birth.equals("L"))
                    seat_birth = "M";
                else if (seat_birth.equals("M"))
                    seat_birth = "U";
                else
                    seat_birth = "L";
            }
            available_tickets--;
        } else if (rac_tickets > 0) {
            p.p_birth = "RAC" + "/" + no_of_rac_passengers++;
            passenger_details.put(totalNoofTickets, p);
            rac_waiting_list.add(totalNoofTickets);
            rac_tickets--;
        } else if (waiting_tickets > 0) {
            p.p_birth = "WL" + "/" + no_of_wl_passengers++;
            passenger_details.put(totalNoofTickets, p);
            waiting_list.add(totalNoofTickets);
            waiting_tickets--;
        }
        totalNoofTickets--;
        System.out.println("\nTicket Booked Successfully\n");
        print(p);
    }

    public void cancelTicket(int id) {
        if (passenger_details.containsKey(id)) {
            if (!rac_waiting_list.isEmpty()) {
                String rac_birth = passenger_details.get(id).p_birth;
                int rac_id = rac_waiting_list.poll();
                String wl_birth = passenger_details.get(rac_id).p_birth;
                Passenger racP = passenger_details.get(rac_id);
                racP.p_birth = rac_birth;
                if (!waiting_list.isEmpty()) {
                    Passenger WLP = passenger_details.get(waiting_list.poll());
                    WLP.p_birth = wl_birth;
                    waiting_tickets++;
                } else
                    rac_tickets++;
            } else
                available_tickets++;
            passenger_details.remove(id);
            System.out.println("Ticket Cancelled Successfully");
        } else {
            System.out.println("Invalid Ticket ID");
        }
    }

    public void printTicket(int id) {
        if (passenger_details.containsKey(id))
            print(passenger_details.get(id));
        else
            System.out.println("Please Enter the Valid Ticket ID");
    }

    public void printPassengers() {
        if (passenger_details.size() == 0) {
            System.out.println("No details of passengers");
            return;
        }
        for (Passenger p : passenger_details.values()) {
            print(p);
        }
    }
}
