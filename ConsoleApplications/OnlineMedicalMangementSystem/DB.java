package ConsoleApplications.OnlineMedicalMangementSystem;

import java.util.*;

public class DB extends Thread implements UserServices {

    private ArrayList<String> username = new ArrayList<String>();
    private ArrayList<String> password = new ArrayList<String>();
    private ArrayList<String> id_db = new ArrayList<String>();
    private Map<String, Doctor> doctor_db = new HashMap<String, Doctor>();
    private Map<String, Patient> patient_db = new HashMap<String, Patient>();

    Scanner sc = new Scanner(System.in);

    public DB() throws InterruptedException {
        username.add("shashi");
        username.add("mahesh");
        username.add("ajith");

        password.add("4501");
        password.add("4483");
        password.add("4000");

        Doctor d1 = new Doctor("Dr.Shashi", 8, "General Physician", "Male");
        id_db.add(d1.id);
        Thread.sleep(1);
        doctor_db.put(d1.id, d1);
        Doctor d2 = new Doctor("Dr.Mahesh", 13, "Gasstroenterologist", "Male");
        id_db.add(d2.id);
        Thread.sleep(1);
        doctor_db.put(d2.id, d2);

        Patient p1 = new Patient("Ajith", 21, "O-", "M", 8756575843l);
        id_db.add(p1.id);
        Thread.sleep(1);
        patient_db.put(p1.id, p1);

    }

    public int ValidateUser(String u, String p, boolean isPatient) {

        int u_id = username.indexOf(u);

        System.out.println(u_id != -1);

        if (u_id != -1) {
            System.out.println(id_db.get(u_id).charAt(0) == 'p' && isPatient);
            System.out.println(id_db.get(u_id).charAt(0) == 'd' && !isPatient);
            if (password.get(u_id).equals(p)) {
                if ((id_db.get(u_id).charAt(0) == 'p' && isPatient)
                        || (id_db.get(u_id).charAt(0) == 'd' && !isPatient)) {
                    return u_id;
                }
            }
        }
        return -1;
    }

    public Map<String, Doctor> getDoctorsList() {
        return doctor_db;
    }

    public Map<String, Patient> getPatientList() {
        return patient_db;
    }

    public Doctor getDoctor(String id) {
        return doctor_db.get(id);
    }

    public Patient getPatient(String id) {
        return patient_db.get(id);
    }

    public void addPatient() {
        System.out.print("Please Enter Your Name           : ");
        String name = sc.next();
        System.out.print("Please Enter Your Age            : ");
        int age = sc.nextInt();
        System.out.print("Please Enter Your BloodGroup     : ");
        String bloodGroup = sc.next();
        System.out.print("Please Enter Your Gender         : ");
        String gender = sc.next();
        System.out.print("Please Enter Your Mobile Number  : ");
        long number = sc.nextLong();
        String un;
        while (true) {
            System.out.print("Please Enter Username            : ");
            un = sc.next();
            if (username.indexOf(un) == -1)
                break;
            System.out.println("\nUsername already taken ,Please Enter other Username.\n");
        }
        System.out.print("Please Enter Password            : ");
        String pw = sc.next();
        Patient p = new Patient(name, age, bloodGroup, gender, number);
        username.add(un);
        password.add(pw);
        id_db.add(p.id);
        patient_db.put(p.id, p);
        System.out.println("New Patient Added Successfully");
    }

    public void addDoctor() {
        System.out.print("Please Enter Name           : ");
        String name = sc.next();
        System.out.print("Please Enter Experience     : ");
        int exp = sc.nextInt();
        System.out.print("Please Enter Specialization : ");
        String spe = sc.next();
        System.out.print("Please Enter Gender         : ");
        String gender = sc.next();
        String un;
        while (true) {
            System.out.print("Please Enter Username            : ");
            un = sc.next();
            if (username.indexOf(un) == -1)
                break;
            System.out.print("\nUsername not available ,\tPlease Enter other Username.\n");
        }
        System.out.print("Please Enter Password       : ");
        String pw = sc.next();
        Doctor d = new Doctor(name, exp, spe, gender);
        username.add(un);
        password.add(pw);
        id_db.add(d.id);
        doctor_db.put(d.id, d);
        System.out.println("New Doctor Added Successfully");
    }

    public void ChangePassword(int id) {
        System.out.println("Please Enter Your Old Password");
        if (password.get(id).equals(sc.next())) {
            System.out.println("Please Enter Your New Password");
            password.set(id, sc.next());
            System.out.println("Your Password has been changed Successfully");
        } else {
            System.out.println("You Have Entered Wrong Password");
        }
    }

    public String getUserID(int id) {
        return id_db.get(id);
    }

    public void greetUser(int user_id, boolean isPatient) {
        try {
            String key = id_db.get(user_id);
            System.out.println("\nWelcome " + (isPatient ? patient_db.get(key).name : doctor_db.get(key).name));
        } catch (Exception e) {
            System.out.println("\nNo data found, Please Register if you are a new user\n");
        }
    }
}
