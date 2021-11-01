package ConsoleApplications.OnlineMedicalMangementSystem.HelperClasses;

import java.util.*;

public class Doctor extends Human {
    public String specialization;
    public int experience;

    public Map<String, String> slots = new HashMap<String, String>();

    public Doctor(String name, int experience, String specialization, String gender) {
        this.name = name;
        this.experience = experience;
        this.specialization = specialization;
        this.gender = gender;
        this.id = "d";

        slots.put("9:00 AM", "");
        slots.put("10:00 AM", "");
        slots.put("11:00 AM", "");
        slots.put("12:00 PM", "");
        slots.put("1:30 PM", "");
        slots.put("2:30 PM", "");
        slots.put("3:30 PM", "");
        slots.put("4:30 PM", "");
        slots.put("5:30 PM", "");

    }
}
