import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Setup
        Treatment physio = new Treatment("Physical therapy");
        Treatment sports = new Treatment("Sports therapy");

        Patient john = new Patient(1, "Jhon Doe", "123 Main St", "123-4534");
        Patient jane = new Patient(2, "Jane Smith", "456 Elm St", "987-6543");

        Physiotherapist smith = new Physiotherapist(1, "Dr. Smith", "456 Health St", "555-1234", List.of("Rehab"));
        Physiotherapist adams = new Physiotherapist(2, "Dr. Adams", "789 Therapy Ave", "666-4321", List.of("Sports Injury"));

        Appointment a1 = new Appointment(101, physio, LocalDateTime.of(2025, 4, 15, 10, 0), john, smith);
        Appointment a2 = new Appointment(102, sports, LocalDateTime.of(2025, 4, 15, 10, 0), jane, adams);
        Appointment a3 = new Appointment(103, physio, LocalDateTime.of(2025, 4, 15, 10, 0), john, smith); // Duplicate for testing

        BookingSystem system = new BookingSystem();
        system.addPatient(john);
        system.addPatient(jane);

        // Bookings
        system.bookAppointment(a1);
        system.bookAppointment(a2);
        system.bookAppointment(a3); // Should fail

        // Report
        System.out.println("\n### Booking Report After Initial Booking ###");
        system.generateReport();

        // Cancel
        System.out.println("\n### Canceling Appointment for John Doe ###");
        system.cancelAppointment(a1);

        System.out.println("\n### Booking Report After Cancellation ###");
        system.generateReport();

        // Rebook (should succeed now)
        Appointment a4 = new Appointment(104, physio, LocalDateTime.of(2025, 4, 15, 10, 30), john, smith);
        system.bookAppointment(a4);

        // Attend
        System.out.println("\n### Attending Appointment ###");
        system.attendAppointment(a4);

        // Final Report
        System.out.println("\n### Final Booking Report ###");
        system.generateReport();

        // Available
        System.out.println("\n### Available Appointments ###");
        system.listAvailableAppointments();
    }
}
