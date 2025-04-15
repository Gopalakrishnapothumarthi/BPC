import java.util.*;

public class BookingSystem {
    private List<Appointment> appointments = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public boolean bookAppointment(Appointment appointment) {
        for (Appointment existing : appointments) {
            if (existing.getDateTime().equals(appointment.getDateTime())
                    && existing.getPhysiotherapist().equals(appointment.getPhysiotherapist())
                    && !existing.getStatus().equals("Cancelled")) {
                System.out.println("Error: Appointment slot already booked for " + appointment.getPhysiotherapist().getName());
                return false;
            }
        }

        appointments.add(appointment);
        appointment.getPatient().bookAppointment(appointment);
        System.out.println("Appointment booked successfully for " + appointment.getPatient().getName() + " at " + appointment.getDateTime());
        return true;
    }

    public boolean cancelAppointment(Appointment appointment) {
        if (appointments.contains(appointment) && appointment.cancel()) {
            System.out.println("Appointment cancelled for " + appointment.getPatient().getName());
            return true;
        }
        System.out.println("Error: Appointment could not be cancelled.");
        return false;
    }

    public boolean attendAppointment(Appointment appointment) {
        if (appointment.attend()) {
            System.out.println("Appointment attended by " + appointment.getPatient().getName());
            return true;
        }
        System.out.println("Error: Appointment " + appointment.getDetails() + " cannot be marked as attended. Current status: " + appointment.getStatus());
        return false;
    }

    public void generateReport() {
        System.out.println("Booking Report:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment.getDetails());
        }
    }

    public void listAvailableAppointments() {
        System.out.println("Available Appointments:");
        for (Appointment a : appointments) {
            if (a.isAvailable()) {
                System.out.println(a.getDetails());
            }
        }
    }
}
