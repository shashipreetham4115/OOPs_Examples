package ConsoleApplications.OnlineMedicalMangementSystem;

import java.util.*;

public class ServicesForPatient {

    Map<String, ArrayList<MedicalReport>> medicalReports_db = new HashMap<String, ArrayList<MedicalReport>>();
    Map<String, Donor> donors_db = new HashMap<String, Donor>();

    public void BookAppointment(Map<String, Doctor> doctors, String patientId) {

        System.out.println("\n-----------------Doctors List----------------");
        for (Doctor d : doctors.values()) {
            System.out.println("\n---------------------------------");
            System.out.println("\nID : " + d.id);
            System.out.println(d.name);
            System.out.println(d.specialization + " \n" + d.experience + " of Experience");
        }
        System.out.println("\n---------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Please Enter Prefered Doctor ID : ");
        String doctorId = scanner.next();
        System.out.println("\n---------------------------------");
        if (doctors.containsKey(doctorId)) {
            Doctor d = doctors.get(doctorId);
            int i = 0;
            ArrayList<String> preSlot = new ArrayList<String>();
            preSlot.add("Hello");
            for (String slot : d.slots.keySet()) {
                if (d.slots.get(slot).equals("")) {
                    System.out.println(++i + ". " + slot);
                    preSlot.add(slot);
                }
            }
            if (i > 0) {
                System.out.print("Please Choose Prefered Slot : ");
                int ps = scanner.nextInt();
                d.slots.put(preSlot.get(ps), patientId);
                System.out.println("Appointment Booked Successfully");
                System.out.println("\nAppointment Details");
                System.out.println("---------------------------------");
                System.out.println("\nDoctor Name      : " + d.name);
                System.out.println("Specialization   : " + d.specialization);
                System.out.println("Experience       : " + d.experience + " Years");
                System.out.println("Appointment Time : " + preSlot.get(ps));
                System.out.println("\n---------------------------------");
            } else {
                System.out.println("All Slots are Filled");
            }
        } else {
            System.out.println("\n Please Enter Valid Doctor ID");
        }
    }

    public void ViewMedicalRecords(String patientId, Map<String, Doctor> doctors) {
        int i = 0;
        if (!medicalReports_db.isEmpty()) {
            for (MedicalReport mr : medicalReports_db.get(patientId)) {
                System.out.println("\n---------------------------------");
                System.out.println(++i + ")");
                System.out.println("\nID           : " + mr.id);
                System.out.println("Date           : " + mr.date);
                System.out.println("Reason         : " + mr.reason);
                System.out.println("Diagnosis      : " + mr.diagnosis);
                System.out.println("Patient Status : " + mr.status);
                Doctor d = doctors.get(mr.doctorId);
                System.out.println("\n Consulted Doctor Details");
                System.out.println("Doctor Name      : " + d.name);
                System.out.println("Specialization   : " + d.specialization);
                System.out.println("Experience       : " + d.experience + " Years");

                System.out.println("\n---------------------------------");
            }
        } else {
            System.out.println("\nNo Record Found");
        }
    }

    public void ViewDonors() {
        int i = 0;
        if (!donors_db.isEmpty()) {
            for (Donor god : donors_db.values()) {
                System.out.println("\n -----------------------------------------------------------------------\n");

                System.out.println(++i + ")");
                System.out.println("Donor ID              : " + god.id);
                System.out.println("Name                  : " + god.name);
                System.out.println("Age                   : " + god.age);
                System.out.println("Gender                : " + god.gender);
                System.out.println("Blood Group           : " + god.bloodGroup);
                System.out.println("Donating              : " + god.organ);
                System.out.println("Health Issues         : " + god.issues);
                System.out.println(god.phc ? "Physically Handicaped : Yes" : "Physically Handicaped : No");
                System.out.println("Phone Number          : " + god.number);
                System.out.println("Status                : " + god.status);

                System.out.println("\n -----------------------------------------------------------------------\n");
            }
        } else {
            System.out.println("\nNo Donor's Found");
        }
    }
}
