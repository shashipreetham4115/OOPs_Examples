package ConsoleApplications.ReservationSystem;

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

    // This is book ticket method.
    public void bookTicket(String name, int age) {

        // First it creates a new Passenger Object
        Passenger p = new Passenger(name, age, "", "");

        // Then it Checks Wheather the Tickets are available.
        if (available_tickets > 0) {
            // Here it creates a birth like which compartment and seat number and middle or
            // upper or lower.
            p.p_birth = "S" + compartment + "/" + seating + "/" + seat_birth;
            p.p_status = "SL";
            // Then here it add the passengers to passenger_details map with a ticket_id as
            // a key.
            // where ticket_id is total noof tickets available
            passenger_details.put(p.p_id, p);

            // Here iam assumming there are 10 seats in a compartment
            if (seating > 10) {

                // so when ever seating reaches 10 then iam going to change compartment
                compartment++;
                seat_birth = "L";
                seating = 1;
            } else {

                // for every ticket iam increasing seat number and change birth
                seating++;
                if (seat_birth.equals("L"))
                    seat_birth = "M";
                else if (seat_birth.equals("M"))
                    seat_birth = "U";
                else
                    seat_birth = "L";
            }
            available_tickets--;

            // Here if there are no available tickets then it checks wheather there are
            // rac_tickets.
        } else if (rac_tickets > 0) {
            // here it create a status of the ticket along with waiting list number.
            p.p_birth = "RAC" + "/" + no_of_rac_passengers++;
            p.p_status = "RAC";

            // Then here it add the passengers to passenger_details map with a ticket_id as
            // a key.
            // where ticket_id is total noof tickets available
            passenger_details.put(p.p_id, p);

            // for every passengers in rac it maintains a queue so here iam adding every rac
            // passenger to rac queue
            rac_waiting_list.add(p.p_id);
            rac_tickets--;

            // here if there are no tickets then it adds in a waiting_list
        } else {
            // here it create a status of the ticket along with waiting list number.
            p.p_birth = "WL" + "/" + no_of_wl_passengers++;
            p.p_status = "WL";

            // Then here it add the passengers to passenger_details map with a ticket_id as
            // a key.
            // where ticket_id is total noof tickets available
            passenger_details.put(p.p_id, p);

            // for every passengers in waiting list it maintains a queue so here iam adding
            // every wl passenger to waiting list queue
            waiting_list.add(p.p_id);
            waiting_tickets--;
        }
        totalNoofTickets--;
        System.out.println("\nTicket Booked Successfully\n");
        print(p);
    }

    // this is method used for canceling Tickets
    public void cancelTicket(long id) {

        // First it checks wheather ticket is booked or not with given ticket id.
        if (passenger_details.containsKey(id)) {

            // Checks status of ticket if it is general then, Before removing the ticket
            // from the passenger list it checks wheather any ticket is in rac waiting
            // queue.
            if (passenger_details.get(id).p_status.equals("SL")) {
                if (!rac_waiting_list.isEmpty()) {

                    // if yes it gives the canceled ticket to rac
                    String rac_birth = passenger_details.get(id).p_birth;
                    long rac_id = rac_waiting_list.poll();

                    // and then it changes the birth of passenger to general from rac
                    Passenger racP = passenger_details.get(rac_id);
                    racP.p_birth = rac_birth;
                    racP.p_status = "SL";

                    // here it checls weather there is any waiting list queue
                    if (!waiting_list.isEmpty()) {

                        // if yes then it adds head of the waiting list queue in rac_waiting_list queue
                        rac_waiting_list.add(waiting_list.poll());
                        waiting_tickets++;

                        // this is birth correction method where after removing any birth status will be
                        // corrected using this method
                        MakeBirthCorrections("WL");
                    } else
                        rac_tickets++;

                    MakeBirthCorrections("RAC");
                } else
                    available_tickets++;

                // Here it checks weather given passenger_id is in rac then it will remove and
                // make checks for waiting_list queue if any.
            } else if (passenger_details.get(id).p_birth.equals("RAC")) {
                rac_waiting_list.remove(id);

                // if there is any waiting list passengers then it addes them to
                // rac_waiting_list queue.
                if (!waiting_list.isEmpty()) {
                    rac_waiting_list.add(waiting_list.poll());
                    waiting_tickets++;
                } else
                    rac_tickets++;

                MakeBirthCorrections("RAC");

                // Else given id is an waiting list id then it removes the id from waiting_list
                // queue.
            } else {
                waiting_list.remove(id);
                MakeBirthCorrections("WL");
                waiting_tickets++;
            }

            // At last here it will remove the canceled ticket from the passenger_details
            // Map.
            passenger_details.remove(id);
            System.out.println("Ticket Cancelled Successfully");

        } else {
            System.out.println("Invalid Ticket ID");
        }
    }

    // This method is for printing a particular ticket.
    public void printTicket(long id) {

        // here it checks wheather the given id is booked a ticket if yes it print the
        // passenger details else prints an error

        if (passenger_details.containsKey(id))
            print(passenger_details.get(id));
        else
            System.out.println("Please Enter the Valid Ticket ID");
    }

    // THis method is used for printing all passenger.
    public void printPassengers() {
        if (passenger_details.size() == 0) {
            System.out.println("No details of passengers");
            return;
        }
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("Ticket_ID           Name                     Age    Status/Birth");
        System.out.println("-------------------------------------------------------------");
        for (Passenger p : passenger_details.values()) {
            System.out.println(
                    " " + p.p_id + "      " + p.p_name + "                   " + p.p_age + "      " + p.p_birth);
        }
    }
}
