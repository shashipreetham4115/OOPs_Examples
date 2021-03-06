package ConsoleApplications.OnlineMedicalMangementSystem;

import java.util.*;

public class ServicesForDoctor extends ServicesForPatient implements DoctorServices {

    public void AddMedicalPrescription(String dID) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n----------------------------------------------");
        System.out.println("---------Adding Medical Prescription----------\n");

        System.out.print("Please Enter Patient ID        : ");
        String pID = scanner.next();

        System.out.print("Please Enter Date              : ");
        String date = scanner.next();

        System.out.print("Please Enter Health Issue      : ");
        String reason = scanner.next();

        System.out.print("Please Enter Status of Patient : ");
        String status = scanner.next();

        System.out.println("Please Give E-Prescription : ");
        String diagnosis = "";
        while (scanner.hasNext()) {
            String temp = scanner.nextLine();
            if (temp.equals("--q"))
                break;
            diagnosis = diagnosis + "\n" + temp;
        }
        System.out.println("Please Give Healthcare Suggestions : ");
        String suggestions = "";
        while (scanner.hasNext()) {
            String temp = scanner.nextLine();
            if (temp.equals("--q"))
                break;
            suggestions = suggestions + "\n" + temp;
        }
        System.out.println("Is any donor helped if yes please enter donor id else enter -1 : ");

        String donorId = scanner.next();

        if (donorId.charAt(0) == 'g') {
            if (donors_db.containsKey(donorId)) {
                donors_db.get(donorId).status = "Donated";
            }
        }
        MedicalReport mr = new MedicalReport(date, reason, status, diagnosis, suggestions, dID, donorId);

        if (!medicalReports_db.containsKey(pID)) {
            medicalReports_db.put(pID, new ArrayList<MedicalReport>());
        }
        medicalReports_db.get(pID).add(mr);
        System.out.println("\n----------------------------------------------");

        System.out.println(" New Report Added Successfully");
    }

    public void ViewDoctorAppointments(Doctor d, Map<String, Patient> map) {
        String[] sts = { "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "1:30 PM", "2:30 PM", "3:30 PM", "4:30 PM",
                "5:30 PM" };
        int i = 0;
        for (String s : sts) {
            String sl = d.slots.get(s);
            if (!sl.equals("")) {
                i++;
                Patient p = map.get(sl);
                System.out.println("---------------------------------------");

                System.out.println("\n Patient Details and Slot\n");

                System.out.println("Patietn ID    : " + p.id);
                System.out.println("Name          : " + p.name);
                System.out.println("Age           : " + p.age);
                System.out.println("Gender        : " + p.gender);
                System.out.println("Blood Group   : " + p.bloodGroup);
                System.out.println("Mobile Number : " + p.number);
                System.out.println("Slot          : " + s);

                System.out.println("\n---------------------------------------");
            }
        }
        if (i == 0)
            System.out.println("\nNo Appointments till Now");
    }
}
