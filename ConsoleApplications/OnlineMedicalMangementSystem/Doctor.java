package ConsoleApplications.OnlineMedicalMangementSystem;

import java.util.*;

public class Doctor {
    String name, specialization, gender;
    int experience;
    String id;
    Date d = new Date();
    Map<String, String> slots = new HashMap<String, String>();

    Doctor(String name, int experience, String specialization, String gender) {
        this.name = name;
        this.experience = experience;
        this.specialization = specialization;
        this.gender = gender;
        this.id = "d" + d.getTime();

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
