package ConsoleApplications.OnlineMedicalMangementSystem.HelperClasses;

public class MedicalReport extends Id {
    public String date, reason, doctorId, status, diagnosis, suggestions, donorId;

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
