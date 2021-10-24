package ConsoleApplications.OnlineMedicalMangementSystem;

import java.util.*;

public interface DoctorServices {
    abstract void AddMedicalPrescription(String dID);

    abstract void ViewDoctorAppointments(Doctor d, Map<String, Patient> map);
}
