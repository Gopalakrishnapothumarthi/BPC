import java.util.*;

public class BookingSystem {
    private List<Physiotherapist> physiotherapists;
    private List<Patient> patients;
    private List<Appointment> appointments;

    public BookingSystem(){
        this.physiotherapists=new ArrayList<>();
        this.patients=new ArrayList<>();
        this.appointments=new ArrayList<>();
    }

    public void addPatient(Patient patient){
        patients.add(patient);
    }
    //
    public void removePatient(Patient patient){
        patients.remove(patient);
    }
    //List<Appointment>
    public List<Appointment> getAvailableAppointment(){
        return appointments;
    }

    //
    public boolean bookAppointment(Patient patient, Appointment appointment) {
        // Check if the appointment time is already booked
        for (Appointment a : appointments) {
            if (a.getDateTime().equals(appointment.getDateTime()) && a.getPhysiotherapist().equals(appointment.getPhysiotherapist())) {
                System.out.println("Error: This appointment slot is already booked for"+ a.getPhysiotherapist().getName() +"!" );
                return false;
            }
            if (a.getPatient().equals(patient) && a.getDateTime().equals(appointment.getDateTime())) {
                System.out.println("Error:"+ patient.getName() +" already has an appointment at this time!");
                return false;
            }
        }

        // If no conflicts, book the appointment
        appointments.add(appointment);
        appointment.bookAppointment(patient);
        patient.bookAppointments(appointment);

        System.out.println("Appointment booked successfully for " + patient.getName() + " at " + appointment.getDateTime());
        return true;
    }

    //
    public boolean cancelAppointment(Patient patient, Appointment appointment) {
        if (appointments.contains(appointment) && appointment.getPatient().equals(patient)) {
            appointments.remove(appointment);
            System.out.println("Appointment cancelled for " + patient.getName());
            return true;
        }
        System.out.println("Error: Appointment not found or patient mismatch!");
        return false;
    }
    public void generateReport(){
        System.out.println("Booking Report:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment.getDetails());
        }
    }
}
