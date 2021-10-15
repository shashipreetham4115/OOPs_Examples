package ConsoleApplications.ReservationSystem;

import java.util.*;

public class DB {

    private ArrayList<String> username = new ArrayList<String>();
    private ArrayList<String> password = new ArrayList<String>();
    private ArrayList<String> fullname = new ArrayList<String>();

    DB() {
        username.add("shashi");
        username.add("mahesh");
        username.add("balaji");
        username.add("akash");

        password.add("4501");
        password.add("4483");
        password.add("4500");
        password.add("4484");

        fullname.add("Shashipreetham Reddy");
        fullname.add("Mahesh K");
        fullname.add("Balaji Royal");
        fullname.add("Akash B");
    }

    int ValidateUser(String u, String p) {
        int u_id = username.indexOf(u);
        int p_id = password.indexOf(p);
        if (u_id != -1 && p_id != -1)
            if (u_id == p_id)
                return u_id;
        return -1;
    }

    public void addNewUser(String u, String p, String f) {
        username.add(u);
        password.add(p);
        fullname.add(f);
        System.out.println("New User Added Successfully");
    }

    public void ChangePassword(int id) {
        System.out.println("Please Enter Your Old Password");
        Scanner sc = new Scanner(System.in);
        if (password.get(id).equals(sc.next())) {
            System.out.println("Please Enter Your New Password");
            password.set(id, sc.next());
            sc.close();
            System.out.println("Your Password has been changed Successfully");
        } else {
            System.out.println("You Have Entered Wrong Password");
        }
    }

    public String getFullName(int id) {
        return fullname.get(id);
    }
}
