import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Treatment physioTreatment=new Treatment("Physical therapy");
        Treatment sportsTherapy = new Treatment("Sports therapy");
        Patient patient1= new Patient(1,"Jhon Doe","123 Main st","123-4534");
        Patient patient2 = new Patient(2, "Jane Smith", "456 Elm St", "987-6543");

        List<String> expertiseList=new ArrayList<>();
        expertiseList.add("Rehabilitation");
        Physiotherapist phy1=new Physiotherapist(1,"Dr. Smith","456 Health st", "555-1234",expertiseList);

        List<String> expertise2 = new ArrayList<>();
        expertise2.add("Sports Injury");
        Physiotherapist phy2 = new Physiotherapist(2, "Dr. Adams", "789 Therapy Ave", "666-4321", expertise2);

        Appointment appointment1 = new Appointment(101, physioTreatment, LocalDateTime.of(2025, 4, 15, 10, 0), patient1, phy1);
        Appointment appointment2 = new Appointment(102, sportsTherapy, LocalDateTime.of(2025, 4, 15, 10, 0), patient2, phy2);
        Appointment appointment3 = new Appointment(103, physioTreatment, LocalDateTime.of(2025, 4, 15, 10, 0), patient1, phy1); // Duplicate for testing

        // Create booking system
        BookingSystem bookingSystem = new BookingSystem();
        bookingSystem.addPatient(patient1);
        bookingSystem.addPatient(patient2);

        boolean booked=bookingSystem.bookAppointment(patient1,appointment1);
        boolean booked2 = bookingSystem.bookAppointment(patient2, appointment2);
        boolean booked3 = bookingSystem.bookAppointment(patient1, appointment3); // Should fail
        System.out.println("\n### Booking Report After Initial Booking ###");
        bookingSystem.generateReport();

        // Cancel an Appointment
        System.out.println("\n### Canceling Appointment for John Doe ###");
        boolean canceled = bookingSystem.cancelAppointment(patient1, appointment1);

        // Generate Report After Cancellation
        System.out.println("\n### Booking Report After Cancellation ###");
        bookingSystem.generateReport();

        // Rebook the Canceled Appointment
        System.out.println("\n### Rebooking Canceled Appointment ###");
        boolean rebooked = bookingSystem.bookAppointment(patient1, appointment1);

        // Generate Final Report
        System.out.println("\n### Final Booking Report ###");
        bookingSystem.generateReport();

    }
}