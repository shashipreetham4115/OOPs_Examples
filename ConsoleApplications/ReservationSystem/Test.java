package ConsoleApplications.ReservationSystem;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        boolean isValid = false;
        TicketBook book = new TicketBook();
        DB val = new DB();
        Scanner sc = new Scanner(System.in);
        int user_id = -1;
        while (true) {
            while (!isValid) {
                System.out.print("\n Please Enter Your Username :");
                String username = sc.next();
                System.out.print("\n Please Enter Your Password :");
                String password = sc.next();
                user_id = val.ValidateUser(username, password);
                if (user_id > -1) {
                    isValid = true;
                    val.greetUser(user_id);
                } else
                    System.out.println("\nInvalid username or password");
            }
            while (isValid) {

                System.out.println("\nPlease Choose Your Choice");
                System.out.println("1. Book Ticket");
                System.out.println("2. Cancel Ticket");
                System.out.println("3. Print Ticket");
                System.out.println("4. Passenger List");
                System.out.println("5. Add New User");
                System.out.println("6. Change Password");
                System.out.println("7. Logout");
                System.out.println("8. Exit");
                System.out.print("Enter Your Choice Here : ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        if (TicketBook.totalNoofTickets > 0) {
                            System.out.print("Please Enter Name : ");
                            String name = sc.next();
                            System.out.print("Please Enter Age  : ");
                            int age = sc.nextInt();
                            book.bookTicket(name, age);
                        } else {
                            System.out.println("Tickets Not Available");
                        }
                        break;
                    }
                    case 2: {
                        System.out.print("\n Please Enter Ticket ID : ");
                        book.cancelTicket(sc.nextLong());
                        break;
                    }
                    case 3: {
                        System.out.print("\n Please Enter Ticket ID");
                        book.printTicket(sc.nextLong());
                        break;
                    }
                    case 4: {
                        book.printPassengers();
                        break;
                    }
                    case 5: {
                        System.out.print("Please Enter Username  :");
                        System.out.print("Please Enter Password  :");
                        System.out.print("Please Enter Full Name :");
                        val.addNewUser(sc.next(), sc.next(), sc.next());
                        break;
                    }
                    case 6: {
                        val.ChangePassword(user_id);
                        break;
                    }
                    case 7: {
                        isValid = false;
                        break;
                    }
                    case 8: {
                        sc.close();
                        System.exit(0);
                    }
                    default:
                        System.out.println("Please Choose Correct Choice");
                }
            }
        }
    }
}
