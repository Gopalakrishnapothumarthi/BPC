import java.time.LocalDateTime;

public class Appointment {
    private int id;
    private Treatment treatment;
    private LocalDateTime dateTime;
    private Patient patient;
    private Physiotherapist physiotherapist;
    private String status; // Scheduled, Cancelled, Attended

    public Appointment(int id, Treatment treatment, LocalDateTime dateTime, Patient patient, Physiotherapist physiotherapist) {
        this.id = id;
        this.treatment = treatment;
        this.dateTime = dateTime;
        this.patient = patient;
        this.physiotherapist = physiotherapist;
        this.status = "Scheduled";
    }

    public boolean isAvailable() {
        return status.equals("Scheduled");
    }

    public boolean cancel() {
        if (!status.equals("Cancelled")) {
            status = "Cancelled";
            return true;
        }
        return false;
    }

    public boolean attend() {
        if (status.equals("Scheduled")) {
            status = "Attended";
            return true;
        }
        return false;
    }

    public String getDetails() {
        return "Appointment ID: " + id + ", Treatment: " + treatment.getName() + ", Date: " + dateTime +
                ", Patient: " + patient.getName() + ", Physiotherapist: " + physiotherapist.getName() +
                ", Status: " + status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public Physiotherapist getPhysiotherapist() {
        return physiotherapist;
    }

    public String getStatus() {
        return status;
    }
}
