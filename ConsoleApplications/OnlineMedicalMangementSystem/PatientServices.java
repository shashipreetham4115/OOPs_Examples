package ConsoleApplications.OnlineMedicalMangementSystem;

import java.util.*;

public interface PatientServices {
    abstract void ViewMedicalRecords(String patientId, Map<String, Doctor> doctors);

    abstract void BookAppointment(Map<String, Doctor> doctors, String patientId);
}
