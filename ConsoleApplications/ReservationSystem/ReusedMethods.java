package ConsoleApplications.ReservationSystem;

import java.util.*;

public class ReusedMethods {

    Queue<Integer> rac_waiting_list = new LinkedList<Integer>();
    Queue<Integer> waiting_list = new LinkedList<Integer>();

    Map<Integer, Passenger> passenger_details = new HashMap<Integer, Passenger>();

    public void print(Passenger p) {
        System.out.println("--------------------------\n");
        System.out.println("Ticket ID : " + p.p_id);
        System.out.println("Name      : " + p.p_name);
        System.out.println("Age       : " + p.p_age);
        System.out.println("Birth     : " + p.p_birth);
        System.out.println("--------------------------\n");
    }

    public void MakeBirthCorrections(String qn) {
        int j = 1;
        for (Integer i : qn.equals("RAC") ? rac_waiting_list : waiting_list) {
            passenger_details.get(i).p_birth = qn + "/" + j;
            passenger_details.get(i).p_status = qn;
            j++;
        }
    }
}
