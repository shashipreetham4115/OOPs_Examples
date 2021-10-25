package ConsoleApplications.OnlineMedicalMangementSystem;

import java.util.*;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        boolean isValid = false;
        boolean isPatient = false;
        DB val = new DB();
        ServicesForDoctor services = new ServicesForDoctor();
        Scanner sc = new Scanner(System.in);
        int user_id = -1;
        while (true) {
            while (!isValid) {
                System.out.println("\nWelcome to Online Medical Mangement System");
                System.out.println("\nAre You Doctor or Patient");
                System.out.println("1. Doctor");
                System.out.println("2. Patient");
                System.out.println("3. Donor");
                int choice = sc.nextInt();
                if (choice == 2) {
                    isPatient = true;
                    System.out.println("Please Choose your choice");
                    System.out.println("1. Register now");
                    System.out.println("2. Already Registered");
                    if (sc.nextInt() == 1) {
                        val.addPatient();
                    }
                } else if (choice == 3) {
                    System.out.println("\n-------Thank you for your help--------\n");
                    System.out.print("Please Enter Your Name             : ");
                    String name = sc.next();
                    System.out.print("Please Enter Your Age              : ");
                    int age = sc.nextInt();
                    System.out.print("Please Enter Your Gender           : ");
                    String gender = sc.next();
                    System.out.print("Please Enter Your Blood Group      : ");
                    String bg = sc.next();
                    System.out.print("Please Enter What You Are Donating : ");
                    String organ = sc.next();
                    System.out.print("Do You Have Any Health Issues      : ");
                    String issues = sc.next();
                    System.out.print("Are you Phyisically Handicaped     : ");
                    boolean phc = sc.next().toLowerCase().equals("yes");
                    System.out.print("Please Enter Your Mobile Number    : ");
                    long number = sc.nextLong();
                    Donor god = new Donor(name, age, gender, bg, organ, issues, phc, number, "Ready to Donate");
                    services.donors_db.put(god.id, god);

                    System.out.println("\nYour Details Have Been Added Successfully");

                    System.out.println("\n -----------------------------------------------------------------------\n");
                    System.out.println("Name                  : " + god.name);
                    System.out.println("Age                   : " + god.age);
                    System.out.println("Gender                : " + god.gender);
                    System.out.println("Blood Group           : " + god.bg);
                    System.out.println("Donating              : " + god.organ);
                    System.out.println("Health Issues         : " + god.issues);
                    System.out.println(god.phc ? "Physically Handicaped : Yes" : "Physically Handicaped : No");
                    System.out.println("Phone Number          : " + god.number);
                    System.out.println("Status                : " + god.status);
                    System.out.println("\n -----------------------------------------------------------------------\n");

                    System.out.println("Thank You For Your Help\n\n");

                    break;

                }
                System.out.println("\n ------------- LOGIN --------------");
                System.out.print("\nPlease Enter Your Username :");
                String username = sc.next();
                System.out.print("\nPlease Enter Your Password :");
                String password = sc.next();
                user_id = val.ValidateUser(username, password, isPatient);
                if (user_id > -1) {
                    isValid = true;
                    val.greetUser(user_id, isPatient);
                } else
                    System.out.println("\nInvalid username or password " + user_id);
            }

            while (isValid) {
                if (isPatient) {
                    System.out.println("\nPlease Choose Your Choice");
                    System.out.println("1. Book Appointment with Doctor");
                    System.out.println("2. Find Donor's");
                    System.out.println("3. View Your Medical Reports");
                    System.out.println("4. Change Password");
                    System.out.println("5. Logout");
                    System.out.println("6. Exit");
                    System.out.print("Enter Your Choice Here : ");
                    int choice = sc.nextInt();
                    switch (choice) {
                    case 1: {
                        services.BookAppointment(val.getDoctorsList(), val.getUserID(user_id));
                        break;
                    }
                    case 2: {
                        services.ViewDonors();
                        break;
                    }
                    case 3: {
                        services.ViewMedicalRecords(val.getUserID(user_id), val.getDoctorsList());
                        break;
                    }
                    case 4: {
                        val.ChangePassword(user_id);
                        break;
                    }
                    case 5: {
                        isValid = false;
                        isPatient = false;
                        break;
                    }
                    case 6: {
                        sc.close();
                        System.exit(0);
                        break;
                    }
                    default:
                        System.out.println("Please Choose Correct Choice");
                    }
                } else {
                    System.out.println("\nPlease Choose Your Choice");
                    System.out.println("1. View Appointments");
                    System.out.println("2. Add Medical Reports");
                    System.out.println("3. View Patient's Medical Records");
                    System.out.println("4. Add New Doctor");
                    System.out.println("5. Change Password");
                    System.out.println("6. Logout");
                    System.out.println("7. Exit");
                    System.out.print("Enter Your Choice Here : ");
                    int choice = sc.nextInt();
                    switch (choice) {
                    case 1: {
                        Doctor d = val.getDoctor(val.getUserID(user_id));
                        services.ViewDoctorAppointments(d, val.getPatientList());
                        break;
                    }
                    case 2: {
                        services.AddMedicalPrescription(val.getUserID(user_id));
                        break;
                    }
                    case 3: {
                        System.out.print("\nPlease Enter Patient ID : ");
                        services.ViewMedicalRecords(sc.next(), val.getDoctorsList());
                        break;
                    }
                    case 4: {
                        val.addDoctor();
                        break;
                    }
                    case 5: {
                        val.ChangePassword(user_id);
                        break;
                    }
                    case 6: {
                        isValid = false;
                        isPatient = false;
                        break;
                    }
                    case 7: {
                        sc.close();
                        System.exit(0);
                        break;
                    }
                    default:
                        System.out.println("Please Choose Correct Choice");
                    }
                }
            }
        }

    }
}
