import java.time.LocalDateTime;

public class Appointment {
    private int id;
    private Treatment treatement;
    private LocalDateTime dateTime;
    private Patient patient;
    private Physiotherapist physiotherapist;
    private String status;
    public Appointment(int id, Treatment treatment, LocalDateTime datetime, Patient patient, Physiotherapist physiotherapist ){
        this.id=id;
        this.treatement=treatment;
        this.dateTime=datetime;
        this.patient=patient;
        this.physiotherapist=physiotherapist;
        this.status="Scheduled";
    }
    public boolean bookAppointment(Patient patient){
        if(this.patient==null){
            this.patient=patient;
            this.status = "Booked";
            return true;
        }
        return false;
    }
    public boolean cancelAppointment(){
        if (this.status.equals("Booked")) {
            this.status = "Canceled";
            return true;
        }
        return false;
    }
    public void attendAppointment(){
        this.status="Completed";
    }
    public String getDetails() {
        return "Appointment ID: " + id + ", Treatment: " + treatement.getName() + ", Date: " + dateTime +
                ", Patient: " + patient.getName() + ", Physiotherapist: " + physiotherapist.getName() + ", Status: " + status;
    }

    public int getAppointmentID() { return id; }
    public Treatment getTreatment() { return treatement; }
    public LocalDateTime getDateTime() { return dateTime; }
    public Patient getPatient() { return patient; }
    public Physiotherapist getPhysiotherapist() { return physiotherapist; }
}
