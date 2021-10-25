package ConsoleApplications.OnlineMedicalMangementSystem;

import java.util.Date;

public class MedicalReport {
    String date, reason, doctorId, id, status, diagnosis, suggestions, donorId;
    Date d = new Date();

    MedicalReport(String date, String reason, String status, String diagnosis, String suggestions, String doctorId,
            String donorId) {
        this.date = date;
        this.reason = reason;
        this.status = status;
        this.diagnosis = diagnosis;
        this.doctorId = doctorId;
        this.doctorId = doctorId;
        this.suggestions = suggestions;
        this.id = Long.toString(d.getTime());
    }
}
